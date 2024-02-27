import java.util.Scanner;

//Anthony Meza ameza72@toromail.csudh.edu
public class FileSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the input file name
        System.out.print("Enter the name of the input file: ");
        String inputFileName = scanner.nextLine();

        // Ask user for the output file name
        System.out.print("Enter the name of the output file: ");
        String outputFileName = scanner.nextLine();

        // Read numbers from the input file
        NumberFileReader numberFileReader = new NumberFileReader(inputFileName);
        int[] numbers;
        try {
            numbers = numberFileReader.read();
        } catch (Exception e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        // Sort the numbers using Bubble Sort
        BubbleSort bubbleSort = new BubbleSort(numbers);
        int[] sortedNumbers = bubbleSort.sortAsc();

        // Write sorted numbers to the output file
        NumberFileWriter numberFileWriter = new NumberFileWriter(outputFileName);
        try {
            numberFileWriter.write(sortedNumbers);
            System.out.println("Numbers sorted and written to file successfully.");
        } catch (Exception e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}
