import java.util.Scanner;

public class Decisions {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String playerResponse = "";
        int playerChoice = 0;
        boolean isValid = false;

        // Game introduction and start menu
        System.out.println("Welcome to Tasha's Cave of Everything!");
        while(!isValid){
            System.out.print("Would you like to enter the cave? (y/n) ");
            playerResponse = in.nextLine();
            if(playerResponse.equalsIgnoreCase("y") || playerResponse.equalsIgnoreCase("n")){
                isValid = true;
            } else {
                System.out.println("Please enter a valid input... 'y' for YES or 'n' for NO");
            }
        }

        // player does not enter the cave
        if(playerResponse.equalsIgnoreCase("n")){
            System.out.println("Maybe the next adventurer will be braver than you.");
            System.exit(0);
        } else {
            // player enters the cave
            System.out.println("I hope you're brave enough to make your way through the cave!");
        }

        // part 3, choose a path
        isValid = false;
        while(!isValid) {
            System.out.println("You have two paths ahead. Would you like to go left (l) or right (r)");
            playerResponse = in.nextLine();
            if(playerResponse.equalsIgnoreCase("l") || playerResponse.equalsIgnoreCase("r")){
                isValid = true;
            } else {
                System.out.println("Please enter a valid input... 'l' for LEFT or 'r' for RIGHT");
            }
        }

        if(playerResponse.equalsIgnoreCase("l")){

            System.out.println("You decided to go left!");
            System.out.println("Uh oh! You encounter a hob-goblin!");
            isValid = false;
            while(!isValid){
                System.out.println("Would you like to fight or flee? ");
                playerResponse = in.nextLine();
                if(playerResponse.equalsIgnoreCase("fight") || playerResponse.equalsIgnoreCase("flee")){
                    isValid = true;
                } else {
                    System.out.println("Please enter a valid response");
                }
            }

            if(playerResponse.equalsIgnoreCase("fight")){
                // player chooses to fight
                System.out.println("What weapon would you like to use? ");
                System.out.println("1. Sword\n2. Bow\n3. Spear\n4. Greataxe\n5. Dagger\n6. Fists");
                isValid = false;
                while(!isValid){
                    try{
                        playerResponse = in.nextLine();
                        playerChoice = Integer.parseInt(playerResponse);
                        if(playerChoice > 6 || playerChoice < 1){
                            System.out.println("Please enter a valid number 1-6");
                        } else {
                            isValid = true;
                        }
                    } catch (Exception e){
                        System.out.println("Please enter a valid number 1-6");
                    }
                }
                // using isValid to see if user will defeat enemy
                // enhanced switch statement shown from Intellij tooltips
                isValid = switch (playerChoice) {
                    case 1 -> true;
                    case 2 -> false;
                    case 3 -> false;
                    case 4 -> true;
                    case 5 -> false;
                    case 6 -> false;
                    default -> false;
                };
                if(isValid){
                    System.out.println("Congratulations! You beat the hob-goblin!");
                    System.out.println("It looks like the hob-goblin was defending something!");
                } else {
                    System.out.println("The hob-goblin was too mighty for you. You died!");
                    System.exit(0);
                }

            } else {
                // player chooses flee
                System.out.println("The hob-goblin is too scary for you and you run away.");
                System.out.println("As you flee the hob-goblin chases with frightening speed you you exit the cave just in time!");
                System.out.println("Maybe next time you'll be stronger!");
                System.exit(0);
            }

        } else {
            // player chooses to go right
            System.out.println("You decide to go right.");
        }

        // Player only gets to this point in code if they turned right or fought the enemy when they turned left
        System.out.println("Ahead of you lies a chest glittering with gold coins and sparkling stones.");
        // text block again from intellij tooltips... I'm learning so much!
        System.out.println("""
                As you open the chest you see three items. Would you like to grab\
                
                1. A large enigmatic gem
                2. A small, but infinitely complex key
                3. A weathered book with ancient scribblings""");
        isValid = false;
        while(!isValid){
            try{
                playerResponse = in.nextLine();
                playerChoice = Integer.parseInt(playerResponse);
                if(playerChoice > 3 || playerChoice < 1){
                    System.out.println("Please enter a valid number 1-3");
                } else {
                    isValid = true;
                }
            } catch (Exception e){
                System.out.println("Please enter a valid number 1-3");
            }
        }

        switch(playerChoice){
            case 1: //gem
                System.out.println("As you pick up the gem you feel magical power rushing around you.");
                System.out.println("The gem's color reminds you of your parents and suddenly the gem turns transparent and you can see your parents in the gem.");
                System.out.println("Congratulations! You for the orb of sight!");
                break;
            case 2: //key
                System.out.println("As you pick up the key you admire its intricacies and the complexity built into it. Obviously it is of importance.");
                System.out.println("As you inspect it further you see an etching \"Astea\" the name of your kingdom.");
                System.out.println("Congratulations! You found the lost key to the kingdom's vaults!");
                break;
            case 3: //book
                System.out.println("As you reach for the book your eyes roll back and your mind is bombarded with infinite knowledge.");
                System.out.println("After only a few seconds, which felt like hundreds of years, you regain your composure, though with new knowledge");
                System.out.println("Congratulations! You found the dark wizard's forgotten journal!");
                break;
            default:
                System.out.println("The treasure detects you attempting to do something suspicious and it blows up!");
                System.out.println("Your greed got the better of you. You died!");
        }

    }
}
