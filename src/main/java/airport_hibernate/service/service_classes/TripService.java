package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class TripService implements airport_hibernate.service.abstract_service.Trip {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    private Session        session        = sessionFactory.openSession();
    
    /**
     * @param id
     * @return
     */
    @Override
    public Trip getById (long id) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Trip> getAll () {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    @Override
    public Set <Trip> get (int offset, int perPage, String sort) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (Trip object) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (Trip object, long id) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param id
     */
    @Override
    public void delete (long id) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param object
     * @return
     */
    @Override
    public String toString (Trip object) {
        return null;
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsFrom (String city) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsTo (String city) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
}
