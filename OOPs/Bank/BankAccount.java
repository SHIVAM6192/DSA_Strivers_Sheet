package Bank;

/*
* 1. Encapsulation (Data Hiding & Protection)
* Encapsulation is the practice of bundling the data (fields) and the methods
* that operate on that data into a single unit (class), while restricting direct
* access to some of the object's components.

* Why polish this? It is not just about making fields private and
* generating getters/setters. It is about protecting the internal
* state of an object so it cannot be put into an invalid state
* by outside code.
* */


public class BankAccount {
    // 1. Private fields hide the internal state
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialDeposit){
        this.accountNumber = accountNumber;
        // Internal validation during initialization
        this.balance = Math.max(initialDeposit, 0.0);
    }

    // 2. Read-only access to specific fields
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getBalance(){
        return this.balance;
    }

    // 3. Controlled mutation: You cannot set the balance directly.
    // You must deposit or withdraw, allowing the class to enforce rules.
    public void deposit(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Deposit amount must be greater that 0");
        }
        this.balance += amount;
    }

    public void withdraw(double amount){
        if (amount < 0 || amount > balance){
            throw new IllegalStateException("Insufficient funds");
        }
        this.balance -= amount;
    }
}
