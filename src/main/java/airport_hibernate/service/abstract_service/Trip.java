package airport_hibernate.service.abstract_service;

import java.util.List;

public interface Trip extends Service<airport_hibernate.pojo_classes.Trip>{
    public abstract List<airport_hibernate.pojo_classes.Trip> getTripsFrom(String city);
    public abstract List<airport_hibernate.pojo_classes.Trip> getTripsTo(String city);
    
}
