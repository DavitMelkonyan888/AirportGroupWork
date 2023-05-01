package airport_hibernate.validation;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Validation {
    
    private final static SessionFactory sessionFactory = getSessionFactory();
    
    public static int getValidIntForSwitch(){
        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str     = scanner.next();
        while(!str.matches(regex)){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();
        }
        System.out.println();
        return Integer.parseInt(str);
    }
    
    public static boolean isValidCompanyId(final long id){
        final Session session = sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company != null;
    }
    
    public static boolean isValidTripId(final long id){
        final Session session = sessionFactory.openSession();
        Trip trip = session.get(Trip.class, id);
        session.close();
        return trip != null;
    }
    
    public static boolean isValidAddressId(final long id){
        final Session session = sessionFactory.openSession();
        Address address = session.get(Address.class, id);
        session.close();
        return address != null;
    }
    
    public static boolean isValidPassengerId(final long id){
        final Session session = sessionFactory.openSession();
        Passenger passenger = session.get(Passenger.class, id);
        session.close();
        return passenger != null;
    }
    
    public static boolean isValidTrip(final Trip trip){
        return isValidCompanyId(trip.getCompany().getId()) && !trip.getTownFrom().equals(trip.getTownTo()) && trip.getTimeOut().before(trip.getTimeIn());
    }
    
    public static boolean isValidPassenger(final Passenger passenger){
        return isValidAddressId(passenger.getAddress().getId());
    }
    public static long getValidPassengerId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
        }
        while(!str.matches(regex) || !isValidPassengerId(id)){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Passenger Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
    
    public static long getValidCompanyId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Company Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
        }
        while(!str.matches(regex) || !isValidCompanyId(id)){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Company Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
    
    public static long getValidTripId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Trip Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
        }
        while(!str.matches(regex) || !isValidTripId(id)){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Trip Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
}
