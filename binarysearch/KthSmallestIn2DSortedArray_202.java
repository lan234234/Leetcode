package binarysearch;

/*

Given two sorted arrays of integers, find the Kth smallest number.


assume
a, b: int[], sorted in ascending order
	not null
	a.length + b.length > 0
k: int
    > 0
    <= a.length + b.length

 */

public class KthSmallestIn2DSortedArray_202 {
    public int kthSmallestIn2SortedArray(int[] a, int[] b, int k) {
        return helper(a, -1, b, -1, k);
    }

    private int helper(int[] a, int i, int[] b, int j, int k) {
        //corner case:
        if (i == a.length - 1) {
            return b[j + k];
        }
        if (i == b.length - 1) {
            return a[i + k];
        }
        if (k == 1) {
            return Math.min(a[i + 1], b[j + 1]);
        }
        //general case:
        i += k / 2;
        j += k / 2;
        if (i >= a.length || (j < b.length && a[i] > b[j])) {
            return helper(a, i - k / 2, b, j, k - k / 2);
        }
        return helper(a, i, b, j - k / 2, k - k / 2);
    }

}

/*
time complexity: O(log(k))
space complexity: O(log(k))
 */
