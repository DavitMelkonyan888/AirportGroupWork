package airport_hibernate.crud;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;

import airport_hibernate.pojo_classes.Company;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import airport_hibernate.service.abstract_service.Service;
import airport_hibernate.service.create_pojo_objects.CreateObjects;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
import airport_hibernate.service.single_tone_objects.SingleTonService;
import airport_hibernate.validation.Validation;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Scanner;


import static airport_hibernate.validation.Validation.*;

public class Main {

    
    private enum Services{
        PASSENGER, COMPANY, TRIP
    }
    
    private static void crud(Services service) {
        int v;
        do {
            Menu.subMenu();
            v = Validation.getInstance().getValidIntForSwitch(5);
            switch (v) {
                case 1 -> {
                    switch (service) {
                        case PASSENGER -> serviceCreate(SingleTonService.getPassengerService());
                        case COMPANY -> serviceCreate(SingleTonService.getCompanyService());
                        case TRIP -> serviceCreate(SingleTonService.getTripService());
                    }
                }
                case 2 -> {
                    switch (service) {
                        case PASSENGER -> passengerRead(SingleTonService.getPassengerService());
                        case COMPANY -> companyRead(SingleTonService.getCompanyService());
                        case TRIP -> tripRead(SingleTonService.getTripService());
                    }
                }
                case 3 -> {
                    switch (service) {
                        case PASSENGER -> passengerUpdate(SingleTonService.getPassengerService());
                        case COMPANY -> companyUpdate(SingleTonService.getCompanyService());
                        case TRIP -> tripUpdate(SingleTonService.getTripService());
                    }
                }
                case 4 -> {
                    switch (service) {
                        case PASSENGER -> serviceDelete(SingleTonService.getPassengerService());
                        case COMPANY -> serviceDelete(SingleTonService.getCompanyService());
                        case TRIP -> serviceDelete(SingleTonService.getTripService());
                    }
                }
                case 5 -> Menu.prevMenu();
                default -> System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while(v != 5);
    }
    
    private static void passengerRead(final PassengerService passengerService){
        final Passenger passenger = new Passenger();
        int v;
        do {
            Menu.subMenuPassengersRead();
            v = Validation.getInstance().getValidIntForSwitch(5);
            switch (v) {
                case 1:
                    System.out.println(passengerService.toString(Validation.getInstance().getValidPOJOById(passenger, passengerService)) + '\n');
                    break;
                case 2:
                    printList(passengerService.getAll(), passengerService);
                    break;
                case 3:
                    printList(Validation.getInstance().getObj(passengerService), passengerService);
                    break;
                case 4:
                    long tripId =Validation.getInstance().getValidTripId();
                    printList(passengerService.getPassengersOfTrip(tripId), passengerService);
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
            v = Validation.getInstance().getValidIntForSwitch(6);
            switch (v) {
                case 1:
                    passengerService.updatePassengersPhone(Validation.getInstance().validPhoneNumber(), Validation.getInstance().getValidPassengerId());
                    break;
                case 2:
                    passengerService.updatePassengersAddress(Validation.getInstance().validAddress(), Validation.getInstance().getValidPassengerId());
                    break;
                case 3:
                    passengerService.registerTrip(CreateObjects.getInstance().createObjTrip(), CreateObjects.getInstance().createObjPass(), Validation.getInstance().validTimeStamp(), getTown());
                    break;
                case 4:
                    passengerService.cancelTrip(Validation.getInstance().getValidPassengerId(), Validation.getInstance().getValidTripId());
                    break;
                case 5:
                    passengerService.updatePassenger(CreateObjects.getInstance().createObjPass(), Validation.getInstance().getValidPassengerId());
                    break;
                case 6:
                    Menu.prevMenu();
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 5);
    }
    
    private static void companyRead(CompanyService companyService){
        final Company company = new Company();
        int v;
        do {
            Menu.subMenuCompaniesRead();
            v = Validation.getInstance().getValidIntForSwitch(4);
            switch (v) {
                case 1:
                    System.out.println(companyService.toString(Validation.getInstance().getValidPOJOById(company, companyService)) + '\n');
                    break;
                case 2:
                    printList(companyService.getAll(), companyService);
                    break;
                case 3:
                    printList(Validation.getInstance().getObj(companyService), companyService);
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
            v = Validation.getInstance().getValidIntForSwitch(4);
            switch (v) {
                case 1:
                    companyService.update(CreateObjects.getInstance().createObjComp());
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
        final Trip trip = new Trip();
        int v;
        do {
            Menu.subMenuTripsRead();
            v = Validation.getInstance().getValidIntForSwitch(6);
            switch (v) {
                case 1:
                    System.out.println(tripService.toString(Validation.getInstance().getValidPOJOById(trip, tripService)) + '\n');
                    break;
                case 2:
                    printList(tripService.getAll(), tripService);
                    break;
                case 3:
                    printList(Validation.getInstance().getObj(tripService), tripService);
                    break;
                case 4:
                    printList(tripService.getTripsFrom(getTown()), tripService);
                    break;
                case 5:
                    printList(tripService.getTripsTo(getTown()), tripService);
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
            v = Validation.getInstance().getValidIntForSwitch(3);
            switch (v) {
                case 1:
                    tripService.changeTimeIn(Validation.getInstance().getValidTripId());
                    break;
                case 2:
                    tripService.changeTimeOut(Validation.getInstance().getValidTripId());
                    break;
                case 3:
                    Menu.prevMenu();
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 3);
    }
    
    private static  <T extends Service> void serviceCreate(T service){
        int v;
        do {
            Menu.subMenuCreate();
            v = Validation.getInstance().getValidIntForSwitch(2);
            switch (v) {
                case 1:
                    addRow(service);
                    break;
                case 2:
                    Menu.prevMenu();
                    break;
                default:
                    System.out.println("\nInvalid Input Please Try Again\n");
            }
        } while (v != 2);
    }
    
    private static  <T extends Service> void addRow(T service){
        if (service instanceof CompanyService){
            service.save(CreateObjects.getInstance().createObjComp());
        } else if (service instanceof PassengerService){
            service.save(CreateObjects.getInstance().createObjPass());
        } else {
            service.save(CreateObjects.getInstance().createObjTrip());
        }
    }
    
    private static  <T extends Service> void serviceDelete(T service){
        int v;
        do {
            Menu.subMenuDelete();
            v = Validation.getInstance().getValidIntForSwitch(2);
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
    
    private static  <T extends Service> void deleteRow(T service){
        if (service instanceof CompanyService){
            long id = Validation.getInstance().getValidCompanyId();
            service.delete(id);
        } else if (service instanceof PassengerService){
            long id = Validation.getInstance().getValidPassengerId();
            service.delete(id);
        } else {
            long id = Validation.getInstance().getValidTripId();
            service.delete(id);
        }
    }
    
    public static void main (String[] args) {
        try (SessionFactory ignored = getSessionFactory()) {
            int v;
            do {
                Menu.mainMenu();
                v = Validation.getInstance().getValidIntForSwitch(4);
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
    private static  <T> void printList(@NotNull Collection<? extends T> list, Service service){
        for (T obj  : list){
            System.out.println(service.toString(obj));
        }
    }
    
    private static String getTown(){
        Scanner scanner = new Scanner(System.in);
        String town = scanner.next();
        return town;
    }
}

