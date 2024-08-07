package atm;
import java.util.Scanner;

public class ATM {
    public static Scanner sc = new Scanner(System.in);
        public static String acno;
        public static String pin;
    public static void main(String[] args) {
        
        
        System.out.println("welcome to atm services");

        System.out.println("Enter your acno ");
        acno = sc.nextLine();
        

        System.out.println("Enter user PIN: ");
        pin = sc.nextLine();
        

        if(Account.adddetails(acno,pin)){
            System.out.println("Welcome to SBI Bank");
            AtmServices.showmenu();
        }
        else{
            System.out.println("Invalid credentials");
        }

    }
}
