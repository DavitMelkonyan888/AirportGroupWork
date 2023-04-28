package airport_hibernate.validation;

import java.util.Scanner;

public class Validation {
    public static int getValidInt(){
        String  regex   = "\\d+";
        Scanner scanner = new Scanner(System.in);
        String  str     = scanner.next();
        while(!str.matches(regex)){
            System.out.println("\nInvalid Input Please Try Again\n");
            System.out.print("Type Your Action Number: ");
            str = scanner.next();
        }
        return Integer.parseInt(str);
    }
}
