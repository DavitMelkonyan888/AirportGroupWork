package airport_hibernate.service.create_pojo_objects;

import airport_hibernate.pojo_classes.Address;
import airport_hibernate.pojo_classes.Company;
import airport_hibernate.pojo_classes.Passenger;
import airport_hibernate.pojo_classes.Trip;
import airport_hibernate.validation.Validation;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Scanner;

public class CreateObjects {
    private static CreateObjects objects;
    private CreateObjects(){}

    public static CreateObjects getInstance() {
        if (objects == null){
            objects = new CreateObjects();
        }
        return objects;
    }

    public Company createObjComp(){
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER COMPANY NAME -> ");
        String name = scStr.next();
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        System.out.println("ENTER FOUNDING DATE YYYY-MM-DD");
        String foundDate = scStr.next();
        while (!foundDate.matches(regex)) {
            System.out.println("ENTER FOUNDING DATE YYYY-MM-DD");
            foundDate = scStr.next();
        }

        Company company = new Company(name, Date.valueOf(foundDate));

        return company;
    }

    public Passenger createObjPass() {
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER THE PASSENGERS NAME -> ");
        String name = scStr.next();
        String phoneNumber = Validation.getInstance().validPhoneNumber();
        Address address = Validation.getInstance().validAddress();

        return new Passenger(name, phoneNumber, address);
    }

    public Trip createObjTrip() {
        final long tripId = Validation.getInstance().getValidTripId();
        final Company company = createObjComp();
        final String townFrom = getTown();
        final String townTo   = getTown();
        final Timestamp timeOut = Validation.getInstance().validTimeStamp();
        final Timestamp timeIn = Validation.getInstance().validTimeStamp();
        return new Trip(tripId, company, townFrom, townTo, timeOut, timeIn);

    }

    public String getTown() {
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER THE CITY -> ");
        String town = scStr.next();
        return town;
    }
}
