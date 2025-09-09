import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1.
        HashMap<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        // 2.
        for(Integer i : months.keySet()){
            System.out.println(i + ": " + months.get(i));
        }

        // 3.
        List<String> cardValues = new ArrayList<String>();
        cardValues.add("Ace");
        cardValues.add("2");
        cardValues.add("3");
        cardValues.add("4");
        cardValues.add("5");
        cardValues.add("6");
        cardValues.add("7");
        cardValues.add("8");
        cardValues.add("9");
        cardValues.add("10");
        cardValues.add("Jack");
        cardValues.add("Queen");
        cardValues.add("King");

        HashMap<String, List<String>> cards = new HashMap<>();
        // make sure to pass in List by value not reference to prevent anything funky
        cards.put("Hearts", new ArrayList<String>(cardValues));
        cards.put("Diamonds", new ArrayList<String>(cardValues));
        cards.put("Clubs", new ArrayList<String>(cardValues));
        cards.put("Spades", new ArrayList<String>(cardValues));

        // 4.
        for(String suit : cards.keySet()){
            List<String> values = cards.get(suit);
            for(String value : values){
                System.out.println(value + " of " + suit);
            }
        }

    }

}
