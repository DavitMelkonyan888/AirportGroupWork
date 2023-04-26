package airport_hibernate.service.abstract_service;


import airport_hibernate.pojo_classes.Trip;

import java.util.List;

public interface Passenger extends Service<airport_hibernate.pojo_classes.Passenger> {
    public abstract List<airport_hibernate.pojo_classes.Passenger> getPassengersOfTrip(long tripId);
    public abstract void registerTrip(Trip trip, airport_hibernate.pojo_classes.Passenger passenger);
    public abstract void cancelTrip(long passengerId, long tripId);
    
}
