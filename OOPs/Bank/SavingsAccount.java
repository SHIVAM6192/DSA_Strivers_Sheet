package Bank;

/*
2. Inheritance (The IS-A Relationship)
Inheritance allows a new class to adopt
the properties and behaviors of an existing class.
It promotes code reusability.

Why polish this? Beginners overuse inheritance.
You should only use it when a strict "IS-A"
relationship exists. In Java, a class can only
extend one parent class to avoid the "Diamond Problem"
of multiple inheritance.
*/
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialDeposit, double interestRate){
        super(accountNumber, initialDeposit);
        this.interestRate = interestRate;
    }

    // Specialized behavior only available to Savings Accounts
    public void applyInterest(){
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
    }
}
