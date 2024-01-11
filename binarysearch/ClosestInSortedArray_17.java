package binarysearch;

/*
Given a target T and an array A,
find the index i in A such that A[i] is closest to T.



assume:
array: int[], sorted in ascending order
target: int
duplicate? return any one
several elements are all closest? return any one
 */

public class ClosestInSortedArray_17 {
    public int closetInSortedArray(int[] array, int target) {
        //corner case:
        if (array == null || array.length == 0) {
            return -1;
        }
//general case:
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] == target) {
                return mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        }
        return right;
    }
}

/*
time complexity: O(logn)
space complexity: O(1)
 */
