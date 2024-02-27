import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Anthony Meza ameza72@toromail.csudh.edu
public class NumberFileReader {
    public static void main(String[] args) {
        try {
            NumberFileReader fr = new NumberFileReader("./numberFile.txt");
            int[] numbers = fr.read();
            System.out.println("Numbers read from file:");
            for (int number : numbers) {
                System.out.println(number);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private String fileName; // File name to read from

    // Constructor to initialize the file name
    public NumberFileReader(String fileName) {
        this.fileName = fileName;
    }

    // Method to read the file and return the array of numbers
    public int[] read() throws IOException {
        List<Integer> numbersList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse each line as an integer and add it to the list
                numbersList.add(Integer.parseInt(line.trim()));
            }
        }

        // Convert List<Integer> to int[]
        int[] numbersArray = new int[numbersList.size()];
        for (int i = 0; i < numbersList.size(); i++) {
            numbersArray[i] = numbersList.get(i);
        }

        return numbersArray;
    }
}
