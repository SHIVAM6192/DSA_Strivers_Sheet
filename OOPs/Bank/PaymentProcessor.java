package Bank;

/*
* 3. Polymorphism (One Interface, Multiple Forms)
* Polymorphism allows objects of different classes
* to be treated as objects of a common superclass.
* It comes in two flavors: Compile-time (Overloading)
* and Run-time (Overriding).

A. Compile-Time Polymorphism (Method Overloading)
* Methods have the same name but different
* parameters within the same class.
* */

public class PaymentProcessor {
    // Same method name, different signatures
    public void processPayment(String creditCard, double amount){
        System.out.println("Processing credit card payment of $ : " + amount);
    }

    public void processPayment(String paypalEmail, double amount, String currency){
        System.out.println("Processing PayPal payment of " + amount + " " + currency);
    }
}
