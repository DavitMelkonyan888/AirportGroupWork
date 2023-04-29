package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class PassengerService implements airport_hibernate.service.abstract_service.Passenger {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    private Session        session        = sessionFactory.openSession();
    
    /**
     * @param tripId
     * @return
     */
    @Override
    public List <Passenger> getPassengersOfTrip (long tripId) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @param trip
     * @param passenger
     */
    @Override
    public void registerTrip (Trip trip, Passenger passenger) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param passengerId
     * @param tripId
     */
    @Override
    public void cancelTrip (long passengerId, long tripId) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param id
     * @return
     */
    @Override
    public Passenger getById (long id) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Passenger> getAll () {
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
    public Set <Passenger> get (int offset, int perPage, String sort) {
        session = sessionFactory.openSession();
        session.close();
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (Passenger object) {
        session = sessionFactory.openSession();
        session.close();
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (Passenger object, long id) {
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
    public String toString (Passenger object) {
        return null;
    }
}
