package airport_hibernate.validation;

import static airport_hibernate.connection_to_db.Connection.getSessionFactory;
import airport_hibernate.pojo_classes.*;
import airport_hibernate.service.abstract_service.Service;
import airport_hibernate.service.service_classes.CompanyService;
import airport_hibernate.service.service_classes.PassengerService;
import airport_hibernate.service.service_classes.TripService;
import airport_hibernate.service.single_tone_objects.SingleTonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.util.Scanner;
import java.util.Set;

public class Validation {
    
    private final static SessionFactory sessionFactory = getSessionFactory();
    
    public static int getValidIntForSwitch(final int max){
        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.next();
        while(!str.matches(regex) ||  Integer.parseInt(str) > max || Integer.parseInt(str) < 1){
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
    
    public static boolean isValidPassengerId(final long id){
        final Session session = sessionFactory.openSession();
        Passenger passenger = session.get(Passenger.class, id);
        session.close();
        return passenger != null;
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
    
    public static <T> @NotNull T getValidPOJOById(@NotNull T obj, @NotNull Service<T> service){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + obj.getClass().getSimpleName() + " Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
            obj = service.getById(id);
        }
        while(!str.matches(regex) || obj == null){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter " + obj.getClass().getSimpleName() + " Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
                obj = service.getById(id);
            }
        }
        return obj;
    }
    
    public static @NotNull Company getValidCompany(){
        Scanner scanner = new Scanner(System.in);
        Company company = new Company();
        String  regex   = "\\d{4}-\\d{2}-\\d{2}";
        System.out.print("Enter Company Name: ");
        company.setName(scanner.next());
        System.out.print("Enter Company Founding Date(YYYY-MM-DD): ");
        String dateString = scanner.next();
        while (!dateString.matches(regex)){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Enter Company Founding Date(YYYY-MM-DD): ");
            dateString = scanner.next();
        }
        company.setFoundingDate(Date.valueOf(dateString));
        return company;
    }
    
    public static <T> Set <T> getObj(@NotNull Service<T> service){

        Scanner scInt = new Scanner(System.in);
        System.out.print("ENTER LIMIT ? > 0 -> ");
        final int limit = scInt.nextInt();
        System.out.print("ENTER OFFSET ? > 0 -> ");
        final int offset = scInt.nextInt();
        final String sortColumn;


        if (instanceOfServices(service) == 1)
           sortColumn = columnNameT(printTableTripColumns());

        else if (instanceOfServices(service) == 2) {
            sortColumn = columnNameP(printPassengerTablesColumns());

        } else {
            sortColumn = columnNameC(printCompanyTableColumns());
        }
        return service.get(limit, offset, sortColumn);
    }

    private static int printPassengerTablesColumns() {

        System.out.println("1. id");
        System.out.println("2. city");
        System.out.println("3. country");
        System.out.println("4. name");
        System.out.println("5. phone");
        System.out.print("ENTER COLUMN CAME -> ");

        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.next();
        while(!str.matches(regex) ||  Integer.parseInt(str) > 5 || Integer.parseInt(str) < 1){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();

        }
        System.out.println();
        return Integer.parseInt(str);

    }

    public static int  printTableTripColumns(){
        System.out.println("1. company_id");
        System.out.println("2. trip_id");
        System.out.println("3. time_in");
        System.out.println("4. time_out");
        System.out.println("5. town_from");
        System.out.println("6. town_to");
        System.out.print("ENTER COLUMN CAME -> ");

        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.next();
        while(!str.matches(regex) ||  Integer.parseInt(str) > 6 || Integer.parseInt(str) < 1){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();

        }
        System.out.println();
        return Integer.parseInt(str);


    }

    private static int printCompanyTableColumns() {
        System.out.println("1. founding_date");
        System.out.println("2. id");
        System.out.println("3. name");
        System.out.print("ENTER COLUMN CAME -> ");

        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str = scanner.next();
        while(!str.matches(regex) ||  Integer.parseInt(str) > 6 || Integer.parseInt(str) < 1){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();

        }
        System.out.println();
        return Integer.parseInt(str);

    }

    private static <T> int instanceOfServices(Service<T> service) {
        if (service instanceof CompanyService)
            return 1;
        if (service instanceof PassengerService)
            return 2;
        return 3;

    }

    @Contract(pure = true)
    private static @NotNull String columnNameT(final int columnNumber) {
        switch (columnNumber){
            case 1:
                return "company_id";
            case 2:
                return "trip_id";
            case 3:
                return "time_in";
            case 4:
                return "time_out";
            case 5:
                return "town_from";
            case 6:
                return "town_to";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI, MALADEC :)");
        }

    }
    @Contract(pure = true)
    private static @NotNull String columnNameP(final int columnNumber){
        switch (columnNumber){
            case 1:
                return "id";
            case 2:
                return "city";
            case 3:
                return "country";
            case 4:
                return "name";
            case 5:
                return "phone";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI, MALADEC :)");
        }
    }

    @Contract(pure = true)
    private static @NotNull String columnNameC(final int columnName){
        switch (columnName) {
            case 1:
                return "founding_date";
            case 2:
                return "id";
            case 3:
                return "name";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI, MALADEC :)");
        }
    }
}
