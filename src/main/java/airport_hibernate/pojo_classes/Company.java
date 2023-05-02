package airport_hibernate.pojo_classes;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table ( name = "company" )
public class Company {
    
    @Id
    @GeneratedValue
    @Column ( name = "id" )
    private long              id;
    @Column ( name = "name" )
    private String           name;
    @Column ( name = "founding_date" )
    private Date             foundingDate;
    @OneToMany ( mappedBy = "company" )
    private List<Trip> trips;
    
    public Company () {}
    
    public Company (final String name, final Date foundingDate) {
        this.name = name;
        this.foundingDate = foundingDate;
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
    
    public Date getFoundingDate () {
        return foundingDate;
    }
    
    public void setFoundingDate (final Date foundingDate) {
        this.foundingDate = foundingDate;
    }
}
