package airport_hibernate.service.service_classes;

import airport_hibernate.pojo_classes.Trip;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Set;

public class TripService implements airport_hibernate.service.abstract_service.Trip{
    
    private final SessionFactory sessionFactory;
    
    public TripService (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /**
     * @param id
     * @return
     */
    @Override
    public Trip getById (long id) {
        return null;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Trip> getAll () {
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
        return null;
    }
    
    /**
     * @param object
     */
    @Override
    public void save (Trip object) {
    
    }
    
    /**
     * @param object
     * @param id
     */
    @Override
    public void update (Trip object, long id) {
    
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
    public String toString (Trip object) {
        return null;
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsFrom (String city) {
        return null;
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsTo (String city) {
        return null;
    }
}