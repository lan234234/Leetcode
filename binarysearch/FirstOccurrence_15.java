package binarysearch;

/*
Given a target T and an array A,
find the index of the first occurrence of T in A.


assume:
array: int[], sorted, ascending order
target: int
return -1 if there is no such index

 */

public class FirstOccurrence_15 {
    public int firstOccurrence(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0) {
            return -1;
        }
        //general case
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == target) {
            return left;
        }
        if (array[right] == target) {
            return right;
        }
        return -1;
    }

}
