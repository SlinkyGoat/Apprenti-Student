public class PlayerLevel {

    public static void main(String[] args) {
        //    Declare and initialize variables:
        int currentXP = 1200;
        int level = 5;
        int xpToNextLevel = 1500;
        boolean levelUp;

//     1. Use Arithmetic Operators:
//            Add +300 XP when completing a quest (+=).
//            Reduce xpToNextLevel dynamically as XP increases (-=).
//            Multiply XP if player earns a double XP boost (*=).
        int xpFromQuest = 300;
        boolean isXpBoost = true;
        xpFromQuest = isXpBoost ? xpFromQuest *= 2 : xpFromQuest;
        currentXP += xpFromQuest;
        xpToNextLevel -= xpFromQuest;

//     2. Use Comparison Operators:
//            Check if currentXP is greater than or equal to xpToNextLevel.
//            Check if the player has reached Level 10.
        boolean hasEnoughXp = currentXP >= xpToNextLevel;
        boolean reachedLevelTen = level >= 10;
//      3. Use Logical Operators:
//            Determine if the player levels up (XP requirement met AND level < 10).
//            Determine if the player is a pro (Level > 7 OR XP over 5000).
        levelUp = hasEnoughXp && level < 10;
        boolean isPro = level > 7 && currentXP > 5000;
//       4. Print the updated values and level-up status.
        System.out.println("The player has enough xp to go to the next level: " + hasEnoughXp);
        System.out.println("The player has reached level 10: " + reachedLevelTen);
        System.out.println("The player can level up: " + levelUp);
        System.out.println("The player is a pro: " + isPro);

    }


}
