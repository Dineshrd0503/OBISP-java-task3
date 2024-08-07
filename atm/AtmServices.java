package atm;

import java.util.Scanner;

public class AtmServices {

    public static Scanner sc = new Scanner(System.in);

    public static void showmenu() {
        while (true) {
            System.out.println("Welcome to ATM services");
            System.out.println("1. View Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. view History");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    Account.viewdetails();
                    System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                    int ch = sc.nextInt();
                    if (ch != 1) {
                    } else {
                        continue;
                    }
                }

                case 2 -> {
                    if (Transactions.deposit(ATM.acno, ATM.pin)) {
                        System.out.println("Deposit successful");
                        System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                        choice = sc.nextInt();
                        if (choice != 1) {
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("Insufficient balance or login error");
                        System.out.println("Consult your nearest branch for more information");
                    }
                }

                case 3 -> {
                    if (Transactions.withdraw(ATM.acno, ATM.pin)) {
                        System.out.println("Withdrawal successful");
                        System.out.println("balance in a/c is: " + Account.balance);
                        System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                        choice = sc.nextInt();
                        if (choice != 1) {
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("Consult your nearest branch for more information");
                    }
                }

                case 4 -> {
                    if (Transactions.checkBalance()) {
                        System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                        choice = sc.nextInt();
                        if (choice != 1) {
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("Consult your nearest branch for more information");
                    }
                }

                case 5 -> {
                    System.out.println("Enter the 13-digit account number to transfer:");
                    String acno = sc.next();
                    System.out.println("Enter your PIN:");
                    String pin = sc.next();
                    if (Transactions.transfer(acno, pin)) {
                        System.out.println("Transaction successful");
                        System.out.println("balance in a/c is :" + Account.balance);
                        System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                        choice = sc.nextInt();
                        if (choice != 1) {
                        } else {
                            continue;
                        }
                    } else {
                        System.out.println("Insufficient balance or login error");
                        System.out.println("Consult your nearest branch for more information");
                    }
                }
                case 6 ->{
                    System.out.println("dipslaying entire history");
                   if(History.showtranscations()){
                    System.out.println("Do you want to continue? Press 1 for continue and 0 for exit");
                    choice = sc.nextInt();
                    if (choice!= 1) {
                    } else {
                        continue;
                    }
                   }
                    else{
                    System.out.println("you haven't not done any tranctaions so far");
                    }

                }

                case 7 -> {
                    System.out.println("Thank you for using our services");
                    System.exit(0);
                }

                default ->
                    System.out.println("Invalid choice");
            }
        }
    }
}
