package binarysearch;

/*
Given a target T and an array A,
find the index of the smallest element in A that is larger than T.



assume:
array: int[], ordered in ascending order
target: int
if target not exist	return -1;
 */

public class SmallestLarger_636 {
    public int SmallestLarger(int[] array, int target) {
        //corner case:
        if (array == null || array.length == 0) {
            return -1;
        }
        //general case:
        int left = 0;
        int right = array.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

}
