package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.abstract_service.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashSet;
import java.util.Set;

public class CompanyService implements Service <Company> {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    private Session     session;
    
    /**
     * @param id
     * @return
     */
    @Override
    public Company getById (final long id) {
        session = sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Company> getAll () {
        Set<Company> company = new HashSet<>();
        session = sessionFactory.openSession();
        company.addAll(session.createQuery("from Company").getResultList());
        session.close();
        return company;
    }
    
    /**
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    @Override
    public Set <Company> get (final int offset, final int perPage, final String sort) {
        session = sessionFactory.openSession();

        session.close();
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (final Company object) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (final Company object, final long id) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param id
     */
    @Override
    public void delete (final long id) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param object
     * @return
     */
    @Override
    public String toString (final Company object) {
        return "Company";
    }

}