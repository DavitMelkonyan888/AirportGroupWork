package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table ( name = "address" )
public class Address {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private int              id;
    @Column ( name = "country" )
    private String           country;
    @Column ( name = "city" )
    private String           city;
    @OneToMany ( mappedBy = "address" )
    private List <Passenger> passengers;
    
    
    public Address () {}
    
    public Address (String country, String city) {
        this.country = country;
        this.city = city;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getCountry () {
        return country;
    }
    
    public void setCountry (String country) {
        this.country = country;
    }
    
    public String getCity () {
        return city;
    }
    
    public void setCity (String city) {
        this.city = city;
    }
    
    public List <Passenger> getPassengers () {
        return passengers;
    }
    
    public void setPassengers (List <Passenger> passengers) {
        this.passengers = passengers;
    }
}
