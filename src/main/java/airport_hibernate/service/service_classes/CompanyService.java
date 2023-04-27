package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.abstract_service.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class CompanyService implements Service <Company> {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    private final Session        session        = sessionFactory.openSession();
    
    /**
     * @param id
     * @return
     */
    @Override
    public Company getById (long id) {
        return session.get(Company.class, id);
    }
    
    /**
     * @return
     */
    @Override
    public Set <Company> getAll () {
        return null;
    }
    
    /**
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    @Override
    public Set <Company> get (int offset, int perPage, String sort) {
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (Company object) {
    
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (Company object, long id) {
    
    }
    
    /**
     * @param id
     */
    @Override
    public void delete (long id) {
    
    }
    
    /**
     * @param object
     * @return
     */
    @Override
    public String toString (Company object) {
        return "Company";
    }
    
    /**
     * @return
     */
    @Override
    public void close () {
        session.close();
    }
}
