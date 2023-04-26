package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table ( name = "pass_in_trip" )
public class PassInTrip {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private int       id;
    @ManyToOne
    @JoinColumn ( name = "trip_id" )
    private Trip      trip;
    @ManyToOne
    @JoinColumn ( name = "passenger_id" )
    private Passenger passenger;
    @Column ( name = "date" )
    private Timestamp date;
    @Column ( name = "place" )
    private String    place;
    
    
    public PassInTrip () {}
    
    public PassInTrip (Trip trip, Passenger passenger, Timestamp date, String place) {
        this.trip = trip;
        this.passenger = passenger;
        this.date = date;
        this.place = place;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public Trip getTrip () {
        return trip;
    }
    
    public void setTrip (Trip trip) {
        this.trip = trip;
    }
    
    public Passenger getPassenger () {
        return passenger;
    }
    
    public void setPassenger (Passenger passenger) {
        this.passenger = passenger;
    }
    
    public Timestamp getDate () {
        return date;
    }
    
    public void setDate (Timestamp date) {
        this.date = date;
    }
    
    public String getPlace () {
        return place;
    }
    
    public void setPlace (String place) {
        this.place = place;
    }
}
