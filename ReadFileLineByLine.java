import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileLineByLine {
    public static void main(String[] args) {
        // Choose an input file
        File input = new File("input.txt");
        try {
            // Read an input
            Scanner sc = new Scanner(input);
            // Create an output file
            File output = new File("output.txt");
            // Create a FileWriter object to write to output
            FileWriter writer = new FileWriter(output);

            // Read input string by string
            while (sc.hasNextLine()) {

                // Split a string for separate integers
                String[] nums = sc.nextLine().split(" ");
                int len = Integer.parseInt(nums[0]);

                // Create an array to collect integers
                int[] intArray = new int[len];

                // Add integers to array
                for (int i = 1; i < len + 1; i++) {
                    intArray[i - 1] = Integer.parseInt(nums[i]);
                }

                // Collect a time data before and after sorting, save a count of iterations
                double startTime = System.nanoTime();
                int cnt = shellSort(intArray);
                double endTime = System.nanoTime();

                // Write the data to output
                writer.write(cnt + " " + ((int) (endTime - startTime)) + " " + intArray.length + "\n");
            }
            // Close the writer object
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // ShellSort realisation
    public static int shellSort(int[] a) {
        int n = a.length;
        int cnt = 0;
        for (int step = n / 2; step > 0; step = step / 2) {
            for (int i = step; i < n; i++) {
                for (int j = i - step; j > 0; j -= step) {
                    if (a[j] > a[j + step]) {
                        swap(a, j, j + step);
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
}
