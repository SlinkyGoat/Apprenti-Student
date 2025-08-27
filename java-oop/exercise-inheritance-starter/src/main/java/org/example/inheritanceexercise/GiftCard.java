package org.example.inheritanceexercise;

public class GiftCard extends Payment{

    private String accountNumber;
    private double balance;
    private int accumulatedLoyaltyPoints;

    public GiftCard(int id, double amount, String accountNumber, double balance, int accumulatedLoyaltyPoints) {
        super(id, amount);
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accumulatedLoyaltyPoints = accumulatedLoyaltyPoints;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing gift card and adding loyalty points...");
        if(balance >= getAmount()){
            balance -= getAmount();
            accumulatedLoyaltyPoints += (int) (100 * getAmount());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return super.toString() + "  Type: Gift Card  Balance: $" + String.format("%.2f", balance) +
                "  Loyalty Points: " + accumulatedLoyaltyPoints;
    }
}
