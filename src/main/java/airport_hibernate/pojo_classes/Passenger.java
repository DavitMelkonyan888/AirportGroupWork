package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table ( name = "passenger" )
public class Passenger {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private int               id;
    @Column ( name = "name" )
    private String            name;
    @Column ( name = "phone" )
    private String            phone;
    @ManyToOne
    @JoinColumn ( name = "address_id" )
    private Address           address;
    @OneToMany ( mappedBy = "passenger" )
    private List <PassInTrip> passInTrips;
    
    public Passenger () {}
    
    public Passenger (String name, String phone, Address address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    public int getId () {
        return id;
    }
    
    public void setId (int id) {
        this.id = id;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getPhone () {
        return phone;
    }
    
    public void setPhone (String phone) {
        this.phone = phone;
    }
    
    public Address getAddress () {
        return address;
    }
    
    public void setAddress (Address address) {
        this.address = address;
    }
}
