package Bank;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- 1. Testing Encapsulation (BankAccount) ---");
        BankAccount basicAcc = new BankAccount("ACC-001", 500.0);
        System.out.println("Account Number: " + basicAcc.getAccountNumber());
        System.out.println("Initial Balance: $" + basicAcc.getBalance());

        basicAcc.deposit(150.0);
        System.out.println("After $150 Deposit: $" + basicAcc.getBalance());

        // basicAcc.balance = 10000.0; // ERROR: Cannot do this because 'balance' is private!
        // basicAcc.withdraw(1000.0);  // ERROR: This would throw an IllegalStateException!


        System.out.println("\n--- 2. Testing Inheritance (SavingsAccount) ---");
        // SavingsAccount IS-A BankAccount, so it has access to getBalance() and deposit()
        SavingsAccount savings = new SavingsAccount("SAV-002", 1000.0, 5.0); // 5% interest rate
        System.out.println("Initial Savings Balance: $" + savings.getBalance());

        savings.applyInterest(); // Specific to SavingsAccount
        System.out.println("After Applying 5% Interest: $" + savings.getBalance());


        System.out.println("\n--- 3. Testing Polymorphism ---");

        System.out.println(">> Compile-Time (Overloading):");
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("1234-5678-9012", 250.0);
        processor.processPayment("user@email.com", 75.50, "USD");

        System.out.println("\n>> Run-Time (Overriding & Dynamic Dispatch):");
        // Notice the reference type is 'BankAccount', but the object is 'CheckingAccount'
        BankAccount myChecking = new CheckingAccount("CHK-003", 100.0);
        System.out.println("Initial Checking Balance: $" + myChecking.getBalance());

        System.out.println("Attempting to withdraw $120...");
        // Java dynamically calls the CheckingAccount's version of withdraw() at runtime
        myChecking.withdraw(120.0);
        System.out.println("Checking Balance after Overdraft: $" + myChecking.getBalance());


        System.out.println("\n--- 4. Testing Abstraction ---");
        // Reference type is the Abstract Class, Object is the Concrete Implementation
        BankUser user = new PremiumUser("Alice", "secureHash123");

        System.out.println("User: " + user.getName());
        System.out.println("Transaction Limit: $" + user.getTransactionLimit()); // Implemented in PremiumUser

        System.out.println("Authentication attempt 1 (correct): " + user.authenticate("secureHash123"));
        System.out.println("Authentication attempt 2 (wrong): " + user.authenticate("wrongPassword"));

        // Testing the Securable interface implementation
        user.lockAccount();
        System.out.println("Authentication attempt 3 (after lock): " + user.authenticate("secureHash123"));
    }
}
