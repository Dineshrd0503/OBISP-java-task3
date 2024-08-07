package atm;
import java.util.*;

public class Account {
    public static final Map<String,String> details=new HashMap<>();
    public static double balance=1000;
    public static boolean adddetails(String acno,String pin){
        if(acno.matches("\\d{13}")&&pin.matches("\\d{4}")){
            details.put(acno,pin);
            return true;
        }
        else
        return false;
    }
    public static boolean validate(String acno,String pin){
        return details.containsKey(acno)&&details.get(acno).equals(pin);
    }
    
    public static void viewdetails(){
            System.out.println("Account Number: "+details.keySet().iterator().next());
            System.out.println("Pin: "+details.get(details.keySet().iterator().next()));
            System.out.println("Balance: "+balance);
        }
    }