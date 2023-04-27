package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class PassengerService implements airport_hibernate.service.abstract_service.Passenger {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    private final Session        session        = sessionFactory.openSession();
    
    /**
     * @param tripId
     * @return
     */
    @Override
    public List <Passenger> getPassengersOfTrip (long tripId) {
        return null;
    }
    
    /**
     * @param trip
     * @param passenger
     */
    @Override
    public void registerTrip (Trip trip, Passenger passenger) {
    
    }
    
    /**
     * @param passengerId
     * @param tripId
     */
    @Override
    public void cancelTrip (long passengerId, long tripId) {
    
    }
    
    /**
     * @param id
     * @return
     */
    @Override
    public Passenger getById (long id) {
        return null;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Passenger> getAll () {
        return null;
    }
    
    /**
     * @param offset
     * @param perPage
     * @param sort
     * @return
     */
    @Override
    public Set <Passenger> get (int offset, int perPage, String sort) {
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (Passenger object) {
    
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (Passenger object, long id) {
    
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
    public String toString (Passenger object) {
        return null;
    }
    
    /**
     *
     */
    @Override
    public void close () {
        session.close();
    }
}
