package emailapp;
import java.util.Scanner;
// This Application Generate Email Randomly and when you override it the existing data will be lost!
// this is only a fun assessment
// MY Socials Are:-
//Linkdin: https://www.geeksforgeeks.org/user/abhishekmalviya997/
//github:  https://github.com/AbhishekkMalviya
//Gfg:     https://www.linkedin.com/in/abhishek-malviya-9779b325b/
 
public class EmailApp {

    public static void main(String[] gg) {
        Scanner s = new Scanner(System.in);

        // User Info
        System.out.println("Enter First Name: ");
        String fName = s.next();
        System.out.println("Enter Last Name: ");
        String lName = s.next();

        //Creating Object for Email Class;
        Email email = new Email(fName, lName);
        int choice = -1;
        do {
            System.out.println(" 1. Show Info\n 2. Change Password\n 3. Change Mail Box Capacity\n 4. Set Altenate Email\n 5. Store Data\n 6. Display Data\n 7. exit\n ----------Enter Your Choice---------- ");
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    email.getInfo();
                    break;
                case 2:
                    email.changePassword();
                    break;
                case 3:
                    email.setMailCapacity();
                    break;
                case 4:
                    email.setAltenameEmail();
                    break;
                case 5:
                    email.storeData();
                case 6:
                    email.readFile();
                    break;
                case 7:
                    System.out.println("Thank YOU!");
                    break;
                default:
                    System.out.println("Invalid Choice!! Enter Again:");
            }
        } while (choice != 6);
    }
}
