package airport_hibernate.service.service_classes;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.PassInTrip;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

import java.sql.Timestamp;
import java.util.*;

public class PassengerService implements airport_hibernate.service.abstract_service.Passenger {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = getSessionFactory();
    private static PassengerService passengerService;

    private PassengerService(){}

    public static PassengerService getInstance() {
        if (passengerService == null)
            passengerService = new PassengerService();
        return passengerService;
    }
    /**
     * @param tripId Trip ID
     * @return List <Passenger>
     */
    @Override
    public List <Passenger> getPassengersOfTrip (final long tripId) {
        List<Passenger> passengers;
        try(final Session session = sessionFactory.openSession()) {
            List<PassInTrip> passInTrips = session.createQuery("from PassInTrip pit where pit.trip.id = ?1", PassInTrip.class)
                    .setParameter(1, tripId)
                    .getResultList();
            passengers = new ArrayList<>();
            for (PassInTrip pit: passInTrips) {
                passengers.add(pit.getPassenger());
            }
            passInTrips.clear();
        }
        return passengers;
    }
    
    /**
     * @param trip Trip
     * @param passenger Passenger
     */
    @Override
    public void registerTrip (final Trip trip, final Passenger passenger, final Timestamp date, String place) {
        try (final Session session = sessionFactory.openSession()) {
            PassInTrip passInTrip = new PassInTrip(trip, passenger, date, place);
            session.save(passInTrip);
        }
    }
    
    /**
     * @param passengerId PassengerId
     * @param tripId TripId
     */
    @Override
    public void cancelTrip (final long passengerId, final long tripId) {
        Transaction transaction = null;
        try(final Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<PassInTrip> pit = session.createQuery("FROM PassInTrip pit WHERE pit.passenger.id = ?1 AND pit.trip.id = ?2" )
                    .setParameter(1, passengerId)
                    .setParameter(2, tripId)
                    .getResultList();
            PassInTrip passInTrip = pit.get(0);
            pit.clear();
            session.delete(passInTrip);
            transaction.commit();
        } finally {
            assert transaction != null;
            transaction.rollback();
        }
    }
    
    /**
     * @param id id
     * @return Passenger
     */
    @Override
    public Passenger getById (final long id) {
        Passenger passenger;
        try(final Session session = sessionFactory.openSession()){
            passenger = session.get(Passenger.class, id);
        }
        return passenger;
    }
    
    /**
     * @return Set <Passenger>
     */
    @Override
    public Set <Passenger> getAll () {
        Set<Passenger> passengers;
        try (final Session session = sessionFactory.openSession()) {
            passengers = new LinkedHashSet <>(session.createQuery("from Passenger").getResultList());
        }
        return passengers;
    }
    
    /**
     * @param limit
     * @param offset
     * @param sortBy
     * @return
     */
    @Override
    public Set <Passenger> get (final int limit, final int offset, final String sortBy) {
        Set<Passenger> passengers;
        try(final Session session = sessionFactory.openSession()) {
            String queryString = "FROM Passenger";
            if (sortBy != null) {
                queryString += " ORDER BY " + sortBy;
            }
            passengers = new LinkedHashSet <>(session.createQuery(queryString)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .getResultList());
        }
        return passengers;
    }
    
    /**
     * @param passenger
     */
    @Override
    public void save (final Passenger passenger) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(passenger);
            transaction.commit();
        }catch (HibernateException e) {
            assert transaction != null;
            e.printStackTrace();
        }

    }
    
    /**
     * @param passenger
     */
    @Override
    public void update (final @NotNull Passenger passenger) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Passenger ent = session.get(Passenger.class, passenger.getId());
            ent.setAddress(passenger.getAddress());
            ent.setPhone(passenger.getPhone());
            session.update(ent);
            transaction.commit();
        }catch (HibernateException e) {
            assert transaction != null;
            e.printStackTrace();
        }
    }
    
    /**
     * @param id
     */
    @Override
    public void delete (final long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Passenger passenger = session.get(Passenger.class, id);
            for (PassInTrip i: passenger.getPassInTrips()){
                session.createQuery("Delete From PassInTrip Where id = :id")
                        .setParameter("id", i.getId())
                        .executeUpdate();
            }
            session.createQuery("Delete From Passenger Where id = :id")
                    .setParameter("id", passenger.getId())
                    .executeUpdate();
            transaction.commit();
        }catch (HibernateException e) {
            assert transaction != null;
            e.printStackTrace();
        }
    }
    
    /**
     * @param passenger
     * @return
     */
    @Override
    public String toString (final @NotNull Passenger passenger) {
        return "Passenger{ " +
                "id= " + passenger.getId() +
                ", name= '" + passenger.getName() + '\'' +
                ", phone= '" + passenger.getPhone() + '\'' +
                ", address= " + "Address{ country='" + passenger.getAddress().getCountry() + "', city='"
                                          + passenger.getAddress().getCity() +'\'' +
                " } }";
    }
}
