package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;

    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    public Double[] transactions = new Double[1000];
    int nextTransaction = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount > 0){
            currentBalance += amount;
            transactions[nextTransaction++] = amount;
            System.out.println("Deposited " + amount + " to " + name + ". Current balance: " + currentBalance);
            return;
        }
        System.out.println("Invalid Deposit");
    }

    public void withdraw(double amount){
        if (amount > 0 && currentBalance >= amount){
            currentBalance -= amount;
            transactions[nextTransaction++] = -amount;
            System.out.println("Withdrew " + amount + " to " + name + ". Current balance: " + currentBalance);
            return;
        }
        System.out.println("Invalid Withdrawal");
    }

    public void displayTransactions(){
        for (int i = 1; i <= nextTransaction; i++){
            System.out.println("- Transaction " + i + ": " + (transactions[i-1]>0 ? "+" : "") + transactions[i-1]);
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
