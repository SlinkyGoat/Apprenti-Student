package org.example.shoppingcart;

/**
 * If tax exempt don't charge tax.
 * If order total is more than $100 apply discount 5%
 * If order total is more than $500 apply discount 10%
 * If promo code is valid, apply free shipping (unless next-day or 2-day)
 */
public class ShoppingCartApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the shopping cart app!");

        java.util.Scanner console = new java.util.Scanner(System.in);

        double productPrice = 4.99;
        int productQuantity = 78;
        boolean isValid = false;
        String taxExempt = "";
        double tax = 0.07;
        String shipping = "";



        // Prompt for tax exempt
        while(!isValid){
            System.out.print("Are you tax-exempt? (y/n) ");
            taxExempt = console.nextLine();
            if(taxExempt.equalsIgnoreCase("y") || taxExempt.equalsIgnoreCase("n")){
                isValid = true;
            } else {
                System.out.println("Please enter a valid response: 'y' for YES or 'n' for NO");
            }
        }
        if(taxExempt.equalsIgnoreCase("y")){
            tax = 0.0;
        }


        // Prompt for shipping
        isValid = false;
        while(!isValid){
            System.out.print("Shipping? (standard / overnight / two-day) ");
            shipping = console.nextLine();
            if(shipping.equalsIgnoreCase("standard") || shipping.equalsIgnoreCase("overnight") || shipping.equalsIgnoreCase("two-day")){
                isValid = true;
            } else {
                System.out.println("Please enter a valid response");
            }
        }


        // Prompt for promo code
        System.out.print("Promo code for free shipping? ");
        String promoCode = console.nextLine();
        boolean validPromo = promoCode.contains("a"); // promo is valid if it contains the letter 'a'

        // Print details
        System.out.println("\nDetails:");
        System.out.println("Tax-exempt: " + taxExempt);
        double shippingCost = 0.0;
        if(shipping.equalsIgnoreCase("standard")){
            shippingCost = 2.0;
        } else if (shipping.equalsIgnoreCase("two-day")){
            shippingCost = 5.0;
        } else if(shipping.equalsIgnoreCase("overnight")){
            shippingCost = 10.0;
        }
        System.out.println("Shipping: $" + shippingCost + " - " + shipping);
        System.out.println("Promo code: " + promoCode);
        if(validPromo){
            System.out.println("Valid promo - Shipping cost waived.");
            shippingCost = 0.0;
        }
        System.out.println("Product Price: $" + productPrice);
        System.out.println("Product Quantity: " + productQuantity);
        double preTaxCost = productPrice * productQuantity + shippingCost;
        if(preTaxCost > 500.0){
            preTaxCost *= 0.9;

        } else if (preTaxCost > 100.0){
            preTaxCost *= 0.95;
        }
        System.out.println("Total Cost Before Tax: $" + preTaxCost);
        System.out.println("Total Cost After Tax: $" + preTaxCost * (1 + tax));

        System.out.println("Bye");
    }
}