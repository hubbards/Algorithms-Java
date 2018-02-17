// This program contains an implementation of the binary search algorithm.

// NOTE: worst-case running time of binary search algorithm is O (log n)

import java.util.*; // for Random

public class BinarySearch {

    public static void main(String[] args) {
        // TODO: test binary search algorithm
    }

    // iterative binary search algorithm
    // pre : numbers are sorted
    // post: returns an index at which the target appears in the given input
    // array, or -1 if not found
    public static int binarySearchI(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2;
            if (numbers[mid] == target) {
                // target found
                return mid;
            } else if (numbers[mid] < target) {
                // search second half
                min = mid + 1;
            } else {
                // search first half
                max = mid - 1;
            }
        }
        // target not found
        return -1;
    }

    // recursive binary search algorithm
    // pre : numbers are sorted
    // post: returns an index at which the target appears in the given input
    // array, or -1 if not found
    public static int binarySearchR(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        return binarySearchR(numbers, target, min, max);
    }

    // helper method
    private static int binarySearchR(int[] numbers, int target, int min, int max) {
        if (min > max) {
            // base case
            // target not found
            return -1;
        } else {
            // recursive case
            int mid = (max - min) / 2;
            if (numbers[mid] == target) {
                // target found
                return mid;
            } else if (numbers[mid] < target) {
                // search second half
                min = mid + 1;
                return binarySearchR(numbers, target, min, max);
            } else {
                // search first half
                max = mid - 1;
                return binarySearchR(numbers, target, min, max);
            }
        }
    }
}