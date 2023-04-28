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
            switch (v) {
                case 1 -> {
                    switch (service) {
                        case PASSENGER -> passengerCreate(new PassengerService());
                        case COMPANY -> companyCreate(new CompanyService());
                        case TRIP -> tripCreate(new TripService());
                    }
                }
                case 2 -> {
                    switch (service) {
                        case PASSENGER -> passengerRead(new PassengerService());
                        case COMPANY -> companyRead(new CompanyService());
                        case TRIP -> tripRead(new TripService());
                    }
                }
                case 3 -> {
                    switch (service) {
                        case PASSENGER -> passengerUpdate(new PassengerService());
                        case COMPANY -> companyUpdate(new CompanyService());
                        case TRIP -> tripUpdate(new TripService());
                    }
                }
                case 4 -> {
                    switch (service) {
                        case PASSENGER -> passengerDelete(new PassengerService());
                        case COMPANY -> companyDelete(new CompanyService());
                        case TRIP -> tripDelete(new TripService());
                    }
                }
                case 5 -> Menu.prevMenu();
                default -> System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while(v != 5);
    }
    
    private static void passengerCreate(PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersCreate();
            v = Validation.getValidInt();
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
                    Menu.prevMenu();
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
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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
                    Menu.prevMenu();
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
                    Menu.prevMenu();
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
            switch (v) {
                case 1:
                    break;
                case 2:
                    Menu.prevMenu();
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