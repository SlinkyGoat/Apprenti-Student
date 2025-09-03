package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        final double TAX_RATE = 0.13;
        final double DISCOUNT = 0.33;

        ShoppingCart cart = new ShoppingCart();
        Item[] items = {new Item()};
        items[0].setPrice(85.42);


        System.out.println("You purchased $85.42 worth of goods.");
        System.out.println("Your discount is " + DISCOUNT * 100 + "% off!");
        System.out.println("Your current tax rate is " + TAX_RATE * 100 + "%");
        System.out.println("Your total with the applied discount and tax is: $" + Math.round(cart.checkoutShoppingCart(items, TAX_RATE, DISCOUNT) * 100) / 100.0);

    }
}
