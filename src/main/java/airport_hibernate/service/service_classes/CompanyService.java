package airport_hibernate.service.service_classes;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.pojo_classes.Trip;
import airport_hibernate.service.abstract_service.Service;
import airport_hibernate.service.single_tone_objects.SingleTonService;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompanyService implements Service <Company> {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = getSessionFactory();
    private static  CompanyService companyService;
    private CompanyService(){}

    public static CompanyService getInstance() {
        if (companyService == null)
            companyService = new CompanyService();
        return companyService;
    }
    /**
     * @param id
     * @return
     */
    @Override
    public Company getById (long id) {
        Company company;
        try(final Session session = sessionFactory.openSession()) {
            company = session.get(Company.class, id);
        }
        return company;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Company> getAll () {
        Set <Company> set;
        try(final Session session = sessionFactory.openSession()) {
            set = new LinkedHashSet <>(session.createQuery("FROM Company").getResultList());
        }
        return set;
    }
    
    /**
     * @param limit
     * @param offset
     * @param sortBy
     * @return
     */
    @Override
    public Set <Company> get (int limit, int offset, String sortBy) {
        Set <Company> set;
        try(final Session session = sessionFactory.openSession()){
            String queryString = "FROM Company";
            if (sortBy != null) {
                queryString += " ORDER BY " + sortBy;
            }
            set = new LinkedHashSet <>(session.createQuery(queryString)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList());
        }
        return set;
    }
    
    /**
     * @param company
     */
    @Override
    public void save (Company company) {
        try(final Session session = sessionFactory.openSession()){
            session.save(company);
        }
    }
    
    /**
     * @param company
     */
    @Override
    public void update (Company company) {
        try(final Session session = sessionFactory.openSession()){
            Company ent = session.get(Company.class, company.getId());
            ent.setName(company.getName());
            session.update(ent);
        }
    }
    
    /**
     * @param id
     */
    @Override
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Company company = session.get(Company.class, id);
            for (Trip i : company.getTrips()) {
                SingleTonService.getTripService().delete(i.getId());
            }
            Query query = session.createQuery("delete from Company where id = :id");
            query.setParameter("id", company.getId());
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
    
    /**
     * @param company
     * @return
     */
    @Override
    public String toString (Company company) {
        return "Company{ " +
                "id= " + company.getId() +
                ", name= '" + company.getName() + '\'' +
                ", foundingDate= " + company.getFoundingDate() + " }";
    }
}
