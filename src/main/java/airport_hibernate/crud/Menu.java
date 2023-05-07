package airport_hibernate.crud;

public class Menu {
    public static void mainMenu(){
        System.out.println("Press 1  For Passengers");
        System.out.println("Press 2  For Companies");
        System.out.println("Press 3  For Trips");
        //System.out.println("Press 4  For Clearing Screen");
        System.out.println("Press 4  For Exit");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenu(){
        System.out.println("Press 1  For Creating");
        System.out.println("Press 2  For Reading");
        System.out.println("Press 3  For Updating");
        System.out.println("Press 4  For Deleting");
        System.out.println("Press 5  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuPassengersRead(){
        System.out.println("Press 1  To Get By Id");
        System.out.println("Press 2  To Get All");
        System.out.println("Press 3  To Get All By Limits");
        System.out.println("Press 4  To Get By Trip Id");
        System.out.println("Press 5  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuPassengersUpdate(){
        System.out.println("Press 1  To Change Phone");
        System.out.println("Press 2  To Change Address");
        System.out.println("Press 3  To Register New Trip");
        System.out.println("Press 4  To Cancel Trip");
        System.out.println("Press 5  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuCompaniesRead(){
        System.out.println("Press 1  To Get By Id");
        System.out.println("Press 2  To Get All");
        System.out.println("Press 3  To Get All By Limits");
        System.out.println("Press 4  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuCompaniesUpdate(){
        System.out.println("Press 1  To Change Name");
        System.out.println("Press 2  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuTripsRead(){
        System.out.println("Press 1  To Get By Id");
        System.out.println("Press 2  To Get All");
        System.out.println("Press 3  To Get All By Limits");
        System.out.println("Press 4  To Get By Town From");
        System.out.println("Press 5  To Get By Town To");
        System.out.println("Press 6  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuTripsUpdate(){
        System.out.println("Press 1  To Change Town From");
        System.out.println("Press 2  To Change Town To");
        System.out.println("Press 3  To Change Time Out");
        System.out.println("Press 4  To Change Time In");
        System.out.println("Press 5  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuCreate(){
        System.out.println("Press 1  To Add New Row");
        System.out.println("Press 2  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void subMenuDelete(){
        System.out.println("Press 1  To Delete By Id");
        System.out.println("Press 2  For Previous Menu");
        System.out.print("Type Your Action Number: ");
    }
    
    public static void prevMenu(){
        System.out.println("Previous Menu\n");
    }
}
