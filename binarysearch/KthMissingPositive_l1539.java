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
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid < 1 + k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        //case 1: missing number is between left and right
        if (arr[left] - left < 1 + k && arr[right] - right >= 1 + k) {
            int preMissing = arr[left] - left - 1;
            return k - preMissing + arr[left];
        }
        //case 2: missing number is after the right element
        if (arr[right] - right < 1 + k) {
            int preMissing = arr[right] - right - 1;
            return k - preMissing + arr[right];
        }
        //case 3: missing number is before the left element
        // in this case the missing number must be before arr[0]
        return k;
    }

}
