import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Part 1: Create a New File
        File file = new File("student_data.txt");

        try{
            if(file.createNewFile()){
                System.out.println("File created");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        // Part 2: Write Data to the File
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Alice, A");
            writer.println("Bob, B");
            writer.println("Charlie, A+");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        // do not need to close file because we are using try-with-resources


        // Part 3: Append Data to the File
        try (FileWriter fileWriter = new FileWriter("student_data.txt", true);
             PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.println("David, B+");
            writer.println("Eva, A");
        } catch (IOException e){
            e.printStackTrace();
        }
        // again we do not need to close file because of try-with-resources


        // Part 4: Read Data from the File
        try (FileReader fileReader = new FileReader("student_data.txt");
             BufferedReader reader = new BufferedReader(fileReader)){
            for (String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


        // Part 5: Path Exploration
        String absolutePath = "C:\\Users\\Adam\\Desktop\\Apprenti-Work\\Apprenti-Student\\advanced-java\\exercises\\exercise-file-io";
        String relativePath = "student_data.txt";


        // Part 6: Delete the File
        boolean isDeleted = file.delete();
        if(isDeleted){
            System.out.println("File was successfully deleted");
        } else {
            System.out.println("File was not deleted");
        }


        // 7: Reflection Questions
        /*
        1. Folder names and file structures can vary among different computers and operating systems which would make
        using absolute file paths difficult as you would never know exactly where to find a file starting from the root.
        Relative paths make it simpler as you start from the project directory and can move around from a known location.
        For example, my computer might use the path Users/Adam/Project/file.txt while yours may be
        Users/Anthony/Project/file.txt. They both are very similar but have different paths (Adam vs Anthony)

        2. If you do not use try-with-resources you run the risk of letting resources run without purpose if you
        forget to close the file. Try-with-resources automatically closes the files (resources) when the try block
        is done executing.

        3. In many files that act as databases you want to append instead of overwrite it. It would be very bad if
        your file containing sensitive client information suddenly disappeared because your fresh intern forgot
        to write to the file in append mode.

        4. There are near infinite cases of why file I/O is necessary. Again databases are a great example. We have
        to store information onto databases (input) and then retrieve that same data to do something with it (output)
         */
    }

}
