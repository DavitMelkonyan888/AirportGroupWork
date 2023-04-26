package airport_hibernate.crud;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class Main {
    
    private static void mainMenu(){
        System.out.println("Press 1  For Passengers");
        System.out.println("Press 2  For Companies");
        System.out.println("Press 3  For Trips");
        System.out.println("Press 4  For Exit");
        System.out.print("Type Your Action Number: ");
    }
    
    private static void subMenu(){
        System.out.println("Press 1  For Getting By Id");
        System.out.println("Press 2  For Getting All");
        System.out.println("Press 3  For Getting All By Limits");
        System.out.println("Press 4  For Saving");
        System.out.println("Press 5  For Updating");
        System.out.println("Press 6  For Deleting");
    }
    
    private static void subMenuPassengers(){
        subMenu();
        System.out.println("Press 7  For Getting By Trip Id");
        System.out.println("Press 8  For Registering New Trip For Passenger");
        System.out.println("Press 9  For Cancelling Trip For Passenger");
        System.out.println("Press 10 Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    private static void subMenuCompanies(){
        subMenu();
        System.out.println("Press 7  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    private static void subMenuTrips(){
        subMenu();
        System.out.println("Press 7  For Getting By Town From");
        System.out.println("Press 8  For Getting By Town To");
        System.out.println("Press 9  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    private static int getValidInt(){
        String regex = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        while(!str.matches(regex)){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();
        }
        return Integer.parseInt(str);
    }
    
    private static void passengerSwitch(SessionFactory sessionFactory){
        PassengerService passengerService = new PassengerService(sessionFactory);
        subMenuPassengers();
        int v = getValidInt();
        System.out.println();
        switch(v){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            case 10:
                
                break;
            default:
                System.out.println("\nInvalid Input Please Try Again\n");
        }
    }
    
    private static void companySwitch(SessionFactory sessionFactory){
        CompanyService companyService = new CompanyService(sessionFactory);
        subMenuCompanies();
        int v = getValidInt();
        System.out.println();
        switch(v){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            default:
                System.out.println("\nInvalid Input Please Try Again\n");
        }
    }
    
    private static void tripSwitch(SessionFactory sessionFactory){
        TripService tripService = new TripService(sessionFactory);
        subMenuTrips();
        int v = getValidInt();
        System.out.println();
        switch(v){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
                
                break;
            case 9:
                
                break;
            default:
                System.out.println("\nInvalid Input Please Try Again\n");
        }
    }
    
    public static void main (String[] args) {
        SessionFactory sessionFactory = Connection.getSessionFactory();
        int v;
        do {
            mainMenu();
            v = getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    passengerSwitch(sessionFactory);
                    break;
                case 2:
                    companySwitch(sessionFactory);
                    break;
                case 3:
                    tripSwitch(sessionFactory);
                    break;
                case 4:
                    System.out.println("Exited Successfully");
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 4);
        sessionFactory.close();
    }
}
