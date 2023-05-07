package airport_hibernate.service.service_classes;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import static airport_hibernate.service.single_tone_objects.SingleTonService.*;

import airport_hibernate.pojo_classes.PassInTrip;
import airport_hibernate.pojo_classes.Trip;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TripService implements airport_hibernate.service.abstract_service.Trip {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = getSessionFactory();

    private static TripService tripService;

    private TripService(){}

    public static TripService getInstance() {
        if (tripService == null)
            tripService = new TripService();
        return tripService;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Trip getById (final long id) {
        Trip trip;
        try(final Session session = sessionFactory.openSession()){
            trip = session.get(Trip.class, id);
        }
        return trip;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Trip> getAll () {
        Set <Trip>    set;
        try(final Session session = sessionFactory.openSession()){
            set = new LinkedHashSet <>(session.createQuery("FROM Trip").getResultList());
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
    public Set<Trip> get(final int limit, final int offset, final String sortBy) {
        Set<Trip> set;
        try(final Session session = sessionFactory.openSession()) {
            String queryString = "FROM Trip";
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
     * @param trip
     */
    @Override
    public void save (final Trip trip) {
        try(final Session session = sessionFactory.openSession()) {
            session.save(trip);
        }
    }
    
    /**
     * @param trip
     */
    @Override
    public void update (final Trip trip) {
        try(final Session session = sessionFactory.openSession()){
            Trip          ent     = session.get(Trip.class, trip.getId());
            ent.setTownFrom(trip.getTownFrom());
            ent.setTownTo(trip.getTownTo());
            ent.setTimeOut(trip.getTimeOut());
            ent.setTimeIn(trip.getTimeIn());
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
            Trip trip = session.get(Trip.class, id);
            for (PassInTrip i : trip.getPassInTrips()) {
                Query query = session.createQuery("delete from PassInTrip where id = :id");
                query.setParameter("id", i.getId());
                query.executeUpdate();
            }
            Query query = session.createQuery("delete from Trip where id = :id");
            query.setParameter("id", trip.getId());
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
     * @param trip
     * @return
     */
    @Override
    public String toString (final Trip trip) {
        return "Trip{ " +
                "id= " + trip.getId() +
                ", company= " + getCompanyService().toString(trip.getCompany()) +
                ", townFrom= '" + trip.getTownFrom() + '\'' +
                ", townTo= '" + trip.getTownTo() + '\'' +
                ", timeOut= " + trip.getTimeOut() +
                ", timeIn= " + trip.getTimeIn() + " }";
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsFrom (final String city) {
        List <Trip> resultList;
        try(final Session session = sessionFactory.openSession()) {
            String      queryString = "FROM Trip WHERE  townFrom  = :city";
            resultList  = session.createQuery(queryString, Trip.class)
                    .setParameter("city", city)
                    .getResultList();
        }
        return resultList;
    }
    
    /**
     * @param city
     * @return
     */
    @Override
    public List <Trip> getTripsTo (final String city) {
        List <Trip>   resultList;
        try(final Session session     = sessionFactory.openSession()){
            String        queryString = "FROM Trip WHERE  townTo  = :city";
            resultList = session.createQuery(queryString, Trip.class)
                    .setParameter("city", city)
                    .getResultList();
        }
        return resultList;
    }
}
