package airport_hibernate.crud;

public class Menu {
    public static void mainMenu(){
        System.out.println("Press 1  For Passengers");
        System.out.println("Press 2  For Companies");
        System.out.println("Press 3  For Trips");
        System.out.println("Press 4  For Exit");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenu(){
        System.out.println("Press 1  For Getting By Id");
        System.out.println("Press 2  For Getting All");
        System.out.println("Press 3  For Getting All By Limits");
        System.out.println("Press 4  For Saving");
        System.out.println("Press 5  For Updating");
        System.out.println("Press 6  For Deleting");
    }
    
    public static void subMenuPassengers(){
        subMenu();
        System.out.println("Press 7  For Getting By Trip Id");
        System.out.println("Press 8  For Registering New Trip For Passenger");
        System.out.println("Press 9  For Cancelling Trip For Passenger");
        System.out.println("Press 10 Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuCompanies(){
        subMenu();
        System.out.println("Press 7  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuTrips(){
        subMenu();
        System.out.println("Press 7  For Getting By Town From");
        System.out.println("Press 8  For Getting By Town To");
        System.out.println("Press 9  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
}
