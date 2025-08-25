# Bubble Sort Implementation in Java

This project contains Java implementations of the bubble sort algorithm.

## How Bubble Sort Works

Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The pass through the list is repeated until the list is sorted.

The algorithm gets its name because smaller elements "bubble" to the top of the list.

## Time Complexity

- Best Case: O(n) - when the array is already sorted
- Average Case: O(n²)
- Worst Case: O(n²) - when the array is reverse sorted

## Space Complexity

- O(1) - it sorts the array in place

## Files

- `BubbleSort.java`: Contains a basic implementation of the bubble sort algorithm
- `EnhancedBubbleSort.java`: Contains an enhanced implementation with additional features:
  - Sorting in both ascending and descending order
  - Handling of edge cases (empty arrays, single element arrays, already sorted arrays)
  - Multiple test cases to verify correctness

## How to Run

1. Compile the Java files:
   ```
   javac BubbleSort.java
   javac EnhancedBubbleSort.java
   ```

2. Run the compiled programs:
   ```
   java BubbleSort
   java EnhancedBubbleSort
   ```

## Example Output

### Basic Bubble Sort
```
Original array:
64 34 25 12 22 11 90
Sorted array:
11 12 22 25 34 64 90
```

### Enhanced Bubble Sort
```
=== Test Case 1: Normal Array ===
Original array: 64 34 25 12 22 11 90
Sorted ascending: 11 12 22 25 34 64 90

=== Test Case 2: Reverse Sorted Array ===
Original array: 90 64 34 25 22 12 11
Sorted ascending: 11 12 22 25 34 64 90

=== Test Case 3: Already Sorted Array ===
Original array: 11 12 22 25 34 64 90
Sorted ascending: 11 12 22 25 34 64 90

=== Test Case 4: Array with Duplicates ===
Original array: 25 12 25 12 22 11 90
Sorted ascending: 11 12 12 22 25 25 90

=== Test Case 5: Descending Sort ===
Original array: 64 34 25 12 22 11 90
Sorted descending: 90 64 34 25 22 12 11

=== Test Case 6: Single Element Array ===
Original array: 42
Sorted array: 42

=== Test Case 7: Empty Array ===
Empty array: []
Sorted array: []
```