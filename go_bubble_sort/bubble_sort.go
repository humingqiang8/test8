package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strings"
	"time"
)

// generateRandomSlice creates a slice of random integers with a given size and value range.
func generateRandomSlice(size, min, max int) []int {
	rand.Seed(time.Now().UnixNano())
	slice := make([]int, size)
	for i := 0; i < size; i++ {
		slice[i] = rand.Intn(max-min+1) + min
	}
	return slice
}

// bubbleSort sorts a slice of integers in ascending order using the bubble sort algorithm.
// It also counts and returns the number of swaps performed during the sort.
// Additionally, it tracks the number of comparisons made.
func bubbleSort(slice []int) (int, int) {
	n := len(slice)
	swapCount := 0
	comparisonCount := 0
	for i := 0; i < n-1; i++ {
		swapped := false
		for j := 0; j < n-i-1; j++ {
			comparisonCount++
			if slice[j] > slice[j+1] {
				slice[j], slice[j+1] = slice[j+1], slice[j]
				swapCount++
				swapped = true
			}
		}
		// If no two elements were swapped by inner loop, then break
		if !swapped {
			break
		}
	}
	return swapCount, comparisonCount
}

// printSlice prints the elements of a slice.
func printSlice(slice []int, title string) {
	fmt.Printf("%s: %v\n", title, slice)
}

func main() {
	fmt.Println("Choose input method:")
	fmt.Println("1. Generate random numbers")
	fmt.Println("2. Enter numbers manually")
	fmt.Print("Enter choice (1 or 2): ")

	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')
	choice := strings.TrimSpace(input)

	var data []int
	var err error

	switch choice {
	case "1":
		const size = 20
		const minVal = 1
		const maxVal = 100
		data = generateRandomSlice(size, minVal, maxVal)
		printSlice(data, "Generated Random Slice")
	case "2":
		fmt.Print("Enter numbers separated by spaces: ")
		input, _ = reader.ReadString('\n')
		data, err = stringToNumbers(input)
		if err != nil {
			fmt.Printf("Error converting input to numbers: %v\n", err)
			return
		}
		printSlice(data, "Input Slice")
	default:
		fmt.Println("Invalid choice. Exiting.")
		return
	}

	// Sort the slice
	swaps, comparisons := bubbleSort(data)
	printSlice(data, "Sorted Slice")

	fmt.Printf("Number of swaps performed: %d\n", swaps)
	fmt.Printf("Number of comparisons made: %d\n", comparisons)
}