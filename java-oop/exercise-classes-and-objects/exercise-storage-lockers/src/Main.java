import java.util.Scanner;
import java.util.concurrent.locks.Lock;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        LockerManager lockerManager = new LockerManager();

        boolean exit = false;
        int menuChoice = 0;
        System.out.println("Welcome to the Storage Locker Manager!");
        while(!exit){
            System.out.println("""
                    1. Add Locker
                    2. Remover Locker
                    3. Store Item
                    4. Retrieve Item
                    5. Display All Lockers
                    6. Exit""");
            System.out.print("Choose an option: ");
            do{
                try{
                    menuChoice = Integer.parseInt(in.nextLine());
                } catch (Exception e){
                    System.out.println("Something went wrong. Please enter a valid number (1-6)");
                }
                if(menuChoice < 1 || menuChoice > 6) System.out.println("Please enter a valid number (1-6)");
            }while(menuChoice < 1 || menuChoice > 6);

            // We now have a valid user input

            Locker requestedLocker;
            switch (menuChoice){
                case 1: // Add locker
                    System.out.print("Enter locker ID: ");
                    lockerManager.addLocker(in.nextLine());
                    break;
                case 2: // remove locker
                    System.out.print("Enter locker ID: ");
                    lockerManager.removeLocker(in.nextLine());
                    break;
                case 3: // store item
                    System.out.print("Enter locker ID: ");
                    requestedLocker = lockerManager.getLocker(in.nextLine());
                    if(requestedLocker == null){
                        System.out.println("This locker does not exist");
                    } else{
                        System.out.print("Enter item to store: ");
                        requestedLocker.storeItem(in.nextLine());
                    }
                    break;
                case 4: // retrieve item
                    System.out.print("Enter locker ID: ");
                    requestedLocker = lockerManager.getLocker(in.nextLine());
                    if(requestedLocker == null){
                        System.out.println("This locker does not exist.");
                    } else{
                        requestedLocker.removeItem();
                        System.out.println("Item retrieved from locker " + requestedLocker.getLockerId());
                    }
                    break;
                case 5: // display all lockers
                    lockerManager.displayAllLockers();
                    break;
                case 6: // exit
                    System.out.println("Exiting program.");
                    exit = true;
                    break;
                default:
                    System.out.println("Something has gone VERY wrong"); // this should never execute
            }

        }


    }

}
