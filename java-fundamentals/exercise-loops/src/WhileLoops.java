import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {

        //1. Countdown Timer (While Loop)
        //● Prompt the user for a starting number.
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a starting number: ");
        int startingNumber = in.nextInt();
        //● Use a while loop to count down to zero.
        while(startingNumber > 0){
            System.out.println(startingNumber);
            startingNumber--;
        }
        //● Print "Blast off!" when it reaches zero
        System.out.println("Blast off!");



        //2. Password Validator (While Loop)
        String secretPassword = "letmein";
        String userPassword = "";
        //● Ask the user to enter a password.
        //● Keep asking until they enter the correct password ("letmein").
        while(!userPassword.equals(secretPassword)){
            System.out.println("Please enter the password: ");
            userPassword = in.nextLine();
        }

    }
}
