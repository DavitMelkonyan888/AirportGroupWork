package airport_hibernate.data_insert;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

public class InsertDataToAllTables {
    // Load Hibernate configuration
    private static final SessionFactory sessionFactory = getSessionFactory();
    private static final Session session = sessionFactory.openSession();
    
    private static void AddressFileImporter(final String path) {
        // Open file for reading
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

            // Read each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                
                // Create a new Address object with filled data
                Address address = new Address(fields[2], fields[3]);
                
                // Save the object to the database
                Transaction transaction = session.beginTransaction();
                session.save(address);
                transaction.commit();
            }

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void CompanyFileImporter(String path) {
            // Open file for reading
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

            
            // Read each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                
                // Create a new Company object with filled data
                Company company = new Company();
                
                // Set the object properties from the file fields
                company.setName(fields[0]);
                String   foundingDate = fields[1];
                String[] dt           = foundingDate.split("/");
                foundingDate = dt[2] + "-" + dt[0] + "-" + dt[1];
                company.setFoundingDate(Date.valueOf(foundingDate));
                
                // Save the object to the database
                Transaction transaction = session.beginTransaction();
                session.save(company);
                transaction.commit();
            }
            

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void PassengerFileImporter(String path) {
        // Open file for reading
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {


            
            // Read each line of the file
            String line;
            int    counterForAddressId = 1;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                
                // Create a new Passenger object with filled data
                Passenger passenger = new Passenger(fields[0], fields[1], session.get(Address.class, counterForAddressId++));
                
                // Save the object to the database
                Transaction transaction = session.beginTransaction();
                session.save(passenger);
                transaction.commit();
            }
            

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void PassInTripFileImporter(String path) {
        
        
        
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            // Open file for reading

            
            // Read each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                
                // Create a new PassInTrip object
                PassInTrip passInTrip = new PassInTrip();
                
                // Set the object properties from the file fields
                passInTrip.setTrip(session.get(Trip.class, Integer.parseInt(fields[0])));
                passInTrip.setPassenger(session.get(Passenger.class, Integer.parseInt(fields[1])));
                passInTrip.setDate(Timestamp.valueOf(fields[2]));
                passInTrip.setPlace(fields[3]);
                
                // Save the object to the database
                Transaction transaction = session.beginTransaction();
                session.save(passInTrip);
                transaction.commit();
            }
            

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void TripFileImporter(String path) {
        

        // Open file for reading
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {


            
            // Read each line of the file
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = line.split(",");
                
                // Create a new Trip object
                Trip trip = new Trip();
                
                // Set the object properties from the file fields
                trip.setId(Integer.parseInt(fields[0]));
                trip.setCompany(session.get(Company.class, Integer.parseInt(fields[1])));
                trip.setTownFrom(fields[3]);
                trip.setTownTo(fields[4]);
                trip.setTimeOut(Timestamp.valueOf(fields[5]));
                trip.setTimeIn(Timestamp.valueOf(fields[6]));
                
                // Save the object to the database
                Transaction transaction = session.beginTransaction();
                session.save(trip);
                transaction.commit();
            }
            

        } catch (HibernateException | IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args) {
        // Close the Hibernate session
        try{
            CompanyFileImporter("src/main/resources/datas/companies.txt");
            AddressFileImporter("src/main/resources/datas/passengers.txt");
            PassengerFileImporter("src/main/resources/datas/passengers.txt");
            TripFileImporter("src/main/resources/datas/trip.txt");
            PassInTripFileImporter("src/main/resources/datas/pass_in_trip.txt");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}