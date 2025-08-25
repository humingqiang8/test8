#!/bin/bash

# Build script for Bubble Sort implementations

echo "Compiling BubbleSort.java..."
javac BubbleSort.java
if [ $? -eq 0 ]; then
    echo "BubbleSort.java compiled successfully."
else
    echo "Failed to compile BubbleSort.java"
    exit 1
fi

echo "Compiling EnhancedBubbleSort.java..."
javac EnhancedBubbleSort.java
if [ $? -eq 0 ]; then
    echo "EnhancedBubbleSort.java compiled successfully."
else
    echo "Failed to compile EnhancedBubbleSort.java"
    exit 1
fi

echo ""
echo "Running basic Bubble Sort implementation:"
echo "========================================"
java BubbleSort

echo ""
echo "Running enhanced Bubble Sort implementation:"
echo "==========================================="
java EnhancedBubbleSort