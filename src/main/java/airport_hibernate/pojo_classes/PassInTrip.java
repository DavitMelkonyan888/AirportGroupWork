package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table ( name = "pass_in_trip" )
public class PassInTrip {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private long       id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn ( name = "trip_id" )
    private Trip      trip;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn ( name = "passenger_id" )
    private Passenger passenger;
    @Column ( name = "date" )
    private Timestamp date;
    @Column ( name = "place" )
    private String    place;
    
    
    public PassInTrip () {}
    
    public PassInTrip (final Trip trip, final Passenger passenger, final Timestamp date, final String place) {
        this.trip = trip;
        this.passenger = passenger;
        this.date = date;
        this.place = place;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (final long id) {
        this.id = id;
    }
    
    public Trip getTrip () {
        return trip;
    }
    
    public void setTrip (final Trip trip) {
        this.trip = trip;
    }
    
    public Passenger getPassenger () {
        return passenger;
    }
    
    public void setPassenger (final Passenger passenger) {
        this.passenger = passenger;
    }
    
    public Timestamp getDate () {
        return date;
    }
    
    public void setDate (final Timestamp date) {
        this.date = date;
    }
    
    public String getPlace () {
        return place;
    }
    
    public void setPlace (final String place) {
        this.place = place;
    }
}
