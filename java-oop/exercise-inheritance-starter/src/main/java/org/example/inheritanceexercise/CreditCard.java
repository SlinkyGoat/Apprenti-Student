package org.example.inheritanceexercise;

public class CreditCard extends Payment{

    private long accountNumber;
    private String cardVendor;

    public CreditCard(int id, double amount, long accountNumber, String cardVendor) {
        super(id, amount);
        this.accountNumber = accountNumber;
        this.cardVendor = cardVendor;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing via: " + cardVendor + " for $" + String.format("%.2f", getAmount()));
        return true;
    }

    @Override
    public String toString(){
        return super.toString() + "  Type: Credit Card  Vendor:  " + cardVendor;
    }

}
