package org.example;

import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        // Method level variables
        Scanner scanner = new Scanner(System.in);
        String errMsg = "";
        String email = "";
        int pin = 0;
        int age = 0;

        // Get user age
        while(true){
            try{
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Age must be greater than 0.");
                }
                break;
            } catch (NumberFormatException e){
                System.out.println("Invalid Input. Enter a number.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println(e.toString());
            }
        }


        // Get user email
        while(true){
            try{
                System.out.print("Enter your email: ");
                email = scanner.nextLine();
                // cannot be empty
                if(email == null || email.trim().isEmpty()){
//                    throw new IllegalArgumentException("Email cannot be empty");
                    errMsg = "Email cannot be empty";
                }
                //  must have @
                if(!email.contains("@")){
//                    throw new IllegalArgumentException("Email must contain an @ character");
                    errMsg += "\nEmail must contain an @ character";
                }
                // must have a decimal
                if(!email.contains(".")){
//                    throw new IllegalArgumentException("Email must have the . character");
                    errMsg += "\nEmail must have the . character";
                }

                if(!errMsg.isEmpty()){
                    throw new IllegalArgumentException(errMsg);
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


        // Get user PIN
        while(true) {
            try {
                System.out.print("Enter your 4-digit PIN: ");
                String pinInput = scanner.nextLine();
                if(!pinInput.matches("\\d{4}")){
                    throw new IllegalArgumentException("PIN must be 4 numeric digits");
                }

                pin = Integer.parseInt(pinInput);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


        // Print details
        System.out.println("\nRegistration Successful!");
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("PIN: " + pin);
    }
}
