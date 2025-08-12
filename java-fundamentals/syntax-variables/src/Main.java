/*

Authored 8-12-25: Adam Ustby
 */

public class Main {
    // need static variable to be accessed in mai method
    static int hippoCount = 0;

    public static void main(String[] args) {
        // loop through 1 - 10 and count hippos
        for(int i = 0; i <= 10; i++){
            hippoCount++;
            System.out.print(hippoCount + " Hippopotamus\n");
        }

        // common data types as variables
        int height = 170;
        double weight = 175.5;
        float pi = 3.1415926f;
        System.out.println(pi);
        char oneLetter = 'X';
        String eyeColor = "Blue";
        System.out.println(eyeColor.substring(1, 3));
        Integer age = 22;
        boolean canDrive = age >= 21;
        System.out.println(canDrive);

        int heightInches = (int) Math.round(height * 0.3937);
        System.out.println(heightInches);

        long bigNumber = 1000000000000000000L;

        double ageWeightRatio = age / weight;
        System.out.println(ageWeightRatio);

    }
}