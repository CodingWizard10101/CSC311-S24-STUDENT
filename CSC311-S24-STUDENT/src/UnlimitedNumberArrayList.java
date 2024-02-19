import java.util.ArrayList;
import java.util.Arrays;

//Anthony Meza
//ameza72@toromail.csudh.edu 
public class UnlimitedNumberArrayList {
    public static void main(String[] args) {
        // Create an instance of NumberArrayList with a maximum size of 500
        UnlimitedNumberArrayList myList = new UnlimitedNumberArrayList();

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

    
    private ArrayList<Integer> list; // ArrayList to store the numbers

    // Constructor to initialize the NumberArrayList with a specified size
    public UnlimitedNumberArrayList() {       
        this.list = new ArrayList<>();
    }
    // Method to add a number to the list
    public int add(int number) { 
            list.add(number);
            return list.size() - 1; // return the index of the new entry
    } 
    

    // Method to get the number at a specified index
    public int get(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return -1; //This will indicate an invalid index
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
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
        	result[i] = indices.get(i);
        }
        return result;
    }

    // Method to get the largest number in the list
    public int getLargest() {
        if (list.isEmpty()) {
        	return -1;
        }
        int largest = list.get(0); 
        for (int i = 1; i < list.size(); i++) {
        	if (list.get(i) > largest) {
        		largest = list.get(i);
        	}
        }
        return largest;
    }

    // Method to get the smallest number in the list
    public int getSmallest() {
        if (list.isEmpty()) {
        	return -1;
        }
       
        int min = list.get(0);
        for (int i =1; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
            }
        }
        return min;
    }

    // Method to calculate the average of numbers in the list
    public double getAverage() {
        if (list.isEmpty()) {
        	return -1;
        }
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return (double) sum / list.size();
        
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
