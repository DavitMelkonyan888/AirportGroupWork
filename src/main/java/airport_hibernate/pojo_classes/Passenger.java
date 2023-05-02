package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table ( name = "passenger")
public class Passenger {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private long               id;
    @Column ( name = "name" )
    private String            name;
    @Column ( name = "phone" )
    private String            phone;

    @Embedded
    private Address          address;
    @OneToMany ( mappedBy = "passenger" )
    private List <PassInTrip> passInTrips;
    
    public Passenger () {}
    
    public Passenger (final String name, final String phone, final Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    public long getId () {
        return id;
    }
    
    public void setId (final long id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (final String name) {
        this.name = name;
    }
    
    public String getPhone () {
        return phone;
    }
    
    public void setPhone (final String phone) {
        this.phone = phone;
    }
    
    public Address getAddress () {
        return address;
    }
    
    public void setAddress (final Address address) {
        this.address = address;
    }

    public void setPassInTrips(final List<PassInTrip> passInTrips) {
        this.passInTrips = passInTrips;
    }

    public List<PassInTrip> getPassInTrips() {
        return passInTrips;
    }
}
