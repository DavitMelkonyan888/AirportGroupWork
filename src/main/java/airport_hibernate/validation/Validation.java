package airport_hibernate.validation;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.*;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
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
        scanner.close();
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
    
    public static Passenger getValidPassengerById(){
        Passenger passenger = null;
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
            passenger = new PassengerService().getById(id);
        }
        while(!str.matches(regex) || passenger == null){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Passenger Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
                passenger = new PassengerService().getById(id);
            }
        }
        return passenger;
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
    
    public static Company getValidCompanyById(){
        Company company = null;
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Company Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
            company = new CompanyService().getById(id);
        }
        while(!str.matches(regex) || company == null){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Company Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
                company = new CompanyService().getById(id);
            }
        }
        return company;
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
    
    public static Trip getValidTripById(){
        Trip trip = null;
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
            trip = new TripService().getById(id);
        }
        while(!str.matches(regex) || trip == null){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Passenger Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
                trip = new TripService().getById(id);
            }
        }
        return trip;
    }
    
    public static Company getValidCompany(){
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        java.sql.Date date = null;
        String  regex   = "\\d{4}-\\d{2}-\\d{2}";
        System.out.print("Enter Company Name: ");
        String name = scanner.next();
        company.setName(name);
        System.out.print("Enter Company Founding Date(YYYY-MM-DD): ");
        String dateString = scanner.next();
        return company;
    }
}
