package airport_hibernate.crud;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;

import airport_hibernate.pojo_classes.Company;
import airport_hibernate.service.abstract_service.Service;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static airport_hibernate.validation.Validation.*;

public class Main {
    
    private enum Services{
        PASSENGER, COMPANY, TRIP;
    }
    
    private static void crud(Services service) {
        int v;
        do {
            Menu.subMenu();
            v = getValidIntForSwitch();
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
                        case PASSENGER -> serviceDelete(new PassengerService());
                        case COMPANY -> serviceDelete(new CompanyService());
                        case TRIP -> serviceDelete(new TripService());
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
            Menu.subMenuCreate();
            v = getValidIntForSwitch();
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
    
    private static void passengerRead(final PassengerService passengerService){
        int v;
        do {
            Menu.subMenuPassengersRead();
            v = getValidIntForSwitch();
            switch (v) {
                case 1:
                    System.out.println(passengerService.toString(getValidPassengerById()) + '\n');
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
            v = getValidIntForSwitch();
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
    
    private static void companyCreate(CompanyService companyService){
        int v;
        do {
            Menu.subMenuCreate();
            v = getValidIntForSwitch();
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
            v = getValidIntForSwitch();
            switch (v) {
                case 1:
                    System.out.println(companyService.toString(getValidCompanyById()) + '\n');
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
            v = getValidIntForSwitch();
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
            Menu.subMenuCreate();
            v = getValidIntForSwitch();
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
            v = getValidIntForSwitch();
            switch (v) {
                case 1:
                    System.out.println(tripService.toString(getValidTripById()) + '\n');
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
            v = getValidIntForSwitch();
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
    
    private static <T extends Service> void serviceCreate(T service){
        int v;
        do {
            Menu.subMenuCreate();
            v = getValidIntForSwitch();
            switch (v) {
                case 1:
                    createRow(service);
                    break;
                case 2:
                    Menu.prevMenu();
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static <T extends Service> void createRow(T service){
        if (service instanceof CompanyService){
            long id = getValidCompanyId();
            service.delete(id);
        } else if (service instanceof PassengerService){
            long id = getValidPassengerId();
            service.delete(id);
        } else {
            long id = getValidTripId();
            service.delete(id);
        }
    }
    
    private static <T extends Service> void serviceDelete(T service){
        int v;
        do {
            Menu.subMenuDelete();
            v = getValidIntForSwitch();
            switch (v) {
                case 1:
                    deleteRow(service);
                    break;
                case 2:
                    Menu.prevMenu();
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static <T extends Service> void deleteRow(T service){
        if (service instanceof CompanyService){
            long id = getValidCompanyId();
            service.delete(id);
        } else if (service instanceof PassengerService){
            long id = getValidPassengerId();
            service.delete(id);
        } else {
            long id = getValidTripId();
            service.delete(id);
        }
    }
    
    public static void main (String[] args) {
        try (SessionFactory ignored = getSessionFactory()) {
            int v;
            do {
                Menu.mainMenu();
                v = getValidIntForSwitch();
                switch (v) {
                    case 1 -> crud(Services.PASSENGER);
                    case 2 -> crud(Services.COMPANY);
                    case 3 -> crud(Services.TRIP);
                    case 4 -> System.out.println("Exited Successfully");
                    default -> System.out.println("\nInvalid Input Please Try Again\n");
                }
            } while (v != 4);
        }
    }
}