package airport_hibernate.service.service_classes;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.PassInTrip;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.*;

public class PassengerService implements airport_hibernate.service.abstract_service.Passenger {
    
    // Load Hibernate configuration
    private final SessionFactory sessionFactory = Connection.getSessionFactory();

    
    /**
     * @param tripId
     * @return
     */
    @Override
    public List <Passenger> getPassengersOfTrip (final long tripId) {
        List<Passenger> passengers = null;
        try(Session session = sessionFactory.openSession()) {
            List<PassInTrip> passInTrips = new ArrayList<>(session.createQuery("from PassInTrip pit where pit.trip.id = ?1", PassInTrip.class).setParameter(1, tripId).getResultList());
            for (PassInTrip pit: passInTrips) {
                passengers = new ArrayList<>();
                passengers.add(pit.getPassenger());
            }
            passInTrips.clear();

        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return passengers;
    }
    
    /**
     * @param trip
     * @param passenger
     */
    @Override
    public void registerTrip (final Trip trip, final Passenger passenger, final Timestamp date, String place) {
        try (Session session = sessionFactory.openSession()) {
            PassInTrip passInTrip = new PassInTrip(trip, passenger, date, place);
            session.save(passInTrip);
        }catch (HibernateException e) {
            e.printStackTrace();
        }


    }
    
    /**
     * @param passengerId
     * @param tripId
     */
    @Override
    public void cancelTrip (final long passengerId, final long tripId) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<PassInTrip> pit = new ArrayList<>(session.createQuery("from PassInTrip pit where pit.passenger.id = ?1 and pit.trip.id = ?2" )
                   .setParameter(1, passengerId).setParameter(2, tripId).getResultList());
            PassInTrip passInTrip = new PassInTrip(pit.get(0).getTrip(), pit.get(0).getPassenger(), pit.get(0).getDate(), pit.get(0).getPlace());
            pit.clear();
            session.delete(passInTrip);
            transaction.commit();
        }catch (HibernateException e) {
            assert transaction != null;
            e.printStackTrace();
        }

    }
    
    /**
     * @param id
     * @return
     */
    @Override
    public Passenger getById (final long id) {
        Passenger passenger = null;
        try(Session session = sessionFactory.openSession()){
            passenger = session.get(Passenger.class, id);
        }catch (HibernateException e) {
            e.printStackTrace();
        }

        return passenger;
    }
    
    /**
     * @return
     */
    @Override
    public Set <Passenger> getAll () {
        Set<Passenger> passengers = new LinkedHashSet<>();
        try (Session session = sessionFactory.openSession()) {
            passengers.addAll(session.createQuery("from Passenger").getResultList());
        }catch (HibernateException e) {
            e.printStackTrace();
        }
        return passengers;
    }
    
    /**
     * @param offset
     * @param limit
     * @param sort
     * @return
     */
    @Override
    public Set <Passenger> get (final int offset, final int limit, final String sort) {
        Set<Passenger> passengers = new HashSet<>();
        try(Session session = sessionFactory.openSession()) {
            passengers.addAll(session.createQuery("from Passenger order by" + sort)
                    .setFirstResult(offset).setMaxResults(limit).getResultList());
            return passengers;
        }catch (HibernateException e) {
            e.printStackTrace();
        }

        return null;
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
     * @param id
     */
    @Override
    public void update (final Passenger passenger, final long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Passenger passenger1 = session.get(Passenger.class, id);
            passenger1.setPassInTrips(passenger.getPassInTrips());
            passenger1.setAddress(passenger.getAddress());
            passenger1.setName(passenger.getName());
            passenger1.setPhone(passenger.getPhone());
            session.update(passenger1);
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
            session.detach(passenger);
            transaction.commit();
        }catch (HibernateException e) {
            assert transaction != null;
            e.printStackTrace();
        }

    }
    
    /**
     * @param object
     * @return
     */
    @Override
    public String toString (final Passenger object) {
        return "Passenger{" +
                "id=" + object.getId() +
                ", name='" + object.getName() + '\'' +
                ", phone='" + object.getPhone() + '\'' +
                ", address=" + "country=" + object.getAddress().getCountry() + "city="
                                          + object.getAddress().getCity() +'\'' +
                ", passInTrips=" + object.getPassInTrips() +
                '}';
    }
}
