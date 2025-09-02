package org.example;

public class ShoppingCart {
    public double checkoutShoppingCart (Item[] items, double taxRate, double discountCode) {
        return applyTax(applyDiscount(subTotal(items), discountCode), taxRate);
    }

    public double applyTax(double currentTotal, double taxRate){
        double tax = currentTotal * taxRate;
        return currentTotal + tax;
    }

    public double applyDiscount(double currentTotal, double discount){
        discount *= currentTotal;
        return currentTotal - discount;
    }

    public double subTotal(Item[] items){
        double total = 0.0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }
}
