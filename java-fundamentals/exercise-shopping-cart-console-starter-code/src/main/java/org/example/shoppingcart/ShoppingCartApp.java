package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        // Define an instance of Scanner
        Scanner in = new Scanner(System.in);

        // Prompt for tax exempt
        System.out.print("Are you tax-exempt: ");
        String taxExempt = in.nextLine();

        // Prompt for shipping
        System.out.print("What is your shipping address: ");
        String shippingAddress = in.nextLine();

        // Prompt for order quantity
        int orderQuantity = -1;
        do {
            System.out.print("How many items would you like to purchase: ");
            try{
                orderQuantity = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid input.");
            }
            if(orderQuantity < 0){
                System.out.println("Please enter a positive number.");
            }
        } while (orderQuantity < 0);

        // Prompt for promo code
        System.out.print("Enter your promo code: ");
        String promoCode = in.nextLine();

        // Print details
        System.out.printf(
                """
                Shipping to: %s
                
                Number of items ordered: %d        
                """, shippingAddress, orderQuantity
        );

        System.out.println("Bye");
    }

}
