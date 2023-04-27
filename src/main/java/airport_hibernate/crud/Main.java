package airport_hibernate.crud;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;

import java.util.Scanner;

public class Main {
    
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
    
    private static void passengerSwitch(){
        PassengerService passengerService = new PassengerService();
        int v;
        do {
            Menu.subMenuPassengers();
            v = getValidInt();
            System.out.println();
            switch (v) {
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
        } while(v != 10);
        passengerService.close();
    }
    
    private static void companySwitch(){
        CompanyService companyService = new CompanyService();
        int v;
        do {
            Menu.subMenuCompanies();
            v = getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    int i = getValidInt();
                    Company company = companyService.getById(i);
                    System.out.println(companyService.toString(company));
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
        } while(v != 7);
        companyService.close();
    }
    
    private static void tripSwitch(){
        TripService tripService = new TripService();
        int v;
        do {
            Menu.subMenuTrips();
            v = getValidInt();
            System.out.println();
            switch (v) {
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
        } while(v != 9);
        tripService.close();
    }
    
    public static void main (String[] args) {
        int v;
        do {
            Menu.mainMenu();
            v = getValidInt();
            System.out.println();
            switch (v) {
                case 1 -> passengerSwitch();
                case 2 -> companySwitch();
                case 3 -> tripSwitch();
                case 4 -> System.out.println("Exited Successfully");
                default -> System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 4);
        Connection.getSessionFactory().close();
    }
}
