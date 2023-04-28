package airport_hibernate.crud;

import airport_hibernate.connection_to_db.Connection;
import airport_hibernate.service.abstract_service.Service;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
import airport_hibernate.validation.Validation;

public class Main {
    
    private enum Services{
        PASSENGER, COMPANY, TRIP;
    }
    
    private static void crud(Services service) {
        int v;
        do {
            Menu.subMenu();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    switch(service){
                        case PASSENGER -> passengerCreate(new PassengerService());
                        case COMPANY -> companyCreate(new CompanyService());
                        case TRIP -> tripCreate(new TripService());
                    }
                    break;
                case 2:
                    switch(service){
                        case PASSENGER -> passengerRead(new PassengerService());
                        case COMPANY -> companyRead(new CompanyService());
                        case TRIP -> tripRead(new TripService());
                    }
                    break;
                case 3:
                    switch(service){
                        case PASSENGER -> passengerUpdate(new PassengerService());
                        case COMPANY -> companyUpdate(new CompanyService());
                        case TRIP -> tripUpdate(new TripService());
                    }
                    break;
                case 4:
                    switch(service){
                        case PASSENGER -> passengerDelete(new PassengerService());
                        case COMPANY -> companyDelete(new CompanyService());
                        case TRIP -> tripDelete(new TripService());
                    }
                    break;
                case 5:
                    
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while(v != 5);
    }
    
    private static void passengerCreate(PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersCreate();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void passengerRead(PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersRead();
            v = Validation.getValidInt();
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
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 5);
    }
    
    private static void passengerUpdate(PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersUpdate();
            v = Validation.getValidInt();
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
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 5);
    }
    
    private static void passengerDelete(PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersDelete();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void companyCreate(CompanyService companyService){
        int v;
        do {
            Menu.subMenuCompaniesCreate();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void companyRead(CompanyService companyService){
        int v;
        do {
            Menu.subMenuCompaniesRead();
            v = Validation.getValidInt();
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
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 4);
    }
    
    private static void companyUpdate(CompanyService companyService){
        int v;
        do {
            Menu.subMenuCompaniesUpdate();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void companyDelete(CompanyService companyService){
        int v;
        do {
            Menu.subMenuCompaniesDelete();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void tripCreate(TripService tripService){
        int v;
        do {
            Menu.subMenuTripsCreate();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static void tripRead(TripService tripService){
        int v;
        do {
            Menu.subMenuTripsRead();
            v = Validation.getValidInt();
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
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 6);
    }
    
    private static void tripUpdate(TripService tripService){
        int v;
        do {
            Menu.subMenuTripsUpdate();
            v = Validation.getValidInt();
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
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 5);
    }
    
    private static void tripDelete(TripService tripService){
        int v;
        do {
            Menu.subMenuTripsDelete();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    public static void main (String[] args) {
        int v;
        do {
            Menu.mainMenu();
            v = Validation.getValidInt();
            System.out.println();
            switch (v) {
                case 1 -> crud(Services.PASSENGER);
                case 2 -> crud(Services.COMPANY);
                case 3 -> crud(Services.TRIP);
                case 4 -> System.out.println("Exited Successfully");
                default -> System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 4);
        Connection.getSessionFactory().close();
    }
}