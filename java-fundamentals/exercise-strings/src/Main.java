public class Main {

    public static void main(String[] args) {

        /*
        PART 1
         */
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;
        System.out.println("the full name is " + fullName);

        int nameLength = fullName.length();
        System.out.println("name length is " + nameLength + " characters long.");

        char firstChar = fullName.charAt(0);
        System.out.println("The first character of the name is " + firstChar);

        int letterPosition = fullName.indexOf('r');
        System.out.println("The first index of the letter 'r' is at index " + letterPosition);


        /*
        PART 2
         */
        String sentence = "Learning Java is fun!";

        String word1 = sentence.substring(0, 8);
        String word2 = sentence.substring(9, 13);
        String word3 = sentence.substring(17);

        System.out.println("The first word is " + word1);
        System.out.println("The second word is " + word2);
        System.out.println("The last word is " + word3);


        /*
        PART 3
         */
        String csvData = "apple,banana,grape,orange";

        String[] data = csvData.split(",");
        for(int x = 0; x < data.length; x++){
            System.out.println("Fruit " + (x + 1) + ": " + data[x]);
        }


        /*
        PART 4
         */
        sentence = "The quick brown fox.";
        sentence = sentence.replace("quick", "slow").replace(" ", "_");
        System.out.println(sentence);


        /*
        PART 5
         */
        String nullString = null;
        if(nullString == null){
            System.out.println("String is null");
        } else {
            System.out.println("String length is " + nullString.length());
        }
        String emptyString = "";
        if(emptyString == null){
            System.out.println("String is null");
        } else {
            System.out.println("String length is " + emptyString.length());
        }


    }

}
