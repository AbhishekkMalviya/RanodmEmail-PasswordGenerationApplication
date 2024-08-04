package emailapp;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {

    public Scanner s = new Scanner(System.in); // Scanner is class and s is object of that class for taking input

    // now we are making variables private to use them within class and no-one else use them outside class
    private String fName;
    private String lName;
    private String department;
    private String email;
    private String password;
    private String alternateEmail;
    private int mailCapacity = 500;

    //creating a Constructor to recieve first name, last name etc..
    public Email(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: " + this.fName + " " + this.lName);
        this.department = this.setDepartment();
        this.email = this.generateEmail();
        this.password = this.generatePassword(12);

    }

    // Creating some methods
    // generate mail method
    private String generateEmail() {
        return this.fName.toLowerCase() + "." + this.lName.toLowerCase() + "@" + this.department.toLowerCase() + "company.com";
    }

    private String setDepartment() {
        System.out.println("Department Codes:\n 1. Sale\n 2. Development\n 3. Accounts\n 0. None\n");
        boolean flag = false;
        do {
            System.out.println("Enter Department Code");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounts";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid Choice please try Again!");
            }
        } while (!flag);
        return null;
    }

    //generateRandomPasswordMethod
    private String generatePassword(int length) {
        Random r = new Random();
        String capitalChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChar = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String symbols = ".,><|!@#$%^&*)(+=-_*+~)";
        String values = capitalChar + smallChar + numbers + symbols;
        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    //change password method
    public void changePassword() {
        boolean flag = false;
        do {
            System.out.print("Do you want to change YOUR Password?! (Y/N): ");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter Current Password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new Password: ");
                    this.password = s.next();
                    System.out.println("Password Changed Successfully!");

                } else {
                    System.out.println("Incorrect Password!!!");
                }
            } else if (choice == 'n' || choice == 'N') {
                flag = true;
                System.out.println("You decide not to change Password.");
            } else {
                System.out.println("Enter a valid Choice.");
            }
        } while (!flag);
    }

    // Set mailbox Capacity
    public void setMailCapacity() {
        System.out.println("Current Capacity = " + this.mailCapacity + "Mb");
        System.out.print("Enter new Mail Capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("Mail Capacity is Successfully changead!!!! \nNew Mail Capacity is: " + this.mailCapacity + "Mb");
    }

    public void setAltenameEmail() {
        System.out.println("Enter Alternat Email: ");
        this.alternateEmail = s.next();
        System.out.println("Your Aternate Email is: " + this.alternateEmail);
    }

    public void getInfo() {
        System.out.println("Name: " + this.fName + " " + this.lName);
        System.out.println("Email: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Department: " + this.department);
        System.out.println("Mail Capacity: " + this.mailCapacity + "Mb");
        System.out.println("Alternate Email: " + this.alternateEmail);
        char ch = '0';
        while (ch != 'F' && ch != 'f') {
            System.out.println("press F to Exit");
            ch = s.next().charAt(0);
            if (ch == 'F') {
                break;
            }
        }

    }

    public void storeData() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\abhis\\OneDrive\\Documents\\Info.txt");
            fw.write("First Name: " + this.fName);
            fw.append("\nLast Name: " + this.lName);
            fw.append("\nDepartment: " + this.department);
            fw.append("\nEmail: " + this.email);
            fw.append("\nPassword: " + this.password);
            fw.append("\nAlternate Email: " + this.alternateEmail);
            fw.append("\nMail Capacity: " + this.mailCapacity);
            fw.close();
            System.out.println("Data Stored.");

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    // public void readFile() {
    //     try {
    //         FileReader fr = new FileReader("Info.txt");
    //         int i;
    //         while ((i = fr.read()) != -1) {
    //             System.out.print((char)i);
    //             fr.close();
    //         }
    //         System.out.println();
    //         fr.close();
    //     } catch (Exception e) {
    //         System.out.println(e);

    //     }
    // }
    public void readFile() {
        try {
            FileReader f1 = new
                    FileReader("C:\\Users\\abhis\\OneDrive\\Documents\\Info.txt"); //Set here path where you have to save file
            int i;
            while ((i = f1.read()) != -1) {
                System.out.print((char) i);
            }
            f1.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

    }
}
