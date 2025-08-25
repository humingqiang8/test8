package main

import (
	"fmt"
	"strconv"
	"strings"
)

// stringToNumbers takes a string of space-separated numbers and converts it into a slice of integers.
// It returns the slice of integers and an error if any conversion fails.
func stringToNumbers(input string) ([]int, error) {
	// Trim whitespace and split the string by spaces
	parts := strings.Fields(strings.TrimSpace(input))
	
	// If the input is empty or only whitespace, return an empty slice
	if len(parts) == 0 {
		return []int{}, nil
	}

	// Create a slice to hold the converted integers
	numbers := make([]int, 0, len(parts))

	// Iterate over each part and convert it to an integer
	for _, part := range parts {
		num, err := strconv.Atoi(part)
		if err != nil {
			// Return an error if conversion fails for any part
			return nil, fmt.Errorf("invalid number '%s' in input", part)
		}
		numbers = append(numbers, num)
	}

	return numbers, nil
}