package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TripService implements airport_hibernate.service.abstract_service.Trip {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();
    
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
     * @param id
     */
    @Override
    public void update (final Trip trip, final long id) {
        try(final Session session = sessionFactory.openSession()){
            Trip          ent     = session.get(Trip.class, id);
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
    public void delete (final long id) {
        try(final Session session = sessionFactory.openSession()){
            Trip          trip    = session.get(Trip.class, id);
            session.delete(trip);
        }
    }
    
    /**
     * @param trip
     * @return
     */
    @Override
    public String toString (final Trip trip) {
        return "Trip{" +
                "id=" + trip.getId() +
                ", company=" + new CompanyService().toString(trip.getCompany()) +
                ", townFrom='" + trip.getTownFrom() + '\'' +
                ", townTo='" + trip.getTownTo() + '\'' +
                ", timeOut=" + trip.getTimeOut() +
                ", timeIn=" + trip.getTimeIn() + '}';
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
