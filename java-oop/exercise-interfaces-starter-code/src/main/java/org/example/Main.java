package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Before proceeding with the Main class, perform the following:
        1) Create three classes that implement the `Connectable` interface within the project.
            You should have the following devices:
            * TV
            * Fridge
            * Toaster
        2) Modify those classes to implement the desired behaviours within each:
            * Each class needs a property to capture the state, a boolean, to capture whether the device is on or off
            * Modify the methods as appropriate
            * The getName() method simply can return a hardcoded value representing the device type
        */

        // Define an array of devices to store 5 devices
        Scanner in = new Scanner(System.in);
        Connectable[] devices = new Connectable[5];

        System.out.println("Welcome to the Device Manager App!!");
        System.out.println("===================================\n");

        System.out.println("Setup the devices");
        System.out.println("=================\n");


        // Loop through the array of devices
        // - Prompt user for device type to add
        // - Create the device instance
        // - Store the instance in the array
        int userChoice = 0;
        for (int i = 0; i < 5; i++) {
            userChoice = promptInt("""
                    What device would you like to add:
                    [1]. TV
                    [2]. Fridge
                    [3]. Toaster""", 1, 3);

            switch(userChoice){
                case 1:
                    devices[i] = new TV();
                    break;
                case 2:
                    devices[i] = new Fridge();
                    break;
                case 3:
                    devices[i] = new Toaster();
                    break;
                default:
                    System.out.println("Something went wrong, this should never execute");
            }
        }


        System.out.println("Interact with the devices");
        System.out.println("=========================\n");
        // Come up with a menu system which will provide the following:
        // Select the device (one of the 5 in our array)
        // Device Menu Options:
        // - 1. Get Device Name
        // - 2. Turn On Device
        // - 3. Turn Off Device
        // - 4. Get Device Status
        // - 5. Quit
        // This process should continue until the user enters '5' to Quit

        // main loop to choose device
        while(true){
            userChoice = promptInt("Choose a device to manage (1-5) or six (6) to exit", 1, 6);
            if(userChoice == 6){ // check if user wants to exit first
                break;
            } else{ // user chose device

                int deviceNumber = userChoice - 1;

                // secondary loop to manage chosen device
                boolean manageDevice = true;
                while(manageDevice){
                    System.out.println("What would you like to do with device #" + (deviceNumber + 1) + ":");
                    userChoice = promptInt("""
                            [1]. Get Device Name
                            [2]. Turn On Device
                            [3]. Turn Off Device
                            [4]. Get Device Status
                            [5]. Quit""", 1, 5);
                    switch(userChoice){
                        case 1: // get device name
                            System.out.println(devices[deviceNumber].getName());
                            break;
                        case 2: // turn device ON
                            devices[deviceNumber].turnOn();
                            System.out.println("Turned device ON");
                            break;
                        case 3: // turn device OFF
                            devices[deviceNumber].turnOff();
                            System.out.println("Turned device OFF");
                            break;
                        case 4: // get device status (ON/OFF)
                            if(devices[deviceNumber].getState()){
                                System.out.println("Device is ON");
                            } else{
                                System.out.println("Device is OFF");
                            }
                            break;
                        case 5: // quit secondary loop
                            System.out.println("Going back to device selection menu . . . ");
                            manageDevice = false;
                            break;
                        default:
                            System.out.println("Something went very wrong, should never get here");
                    }
                }
            }

        }

        System.out.println("\nThanks for using the Device Manager App. Bye!");
    }

    // Utility method to prompt user for integer input
    public static int promptInt(String message) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {

            try {
                System.out.println(message);
                String input = sc.nextLine();
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input");
            }
        }
        return result;
    }

    // Utility method to prompt user for integer input within a range
    public static int promptInt(String message, int min, int max) {
        int result = 0;

        boolean isValid = false;
        while (!isValid) {
            result = promptInt(message);
            if (result > max || result < min) {
                System.out.println("Entry out of range: " + min + " - " + max + ". Try again.");
            }
            else {
                isValid = true;
            }
        }
        return result;
    }
}