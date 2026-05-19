package Bank;

/*
* 4. Abstraction (Hiding the Implementation Details)
* Abstraction focuses on what an object does rather
* than how it does it. You expose only the high-level
* mechanisms and hide the complex, low-level details.
* This is achieved using abstract classes and interfaces.

* Interface: A contract. It tells you what a class must
* do, but provides no state (fields).

* Abstract Class: A partial blueprint. It can have some
* shared state and shared implementation, but leaves some
* methods blank for subclasses to fill out.
* */

interface Securable{
    boolean authenticate(String password);
    void lockAccount();
}

public abstract class BankUser implements Securable{
    private String name;
    protected boolean isLocked = false;

    public BankUser(String name) {
        this.name = name;
    }

    // Concrete method (shared logic)
    public String getName() {
        return name;
    }

    // Abstract method (forces subclasses to define their own rules)
    public abstract double getTransactionLimit();

    // Implementing interface methods
    @Override
    public void lockAccount() {
        this.isLocked = true;
        System.out.println(name + "'s account is now locked.");
    }
}

class PremiumUser extends BankUser{
    private String passwordHash;

    public PremiumUser(String name, String passwordHash){
        super(name);
    }

    @Override
    public double getTransactionLimit(){
        return 100000.00;
    }

    @Override
    public boolean authenticate(String inputPassword) {
        return inputPassword.equals(this.passwordHash) && !isLocked;
    }
}
