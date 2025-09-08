import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 1. Create an ArrayList
        ArrayList<String> classes = new ArrayList<>();

        // 2. Add elements
        classes.add("Warlock");
        classes.add("Bard");
        classes.add("Barbarian");
        classes.add("Ranger");
        classes.add("Cleric");
        classes.add("Fighter");

        // 3. Retrieve an element
        System.out.println("The third element is: " + classes.get(2)); // third item is index 2

        // 4. Remove an element
        classes.remove(1); // second item is index 1

        // 5. Check the size
        System.out.println("The total number of classes remaining is " + classes.size());

        // 6. Check if empty
        System.out.println("The list of classes is empty: " + classes.isEmpty());

        // 7. Sort the list
        System.out.println("------- Unsorted List -------");
        for(String dndClass : classes){
            System.out.println((classes.indexOf(dndClass) + 1) + ". " + dndClass);
        }

        java.util.Collections.sort(classes);
        System.out.println("------- Sorted List -------");
        for(String dndClass : classes){
            System.out.println((classes.indexOf(dndClass) + 1) + ". " + dndClass);
        }

        // Bonus Challenge
        // create new list
        ArrayList<String> moreClasses = new ArrayList<>();
        moreClasses.add("Wizard");
        moreClasses.add("Monk");
        moreClasses.add("Sorcerer");
        moreClasses.add("Druid");

        // merge lists
        classes.addAll(moreClasses);

        // sort list
        java.util.Collections.sort(classes);

        System.out.println("------- Final List -------");
        for(String dndClass : classes){
            System.out.println((classes.indexOf(dndClass) + 1) + ". " + dndClass);
        }
    }

}
