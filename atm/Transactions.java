package atm;
import java.util.*;
public class Transactions {
    public static Scanner sc=new Scanner(System.in);
    public static boolean deposit(String acno,String pin){
        if(Account.validate(acno, pin)){
        System.out.println("Enter the amount to deposit");
        double deposit=sc.nextDouble();
        Account.balance+=deposit;
        History.updateTransaction(acno, "deposit", deposit);
       
        return true;
        }

        else{
        System.out.println("Invalid Account number or pin");
        
        }
        return false;
    }
    public static boolean withdraw(String acno,String pin){
        if(Account.validate(acno, pin)){
        System.out.println("Enter the amount to withdraw");
        double withdraw=sc.nextDouble();
        if(withdraw<=Account.balance-500){
            Account.balance-=withdraw;
            History.updateTransaction(acno, "withdraw", withdraw);
            return true;
           
        }
        else{
            System.out.println("Insufficient balance");
            System.out.println("minimum balance should be 500/-");
            return false;
        }
        }
        else{
        System.out.println("Invalid Account number or pin");
        
        }
        return false;
    }
    public static boolean checkBalance(){
        if(Account.validate(ATM.acno, ATM.pin)){
        System.out.println("Your current balance is: "+Account.balance);
        return true;
        }
        else{
        System.out.println("Invalid Account number or pin");
        
        }
        return false;


    }
    public static boolean transfer(String acno,String pin){
        if(acno.matches("\\d{13}")&&pin.matches("\\d{4}")){
            System.out.println("Enter the amount to transfer");
            double transfer=sc.nextDouble();
            if(transfer<=Account.balance-500){
                Account.balance-=transfer;
                System.out.println("amout has been transfered successfully");
                return true;
            }
            
            else{
                System.out.println("Insufficient balance");
                System.out.println("minimum balance should be 500/-");
                
            }
    }
        else{
            System.out.println("unable to perform transcation due to insufficient balance");
        }
        return false;
    
}
}