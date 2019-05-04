package com.github.hubbards.algorithms.sort;

import java.util.*; // for Arrays

/**
 * This class contains an implementation of the merge sort algorithm.
 *
 * NOTE: the worst-case running time of the merge sort algorithm is
 * O(n * log(n)).
 *
 * @author Spencer Hubbard
 */
public final class MergeSort {
    private MergeSort() {
        throw new AssertionError("static class");
    }

    // recursive merge sort algorithm
    public static void mergeSort(int[] a) {
        if (a.length > 1) {
            // split array into two halves
            int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
            int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);
            // recursively sort two halves
            mergeSort(left);
            mergeSort(right);
            // merge sorted halves into sorted whole
            merge(a, left, right);
        }
    }

    // pre : result is empty; left and right are sorted
    // post:
    private static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0; // index into left array
        int i2 = 0; // index into right array
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && (left[i1] < right[i2]))) {
                // take from left
                result[i] = left[i1];
                i1++;
            } else {
                // take from right
                result[i] = right[i2];
                i2++;
            }
        }
    }
}
