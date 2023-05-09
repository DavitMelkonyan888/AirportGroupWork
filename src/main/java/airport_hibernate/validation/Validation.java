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
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.Set;

public class Validation {

    private static Validation validation;

    private Validation(){}

    public static Validation getInstance() {
        if (validation == null){
            validation = new Validation();
        }
        return validation;
    }

    
    public int getValidIntForSwitch(final int max){
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

    
    public long getValidPassengerId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
        }
        while(!str.matches(regex)){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Passenger Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
    
    public long getValidCompanyId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Company Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
        }
        while(!str.matches(regex) ){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Company Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
            }
        }
        return id;
    }
    
    public long getValidTripId(){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Trip Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Long.parseLong(str);
        }
        while(!str.matches(regex)){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter Trip Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Long.parseLong(str);
            }
        }
        return id;
    }
    
    public <T>  T getValidPOJOById(@NotNull T obj, @NotNull Service<T> service){
        String  regex   = "\\d+";
        long id = -1;
        String str;
        Scanner scanner = new Scanner(System.in);
        T temp = null;
        System.out.print("Enter " + obj.getClass().getSimpleName() + " Id: ");
        str = scanner.next();
        if (str.matches(regex)){
            id = Integer.parseInt(str);
            temp = service.getById(id);
        }
        while(!str.matches(regex) || temp == null){
            System.out.println("\nInvalid Id Please Try Again\n");
            System.out.print("Enter " + obj.getClass().getSimpleName() + " Id: ");
            str = scanner.next();
            if (str.matches(regex)){
                id = Integer.parseInt(str);
                temp = service.getById(id);
            }
        }
        return temp;
    }
    
    public @NotNull Company getValidCompany(){
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
    
    public <T> Set<T> getObj(@NotNull Service<T> service){

        Scanner scInt = new Scanner(System.in);
        System.out.print("ENTER LIMIT ? > 0 -> ");
        final int limit = scInt.nextInt();
        System.out.print("ENTER OFFSET ? > 0 -> ");
        final int offset = scInt.nextInt();
        final String sortColumn;

        if (instanceOfServices(service) == 1)
           sortColumn = columnNameC(printCompanyTableColumns());

        else if (instanceOfServices(service) == 2) {
            sortColumn = columnNameP(printPassengerTablesColumns());

        } else {
            sortColumn = columnNameT(printTableTripColumns());
        }
        return service.get(limit, offset, sortColumn);
    }

    public String validPhoneNumber(){
        Scanner scStr = new Scanner(System.in);
        String  regex   = "\\d{3}-\\d{3}-\\d{4}";
        System.out.println("ENTER PHONE NUMBER XXX-XXX-XXXX");
        System.out.print("                  ");
        String phoneNumber = scStr.next();
        while (!phoneNumber.matches(regex)) {
            System.out.println("ENTER PHONE NUMBER XXX-XXX-XXXX");
            System.out.print("                  ");
            phoneNumber = scStr.next();
        }
        return phoneNumber;
    }

    public Timestamp validTimeStamp() {
        Scanner scStr = new Scanner(System.in);
        String regex =  "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        System.out.println("ENTER TIMESTAMP yyyy-mm-dd hh:mm:ss");
        String time = scStr.nextLine();
        while (!time.matches(regex)) {
            System.out.println("ENTER TIMESTAMP yyyy-mm-dd hh:mm:ss");
            time = scStr.nextLine();
        }
        return Timestamp.valueOf(time);
    }

    public Address validAddress(){
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER COUNTRY -> ");
        String country = scStr.next();
        System.out.print("ENTER CITY -> ");
        String city = scStr.next();
        return new Address(country, city);
    }

    private int printPassengerTablesColumns() {

        System.out.println("1. id");
        System.out.println("2. city");
        System.out.println("3. country");
        System.out.println("4. name");
        System.out.println("5. phone");
        System.out.print("ENTER COLUMN CAME -> ");

       return getValidIntForSwitch(5);

    }

    public int  printTableTripColumns(){
        System.out.println("1. company_id");
        System.out.println("2. trip_id");
        System.out.println("3. time_in");
        System.out.println("4. time_out");
        System.out.println("5. town_from");
        System.out.println("6. town_to");
        System.out.print("ENTER COLUMN CAME -> ");

        return getValidIntForSwitch(6);


    }

    private int printCompanyTableColumns() {
        System.out.println("1. founding_date");
        System.out.println("2. id");
        System.out.println("3. name");
        System.out.print("ENTER COLUMN CAME -> ");

       return getValidIntForSwitch(3);

    }

    private <T> int instanceOfServices(Service<T> service) {

        return service instanceof CompanyService ? 1 : service instanceof PassengerService ? 2: 3;

    }


    private  String columnNameT(final int columnNumber) {
        switch (columnNumber){
            case 1:
                return "company";
            case 2:
                return "id";
            case 3:
                return "timeIn";
            case 4:
                return "timeOut";
            case 5:
                return "townFrom";
            case 6:
                return "townTo";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI, MALADEC :)");
        }

    }

    private  String columnNameP(final int columnNumber){
        switch (columnNumber){
            case 1:
                return "id";
            case 2:
                return "address.city";
            case 3:
                return "address.country";
            case 4:
                return "name";
            case 5:
                return "phone";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI: MALADEC :)");
        }
    }


    private String columnNameC(final int columnName){
        switch (columnName) {
            case 1:
                return "foundingDate";
            case 2:
                return "id";
            case 3:
                return "name";
            default:
                throw new IllegalArgumentException("CHGITEM VONC ES KARACE ANES VOR EXCEPTION QCI, MALADEC :)");
        }
    }
}
