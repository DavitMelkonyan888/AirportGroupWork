package airport_hibernate.service.create_pojo_objects;

import airport_hibernate.pojo_classes.Company;
import airport_hibernate.pojo_classes.Passenger;

import java.sql.Date;
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

    private Company createObjComp(){
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER COMPANY NAME -> ");
        String name = scStr.next();
        String regex = "\\d{4}-{2}-{2}";
        System.out.println("ENTER FOUNDING DATE YYYY-MM-DD");
        String foundDate = scStr.next();
        while (!foundDate.matches(regex)) {
            System.out.println("ENTER FOUNDING DATE YYYY-MM-DD");
            foundDate = scStr.next();
        }

        Company company = new Company(name, Date.valueOf(foundDate));

        return company;
    }

    private Passenger createObjPass() {
        Scanner scStr = new Scanner(System.in);
        System.out.print("ENTER THE PASSENGERS NAME -> ");
        String name = scStr.next();


    }
}
