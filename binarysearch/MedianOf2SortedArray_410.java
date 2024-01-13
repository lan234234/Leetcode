package binarysearch;

/*
Given two sorted arrays of integers in ascending order, find the median value.


assume:
a, b: int[], sorted in ascending order
	not null
	a.length + b.length > 0
k: int
    > 0
    <= a.length + b.length
return: total number is even? --> average

 */

public class MedianOf2SortedArray_410 {
    public double medianOf2SortedArray(int[] a, int[] b) {
        int size = a.length + b.length;
        int num1 = helper(a, -1, b, -1, (size + 1) / 2);
        int num2 = helper(a, -1, b, -1, (size + 2) / 2);
        return (num1 + num2) / 2.0;
    }

    private int helper(int[] a, int i, int[] b, int j, int k) {
        //corner case:
        if (i >= a.length - 1) {
            return b[j + k];
        }
        if (j >= b.length - 1) {
            return a[i + k];
        }
        if (k == 1) {
            return Math.min(a[i + 1], b[j + 1]);
        }
        //general case:
        i += k / 2;
        j += k / 2;
        if (i >= a.length) {
            return helper(a, i - k / 2, b, j, k - k / 2);
        }
        if (j >= b.length) {
            return helper(a, i, b, j - k / 2, k - k / 2);
        }
        if (a[i] <= b[j]) {
            return helper(a, i, b, j - k / 2, k - k / 2);
        }
        return helper(a, i - k / 2, b, j, k - k / 2);
    }
}

/*
time complexity: O(log(m + n))
space complexity: O(log(m + n))
 */
