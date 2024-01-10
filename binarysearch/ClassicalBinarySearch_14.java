package binarysearch;

/*
classical binary search

Given a target T and an array A, find the index i such that A[i] == T


clarify:
assume: A is an int[] and T is an integer
	A is sorted in ascending order
	no duplication / if have duplication, return any one of the them

 */

public class ClassicalBinarySearch_14 {
    public int classicBinarySearch(int[] array, int target) {
        //corner case:
        if (array == null || array.length == 0) {
            return -1;
        }
        //general case:
        int left = 0;
        int right = array.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;	//not (left + right) / 2, might overflow
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
