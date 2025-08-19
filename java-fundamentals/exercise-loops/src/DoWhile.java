import java.util.Random;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        //Guess the Number (Do-While Loop)
        //● Generate a random number between 1 and 50.
        Random r = new Random();
        Scanner in = new Scanner(System.in);
        int randomNumber = r.nextInt(50) + 1;
        int userGuess;
        //● Ask the user to guess the number.
        //● Keep asking until the user gets it right using a do-while loop.
        do{
            System.out.print("Guess the random number: ");
            userGuess = in.nextInt();
            if(userGuess > randomNumber){
                System.out.println("Your guess is too high!");
            } else if(userGuess < randomNumber){
                System.out.println("Your guess is too low!");
            } else{
                System.out.println("You guess correctly!");
            }
        } while(userGuess != randomNumber);


//        Simple ATM System (Do-While Loop)
//        ● Start with an account balance of $500.
        double accountBalance = 500.0;
//        ● Ask the user if they want to:
        int userResponse;
//        ○ 1 Withdraw
//        ○ 2 Deposit
//        ○ 3 Check Balance
//        ○ 4 Exit
//        ● Use a do-while loop to keep asking until they choose to exit
        do{
            System.out.println("""
                    What would you like to do:
                    1. Withdraw
                    2. Deposit
                    3. Check Balance
                    4. Exit
                    """);
            userResponse = in.nextInt();
            switch (userResponse){
                case 1:
                    System.out.print("How much would you like to withdraw: ");
                    accountBalance -= in.nextInt(); // can go negative but I'll allow it for now
                    break;
                case 2:
                    System.out.print("How much would you like to deposit: ");
                    accountBalance += in.nextInt();
                    break;
                case 3:
                    System.out.println("You have a balance of $" + accountBalance);
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Please enter a valid number on the list");
            }

        }while(userResponse != 4);


    }
}
