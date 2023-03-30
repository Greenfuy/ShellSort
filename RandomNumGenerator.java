import java.io.*;
import java.util.*;

public class RandomNumGenerator {
    public static void main(String[] args) {
        // Generate between 50 and 100 strings
        int numStrings = new Random().nextInt(51) + 50;

        // Create a new file
        File file = new File("file.txt");

        try {
            // Create a FileWriter object to write to the file
            FileWriter writer = new FileWriter(file);
            for (int i = 1; i <= numStrings; i++) {
                // Generate a random count of numbers between 100 and 10000
                int count = new Random().nextInt(9901) + 100;

                // Write the count of numbers to string
                writer.write(Integer.toString(count));
                writer.write(" ");

                // Write each random number to string
                for (int j = 0; j < count; j++) {
                    int number = new Random().nextInt(10000) + 1;
                    writer.write(Integer.toString(number) + " ");
                }

                // Switch to next string
                writer.write("\n");
            }

        // Close the writer object
        writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}