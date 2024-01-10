package binarysearch;

/*
Given a target T and an array A,
find the index of the last occurrence of T in A.


assume:
array: int[], sorted, ascending order
target: int
if not exist	return -1;
 */

public class LastOccurrence_16 {
    public int lastOccurrence(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }
        return result;
    }

}

/*
    time complexity: O(logn)
    space complexity: O(1)
 */
