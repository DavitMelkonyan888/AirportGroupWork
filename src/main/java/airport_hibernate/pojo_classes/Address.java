package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Address {
    

    @Column ( name = "country" )
    private String           country;
    @Column ( name = "city" )
    private String           city;
    
    
    public Address () {}
    
    public Address (final String country, final String city) {
        this.country = country;
        this.city = city;
    }
    

    
    public String getCountry () {
        return country;
    }
    
    public void setCountry (final String country) {
        this.country = country;
    }
    
    public String getCity () {
        return city;
    }
    
    public void setCity (final String city) {
        this.city = city;
    }

}
