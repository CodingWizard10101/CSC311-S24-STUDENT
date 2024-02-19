import java.util.ArrayList;
import java.util.Arrays;
//Anthony Meza
//ameza72@toromail.csudh.edu 
public class NumberArrayList {
    public static void main(String[] args) {
        // Create an instance of NumberArrayList with a maximum size of 500
        NumberArrayList myList = new NumberArrayList(500);

        // Add elements to myList
        myList.add(123);
        myList.add(456);
        myList.add(78);
        myList.add(321);
        myList.add(254);
        myList.add(187);
        myList.add(231);
        myList.add(364);
        myList.add(97);
        myList.add(132);

        // Output the contents of myList
        System.out.println("List: " + myList); // Output: List: 10, 20, 30, 20, 40

        // Output the size of myList
        System.out.println("Size: " + myList.size()); // Output: Size: 5

        // Output the element at index 2
        System.out.println("Element at index 2: " + myList.get(2)); // Output: Element at index 2: 30

        // Output the indices of number 20 in myList
        System.out.println("Indices of number 20: " + Arrays.toString(myList.find(20))); // Output: Indices of number 20: [1, 3]

        // Output the largest number in myList
        System.out.println("Largest number: " + myList.getLargest()); // Output: Largest number: 40

        // Output the smallest number in myList
        System.out.println("Smallest number: " + myList.getSmallest()); // Output: Smallest number: 10

        // Output the average of numbers in myList
        System.out.println("Average: " + String.format("%.2f", myList.getAverage())); // Output: Average: 24
    }

    private int maxSize; // Maximum size of the list
    private ArrayList<Integer> list; // ArrayList to store the numbers

    // Constructor to initialize the NumberArrayList with a specified size
    public NumberArrayList(int size) {
        if (size <= 0 || size > 500) {
            throw new IllegalArgumentException("Size must be between 1 and 500");
        }
        this.maxSize = size;
        this.list = new ArrayList<>();
    }

    // Method to add a number to the list
    public int add(int number) {
        // Check if the list is not full
        if (list.size() < maxSize) {
            list.add(number);
            return list.size() - 1; // return the index of the new entry
        } else {
            return -1; // indicate that the list is already full
        }
    }

    // Method to get the number at a specified index
    public int get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    // Method to get the current size of the list
    public int size() {
        return list.size();
    }

    // Method to find indices of a given number in the list
    public int[] find(int number) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                indices.add(i);
            }
        }
        return indices.stream().mapToInt(i -> i).toArray();
    }

    // Method to get the largest number in the list
    public int getLargest() {
        if (list.isEmpty()) return -1;
        int max = Integer.MIN_VALUE;
        for (int num : list) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Method to get the smallest number in the list
    public int getSmallest() {
        if (list.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;
        for (int num : list) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    // Method to calculate the average of numbers in the list
    public double getAverage() {
        if (list.isEmpty()) return -1;
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum / list.size();
    }

    // Method to override the default toString() method for printing the list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
