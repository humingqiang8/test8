public class BubbleSort {
    
    /**
     * Sorts an array using the bubble sort algorithm
     * @param array the array to be sorted
     */
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            // Inner loop for comparisons in each pass
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements
                if (array[j] > array[j + 1]) {
                    // Swap if they are in wrong order
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            
            // If no swapping occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
    
    /**
     * Utility method to print an array
     * @param array the array to be printed
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method to test the bubble sort implementation
     */
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(array);
        
        bubbleSort(array);
        
        System.out.println("Sorted array:");
        printArray(array);
    }
}