public class EnhancedBubbleSort {
    
    /**
     * Sorts an array in ascending order using the bubble sort algorithm
     * @param array the array to be sorted
     */
    public static void bubbleSortAscending(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted or empty
        }
        
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
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
     * Sorts an array in descending order using the bubble sort algorithm
     * @param array the array to be sorted
     */
    public static void bubbleSortDescending(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Already sorted or empty
        }
        
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    // Swap elements
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
     * @param label label to display before the array
     */
    public static void printArray(int[] array, String label) {
        System.out.print(label + ": ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    /**
     * Main method to test the enhanced bubble sort implementation
     */
    public static void main(String[] args) {
        // Test case 1: Normal array
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("=== Test Case 1: Normal Array ===");
        printArray(array1, "Original array");
        bubbleSortAscending(array1);
        printArray(array1, "Sorted ascending");
        
        // Test case 2: Reverse sorted array
        int[] array2 = {90, 64, 34, 25, 22, 12, 11};
        System.out.println("\n=== Test Case 2: Reverse Sorted Array ===");
        printArray(array2, "Original array");
        bubbleSortAscending(array2);
        printArray(array2, "Sorted ascending");
        
        // Test case 3: Already sorted array
        int[] array3 = {11, 12, 22, 25, 34, 64, 90};
        System.out.println("\n=== Test Case 3: Already Sorted Array ===");
        printArray(array3, "Original array");
        bubbleSortAscending(array3);
        printArray(array3, "Sorted ascending");
        
        // Test case 4: Array with duplicates
        int[] array4 = {25, 12, 25, 12, 22, 11, 90};
        System.out.println("\n=== Test Case 4: Array with Duplicates ===");
        printArray(array4, "Original array");
        bubbleSortAscending(array4);
        printArray(array4, "Sorted ascending");
        
        // Test case 5: Descending sort
        int[] array5 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\n=== Test Case 5: Descending Sort ===");
        printArray(array5, "Original array");
        bubbleSortDescending(array5);
        printArray(array5, "Sorted descending");
        
        // Test case 6: Single element array
        int[] array6 = {42};
        System.out.println("\n=== Test Case 6: Single Element Array ===");
        printArray(array6, "Original array");
        bubbleSortAscending(array6);
        printArray(array6, "Sorted array");
        
        // Test case 7: Empty array
        int[] array7 = {};
        System.out.println("\n=== Test Case 7: Empty Array ===");
        System.out.println("Empty array: []");
        bubbleSortAscending(array7);
        System.out.println("Sorted array: []");
    }
}