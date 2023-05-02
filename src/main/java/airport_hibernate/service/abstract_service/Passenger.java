package airport_hibernate.service.abstract_service;


import airport_hibernate.pojo_classes.Trip;

import java.sql.Timestamp;
import java.util.List;

public interface Passenger extends Service<airport_hibernate.pojo_classes.Passenger> {
    List<airport_hibernate.pojo_classes.Passenger> getPassengersOfTrip(long tripId);
    
    void registerTrip (final Trip trip, final airport_hibernate.pojo_classes.Passenger passenger, final Timestamp date, String place);
    
    void cancelTrip(long passengerId, long tripId);
    
}
