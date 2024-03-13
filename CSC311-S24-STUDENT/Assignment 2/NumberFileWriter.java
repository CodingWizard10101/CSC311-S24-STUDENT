import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//Anthony Meza ameza72@toromail.csudh.edu
public class NumberFileWriter {
    public static void main(String[] args) {
        int[] numbers = {2433, 622, 7853, 1033300, 4021, 61139};
        NumberFileWriter fw = new NumberFileWriter("./numberFileOut.txt");
        try {
            fw.write(numbers);
            System.out.println("Numbers written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private String fileName; // File name to write to

    // Constructor to initialize the file name
    public NumberFileWriter(String fileName) {
        this.fileName = fileName;
    }

    // Method to write the array of integers to the file
    public void write(int[] numbers) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int number : numbers) {
                bw.write(Integer.toString(number)); // Write each number to the file
                bw.newLine(); // Move to the next line
            }
        }
    }
}
