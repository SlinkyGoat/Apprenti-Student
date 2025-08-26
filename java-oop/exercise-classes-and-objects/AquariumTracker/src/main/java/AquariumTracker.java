import java.util.Scanner;

public class AquariumTracker {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the information for your fish.");
        System.out.print("Species Name: ");
        String speciesName = in.nextLine();
        System.out.print("Common Name: ");
        String commonName = in.nextLine();
        System.out.print("Maximum Temperature: ");
        double maxTemp = Double.parseDouble(in.nextLine());
        System.out.print("Minimum Temperature: ");
        double minTemp = Double.parseDouble(in.nextLine());
        System.out.print("Diet: ");
        String diet = in.nextLine();

        AquariumFish fish = new AquariumFish(speciesName, commonName, maxTemp, minTemp, diet);

        System.out.println("The average temperature is: " + fish.averageTemperature() + "℉");


    }

}
