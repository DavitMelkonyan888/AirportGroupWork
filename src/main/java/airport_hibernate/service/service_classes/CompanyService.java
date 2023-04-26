package airport_hibernate.service.service_classes;

import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.abstract_service.Service;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class CompanyService implements Service<Company> {
    
    private final SessionFactory sessionFactory;
    private final Session session;
    
    public CompanyService (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        try{
            session = sessionFactory.openSession();
        } catch(HibernateException e){
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
    
    /**
     * @param id
     * @return
     */
    @Override
    public Company getById (long id) {
        return null;
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
        return null;
    }
}
