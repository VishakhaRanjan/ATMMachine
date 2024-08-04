import java.util.*;
/*
This class simulates  ATMMachine
 */
class ATMMachine {
//Attributes for ATMMachine simulation
    private String pin;  //user's pin
    private double balance; //user's account balance
    private List<String> transactionHistory ;  //record of transaction

    //Default PIN
    private static final String DEFAULT_PIN = "1234";
    /*
    Constructor to initialize the ATMMachine simulation
     */
    public ATMMachine() {
        this.pin = DEFAULT_PIN;
        this.balance = 0.0;  //Initial balance
        this.transactionHistory = new ArrayList<>(); // Initialize the transaction history list
    }

    /*
    Main method to run the ATMMachine simulation
     */
    public static void main(String[] args) {
       ATMMachine atm = new ATMMachine(); // Create an instance of the ATM
       atm.start(); // start the atm simulation
    }
    public void start() {
        Scanner scan = new Scanner(System.in);
        boolean exit = true;

        //Menu loop
        while (exit) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Account Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. PIN Change");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            //Get the user's choice
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    checkBalance(); // Display account balance
                    break;

            case 2:
            withdrawCash(scan); //WithdrawCash
                break;
                case 3:
                    depositCash(scan); // Deposit Cash
                    break;
                    case 4:
                        changePIN(scan); // Change user PIN
                        break;
                        case 5:
                            showTransactionHistory(); // Display Transaction history
                            break;
                            case 6:
                                exit = false; // Exit the ATM
                                break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        scan.close(); //close the scanner
        System.out.println("Thank you for using ATMMachine!"); //Exit message

    }
    /*
    method to check account balance
     */
    private void checkBalance() {
        System.out.println("Your current balance is: " + balance); //display the current amount
        transactionHistory.add("Checked balance: " + balance); // Log the transaction
    }
    /*
    method to withdraw the cash from the account
     */
    private void withdrawCash(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble(); // Get the withdrawal amount
        if (amount > balance) {
            System.out.println("Insufficient balance!"); // Check for insufficient amount
        } else {
            balance -= amount; // Deduct the amount from balance
            System.out.printf("You have withdrawn: %.2f%n", amount);
            transactionHistory.add("Withdrawal: " + amount); // Log the transaction
        }
    }
        /*
        method to deposit cash into the account
         */
        private void depositCash(Scanner scan){
        System.out.println("Enter  amount to deposit: ");
        double amount = scan.nextDouble(); //get the deposit amount
        balance += amount; // add the amount to balance
            System.out.println("You have deposited: " + amount);
            transactionHistory.add("Deposit: " + amount);
    }
        /**
         * Method to change the PIN for the ATM.
         */
        private void changePIN(Scanner scan) {
            System.out.print("Enter your current PIN: ");
            String currentPIN = scan.next(); // Get the current PIN
            if (!currentPIN.equals(pin)) {
                System.out.println("Incorrect PIN. Unable to change."); // Check for correct PIN
                return;
            }
            System.out.print("Enter new PIN: ");
            String newPIN = scan.next(); // Get the new PIN
            pin = newPIN; // Update the PIN
            System.out.println("PIN successfully changed."); // Confirmation message
            transactionHistory.add("PIN changed."); // Log the transaction
        }
    /**
     * Method to show transaction history.
     */
    private void showTransactionHistory() {
        System.out.println("\n=== Transaction History ===");
        for (String transaction : transactionHistory) {
            System.out.println(transaction); // Print each transaction
        }
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions made yet."); // Message if no transactions exist
        }
    }
}