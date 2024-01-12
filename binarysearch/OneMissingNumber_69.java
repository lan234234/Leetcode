package binarysearch;

/*
Given an array of size N - 1,
containing a series of consecutive numbers except one number,
find the missing number.


assume:
array: int[]
only missing one number
from 1 to array.length - 1
array == null || array.length == 0	return 1;

 */

public class OneMissingNumber_69 {
    public int oneMissingNumber(int[] array) {
        //corner case:
        if (array == null || array.length == 0) {
            return 1;
        }
//general case:
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] - mid > 1) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[right] - array[left] == 2) {
            return array[right] - 1;
        }
        return array[0] == 1 ? array[array.length - 1] + 1 : 1;
    }

}
