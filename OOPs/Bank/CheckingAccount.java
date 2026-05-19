package Bank;

/*
* B. Run-Time Polymorphism (Method Overriding & Dynamic Dispatch)
* A subclass provides a specific implementation of a method already
* defined in its parent class. This is the true power of OOP.
* */

public class CheckingAccount extends BankAccount {

    private double overdraftFee = 35.0;

    public CheckingAccount(String accountNumber, double initialDeposit){
        super(accountNumber, initialDeposit);
    }

    // @Override ensures we are actually overriding a parent method, not making a typo
    @Override
    public void withdraw(double amount){
        if(amount > getBalance()){
            System.out.println("Overdraft triggered! Charging fee.");
            super.withdraw(amount + overdraftFee);
        }
        else {
            super.withdraw(amount);
        }
    }
}
