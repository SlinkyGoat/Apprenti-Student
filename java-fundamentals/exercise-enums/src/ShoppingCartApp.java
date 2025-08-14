public class ShoppingCartApp {
    public static void main(String[] args) {
        System.out.println("Welcome to shopping-cart.net!");
        // Product:
        // Product ID is 1
        // Product Category is 2
        // Product Cost is 2.56
        // Product Price is 4.99
        // Product Quantity is 78

        //EXERCISE ASSIGNMENT HERE
        //Create enums for order status and shipping status.
        // Here are the options as per decisions made by the team:
            //Order status: pending, processing, shipped, delivered
            // Shipping status: standard, 2-day, overnight
        enum OrderStatus {
            PENDING,
            PROCESSING,
            SHIPPED,
            DELIVERED,
        }
        System.out.print("Here are the order statuses: ");
        for(OrderStatus status : OrderStatus.values()){
            System.out.print(status + " ");
        }
        System.out.println();

        enum ShippingStatus {
            STANDARD,
            TWO_DAY,
            OVERNIGHT,
        }
        System.out.print("Here are the shipping statuses: ");
        for(ShippingStatus status : ShippingStatus.values()){
            System.out.print(status + " ");
        }
        System.out.println();

        //Assign variables to each of the elements from above.
        int productId = 1;
        int productCategory = 2;
        double productCost = 2.56;
        double productPrice = 4.99;
        int productQuantity = 78;

        OrderStatus orderStatus = OrderStatus.PENDING;
        ShippingStatus shippingType = ShippingStatus.OVERNIGHT;
        
        //Calculate the total cost of the product based on the
        // inventory.
        double totalCost = productCost * productQuantity;
        System.out.println("The total cost is: " + totalCost);

        // Calculate the profit margin of the product.
        double profitMargin = productPrice - productCost;
        System.out.println("The profit margin is: " + profitMargin);

        //Calculate the total potential profit.
        // total profit? profitMargin * productQuantity
        double totalProfit = profitMargin * productQuantity;
        System.out.println("the total profit is: " + String.format("%.2f", totalProfit));

        //Final Message
        System.out.println("Thank you for shopping with your cart at the shopping-cart.net");
    }
}
