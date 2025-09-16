import java.io.*;

public class Main {

    public static void main(String[] args) {

        // Part 1: Create a New File
        File file = new File("student_data.txt");
        boolean success = false;

        try{
            success = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(success){
            System.out.println("File was created");
        } else {
            System.out.println("File already existed or error was thrown");
        }


        // Part 2: Write Data to the File
        try(PrintWriter writer = new PrintWriter(file)){
            writer.println("Alice, A");
            writer.println("Bob, b");
            writer.println("Charlie, A+");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } // auto closes file with try-resources so no finally block is needed


        // Part 3: Append Data to the File
        try(FileWriter fileWriter = new FileWriter("student_data.txt", true);
                PrintWriter writer = new PrintWriter(fileWriter)){
            writer.println("David, B+");
            writer.println("Eva, A");
        } catch (IOException e){
            e.printStackTrace();
        } // again file does not need closing because of try-resources


        // Part 4: Read Data from the File
        try(FileReader fileReader = new FileReader("student_data.txt");
                BufferedReader reader = new BufferedReader(fileReader)){
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        // Part 5: Path Exploration
        String absolutePath = "C:\\Users\\Adam\\Desktop\\Apprenti-Work\\Apprenti-Student\\java-advanced\\file-io\\student_data.txt";
        String relativePath = "student_data.txt";


        // Part 6: Delete the File
        success = file.delete();
        if(success){
            System.out.println("File was successfully deleted");
        } else {
            System.out.println("File was unable to be deleted");
        }


        // Part 7: Reflection Questions
        /*
        1. Many systems such as Windows vs Mac store files differently and can have different absolute path to the
            same file. Additionally, even on the same OS system, users can have different paths to the same file such
            as the Users directory on Windows containing folders with your name which would be different for each person.

        2. If you do not use try-with-resources there is a possibility you can forget to close the file or stream which
            will leave it open possibly using resources and taking up unnecessary space on the computer.

        3. There are many cases which you would want to append to a file. A simple example is creating a database of
            users for an organization. You likely won't want to delete anyone's information, but people will be joining
            constantly meaning you want to add them to the file/database without deleting all the previous users that
            are likely still active.

        4. Again there are tons of examples. Grabbing data from users, the internet, your own computer, etc. There are
            massive amounts of data that can be collected and processed, but you need to store the data somewhere.
            This data can be stored via file i/o.
         */

    }

}
