package StrategyDesignPattern;
 
 
 interface PaymentStrategy {
   void pay(int amount); 
 }

 class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card."); 
    }
 }

 class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
      System.out.println("Paid " + amount + " using PayPal.");   
    }
 }

 class ShoppingCart {
    private PaymentStrategy paymentStrategy;

      public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
   
    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }    
 }

 // Usage
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);

    }
}