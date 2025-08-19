package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner console = new java.util.Scanner(System.in);

        System.out.println("Welcome to the shopping cart app!");

        String taxExempt = "";
        String shipping = "";
        String promoCode = "";
        int orderQuantity = 0;

        boolean confirm = false;
        while(!confirm) {

            System.out.println("""
                    Enter your option:
                    1. Tax exemption
                    2. Shipping method
                    3. Order amount
                    4. Promo code
                    """);
            switch(console.nextInt()){
                case 1:
                    // Prompt for tax exempt
                    System.out.println("Are you tax-exempt? (y/n)");
                    taxExempt = console.nextLine();
                    System.out.println("You chose tax exemption: " + taxExempt);
                    break;
                case 2:
                    // Prompt for shipping
                    System.out.println("Shipping? (standard/overnight/twoday)");
                    shipping = console.nextLine();
                    System.out.println("You chose shipping method: " + shipping);
                    break;
                case 3:
                    // Prompt for order quantity
                    System.out.println("Order quantity?");
                    orderQuantity = Integer.parseInt(console.nextLine());
                    System.out.println("Your order quantity is: " + orderQuantity);
                    break;
                case 4:
                    // Prompt for promo code
                    System.out.println("Promo code for free shipping?");
                    promoCode = console.nextLine();
                    System.out.println("Your promo code is : " + promoCode);
                    break;
                default:
                    System.out.println("invalid input, please choose a number 1-4");
                    continue;
            }


            System.out.println("confirm order? (y/n) ");
            confirm = console.nextLine().equalsIgnoreCase("y");

        }

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        System.out.println("Shipping: " + shipping);
        System.out.println("Order quantity: " + orderQuantity);
        System.out.println("Promo code: " + promoCode);


        System.out.println("Bye");
    }
}