import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Initialize variables
        Scanner in = new Scanner(System.in);
        String artifactName;
        int yearOfDiscovery;
        String firstName;
        String lastName;
        String specialty;
        Artifact artifact;

        // get artifact name
        System.out.print("Enter the name of a new artifact: ");
        artifactName = in.nextLine();

        // get year found
        System.out.print("Enter the year of its discovery: ");
        while(true){
            try{
                yearOfDiscovery = Integer.parseInt(in.nextLine());
                break;
            } catch (Exception e){
                System.out.print("Please enter a valid year number: ");
            }
        }

        // get discoverer name
        System.out.print("Enter the name of the discoverer: ");
        while(true){
            try{
                String name = in.nextLine();
                firstName = name.substring(0, name.indexOf(" "));
                lastName = name.substring(name.indexOf(" ") + 1);
                break;
            } catch(StringIndexOutOfBoundsException e){
                System.out.println("Please enter the full name [first] [last]");
            } catch (Exception e){
                System.out.println("Please enter a valid name");
            }
        }

        System.out.print("What is the discoverer's specialty: ");
        specialty = in.nextLine();
        Person discoverer = new Person(firstName, lastName, specialty);

        // set artifact discoverer/curator based on if they are the same person or not
        System.out.print("Is the discoverer also the curator? (y/n) ");
        if(in.nextLine().equals("y")){
            artifact = new Artifact(artifactName, discoverer, discoverer, yearOfDiscovery);
        } else{
            System.out.print("Enter the name of the curator: ");
            while(true){
                try{
                    String name = in.nextLine();
                    firstName = name.substring(0, name.indexOf(" "));
                    lastName = name.substring(name.indexOf(" ") + 1);
                    break;
                } catch(StringIndexOutOfBoundsException e){
                    System.out.println("Please enter the full name [first] [last]");
                } catch (Exception e){
                    System.out.println("Please enter a valid name");
                }
            }
            System.out.print("What is the curator's specialty: ");
            specialty = in.nextLine();
            Person curator = new Person(firstName, lastName, specialty);
            artifact = new Artifact(artifactName, discoverer, curator, yearOfDiscovery);
        }

        System.out.println(artifact.toString());

    }

}
