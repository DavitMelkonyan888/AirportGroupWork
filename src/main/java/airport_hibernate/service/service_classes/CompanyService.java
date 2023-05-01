package airport_hibernate.service.service_classes;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.abstract_service.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedHashSet;
import java.util.Set;

public class CompanyService implements Service <Company> {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = getSessionFactory();
    
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
     * @param id
     */
    @Override
    public void update (Company company, long id) {
        try(final Session session = sessionFactory.openSession()){
            Company ent = session.get(Company.class, id);
            ent.setName(company.getName());
            session.update(ent);
        }
    }
    
    /**
     * @param id
     */
    @Override
    public void delete (long id) {
        try(final Session session = sessionFactory.openSession()){
            Company company = session.get(Company.class, id);
            session.delete(company);
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
