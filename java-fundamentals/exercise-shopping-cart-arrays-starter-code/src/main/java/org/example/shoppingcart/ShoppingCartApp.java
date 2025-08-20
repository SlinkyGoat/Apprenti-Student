package org.example.shoppingcart;

import java.util.Scanner;

public class ShoppingCartApp {
  public static void main(String[] args) {
    Scanner console = new java.util.Scanner(System.in);
    int shippingAddress;
    int orderQuantity;
    int size;

    System.out.println("Welcome to the shopping cart app!");

    // Create arrays to contain addresses and sizes
      String[] addresses = {"1600 Pennsylvania Avenue, Washington DC", "11 Wall Street New York, NY", "350 Fifth Avenue New York, NY 10118",
              "221 B Baker St, London, England", "Tour Eiffel Champ de Mars, Paris"};
      String[] sizes = {"Small", "Medium", "Large", "Extra Large", "Humongous"};

    // Prompt for shipping address
      for (int i = 0; i < addresses.length; i++) {
          System.out.println((i + 1) + ". " + addresses[i]);
      }
      System.out.println("Shipping address?");
      while(true){
          try{
              shippingAddress = Integer.parseInt(console.nextLine());
              if(shippingAddress < 1 || shippingAddress > addresses.length){
                  System.out.println("Please enter a valid number 1-" + addresses.length);
              } else{
                  break;
              }
          } catch (Exception e){
              System.out.println("Please enter a number.");
          }
      }

      // Prompt for quantity
      System.out.println("Quantity?");
      while(true){
          try{
              orderQuantity = Integer.parseInt(console.nextLine());
              if(orderQuantity < 0){
                  System.out.println("Please enter a valid non-negative number");
              } else{
                  break;
              }
          } catch (Exception e){
              System.out.println("Please enter a number.");
          }
      }

    // Prompt for Size
      for (int i = 0; i < sizes.length; i++) {
          System.out.println((i + 1) + ". " + sizes[i]);
      }
      System.out.println("Size?");
      while(true){
          try{
              size = Integer.parseInt(console.nextLine());
              if(size < 1 || size > sizes.length){
                  System.out.println("Please enter a valid number 1-" + sizes.length);
              } else{
                  break;
              }
          } catch (Exception e){
              System.out.println("Please enter a number.");
          }
      }

    // Print details
    System.out.println("\nDetails:");
      System.out.println("Shipping to: \t" + addresses[shippingAddress - 1]); // user entered number starting from 1 but array starts from 0
      System.out.println("Order quantity: " + orderQuantity);
      System.out.println("Size: \t\t\t" + sizes[size - 1]); // user entered number starting from 1 but array starts from 0

    System.out.println("\nBye");
  }
}
