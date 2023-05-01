package airport_hibernate.validation;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.pojo_classes.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Validation {
    
    private final static SessionFactory sessionFactory = Connection.getSessionFactory();
    
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
    
    public static boolean isValidTrip(final Trip trip){
        return isValidCompanyId(trip.getCompany().getId()) && !trip.getTownFrom().equals(trip.getTownTo()) && trip.getTimeOut().before(trip.getTimeIn());
    }
    
    public static boolean isValidTripId(final long id){
        final Session session = sessionFactory.openSession();
        Trip trip = session.get(Trip.class, id);
        session.close();
        return trip != null;
    }
}
