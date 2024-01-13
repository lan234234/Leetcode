package binarysearch;

/*
Given an array of positive integers sorted in a strictly increasing order, and an integer k.
Return the kth positive integer that is missing from this array.

clarify:

assume:
arr != null
start from 1
k > 0

solution: binary search to find the number before the kth missing number

 */

public class KthMissingPositive_l1539 {
    public int KthMissingPositiveNumber(int[] arr, int k) {
        //case1: missing number is before the first element
        if (arr.length == 0 || k < arr[0]) {
            return k;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - mid - 1;
            if (missing >= k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        //case2: missing number is after right
        int rightMissing = arr[right] - right - 1;
        if (rightMissing < k) {
            return arr[right] - rightMissing + k;
        }
        //case3: missing number is between left and right
        int leftMissing = arr[left] - left - 1;
        return arr[left] - leftMissing + k;

    }

}
