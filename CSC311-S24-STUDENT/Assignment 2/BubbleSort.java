import java.util.Arrays;

//Anthony Meza ameza72@toromail.csudh.edu
public class BubbleSort {
    public static void main(String[] args) {
        int[] inputArray = {23, 45, 93, 107, 81, 77};
        BubbleSort bs = new BubbleSort(inputArray);

        // Sort in ascending order
        int[] sortedAsc = bs.sortAsc();
        System.out.println("Sorted Ascending: " + Arrays.toString(sortedAsc));
        System.out.println("Loop cycles for ascending sort: " + bs.loopCycles());

        // Sort in descending order
        int[] sortedDesc = bs.sortDesc();
        System.out.println("Sorted Descending: " + Arrays.toString(sortedDesc));
        System.out.println("Loop cycles for descending sort: " + bs.loopCycles());
    }

    private int[] data; // Array to store the numbers
    private int loopCount; // Variable to store the loop count for the previous sort operation

    // Constructor to initialize the data array and set loopCount to 0
    public BubbleSort(int[] input) {
        data = Arrays.copyOf(input, input.length); // Copy input array to data array
        loopCount = 0;
    }

    // Method to perform Bubble Sort in ascending order
    public int[] sortAsc() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap data[j] and data[j+1]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                loopCount++; // Increment loop count for each comparison
            }
        }
        return data;
    }

    // Method to perform Bubble Sort in descending order
    public int[] sortDesc() {
        int n = data.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] < data[j + 1]) {
                    // Swap data[j] and data[j+1]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
                loopCount++; // Increment loop count for each comparison
            }
        }
        return data;
    }

    // Method to return the number of loop cycles for the previous sort operation
    public int loopCycles() {
        return loopCount;
    }
}
