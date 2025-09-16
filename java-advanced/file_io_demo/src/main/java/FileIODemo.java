import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileIODemo {
    public static void main(String[] args) {
        File file = new File("colors.txt");

        // Test File to ensure it's a file
        if(file.isDirectory()){
            System.out.println("Colors File Parameter is a directory. Cannot write to it");
            System.exit(1);
        }

        // Step 1: Create the file
        try{
            if(file.createNewFile()){
                System.out.println("Color File Created");
            } else {
                System.out.println("Color File Already Exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Write colors to the file
        try(PrintWriter writer = new PrintWriter(file)){
            writer.println("red");
            writer.println("blue");
            writer.println("green");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Step 3: Append to the file
        try(FileWriter fileWriter = new FileWriter("colors.txt", true);
                PrintWriter writer = new PrintWriter(fileWriter)){
            writer.println("yellow");
            writer.println("orange");
            writer.println("purple");
        } catch (RuntimeException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Step 4: Read from file
        try(FileReader fileReader = new FileReader("colors.txt");
                BufferedReader reader = new BufferedReader(fileReader)) {
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean success = file.delete();
        if(success){
            System.out.println("Colors File was deleted");
        } else {
            System.out.println("Unable to delete colors.txt");
        }

        // NIO Class - Writing to file
        ArrayList<String> lines = new ArrayList<>();
        lines.add("hydrogen");
        lines.add("helium");
        lines.add("lithium");

        Path path = Paths.get("elements.txt");
        try{
            Files.write(path, lines, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.clear();
        lines.add("beryllium");
        lines.add("boron");
        lines.add("borophyll");
        try{
            Files.write(path, lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the File back to the console
        try{
            for(String line: Files.readAllLines(path)){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Delete file
        try{
            success = Files.deleteIfExists(path);
            if(success){
                System.out.println("Elements File Deleted");
            } else {
                System.out.println("Elements was not deleted");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Read CSV File
        path = Paths.get("test_data.csv");
        String elements[];
        List<Student> students = new ArrayList<>();
        try{
            for(String line: Files.readAllLines(path)){
                elements = line.split(",");
                Student student = new Student();
                student.setName(elements[0]);
                student.setRole(elements[1]);
                student.setFavoriteColor(elements[2]);
                students.add(student);
            }
            for(Student student : students){
                System.out.println(student.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
