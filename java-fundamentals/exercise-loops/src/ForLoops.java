import java.util.Scanner;

public class ForLoops {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

    //1. Count Up! (For Loop)
    //● Write a program that prints numbers 1 to 100 using a for loop.
        for(int x = 1; x <= 100; x++){
            System.out.println(x);
        }
    //● Modify the program to print only even numbers.
        for(int x = 2; x <= 100; x += 2){
            System.out.println(x);
        }

    //2.Multiplication Table (For Loop)
    //● Ask the user for a number.
        System.out.print("Please enter a number: ");
        int userNumber = in.nextInt();
    //● Print the multiplication table (1 to 10) for that number
        System.out.println("Here is the multiplication table (1-10) for " + userNumber);
        for(int x = 1; x <= 10; x++){
            System.out.println(userNumber * x);
        }

    }
}
