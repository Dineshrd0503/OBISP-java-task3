package atm;
import java.util.*;

public class History {
    public static final Map<String,Map<String,Double>> transactions = new HashMap<>();

    public static void updateTransaction(String accountNumber, String transactionType, double amount) {
         Map<String,Double> accountTransactions = transactions.getOrDefault(accountNumber, new HashMap<>());
        accountTransactions.put(transactionType, accountTransactions.getOrDefault(transactionType, 0.0) + amount);
        transactions.put(accountNumber, accountTransactions);
    }
    public static boolean showtranscations(){
        if(!(History.transactions.isEmpty())){
        for(String accountNumber: transactions.keySet()){
            System.out.println("Account Number: " + accountNumber);
            Map<String, Double> accountTransactions = transactions.get(accountNumber);
            for(String transactionType: accountTransactions.keySet()){
                System.out.println("Transaction Type: " + transactionType + ", Amount: " + accountTransactions.get(transactionType));
            }
           
        }
        return true;
    }
    else
    {
        System.out.println("No transactions found");
        return false;
    }
 
    }
}