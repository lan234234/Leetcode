package binarysearch;

/*
Given a target T, an K and an array A,
find the K closest numbers to T in A.



assume:
array: int[], ordered in ascending order
target: int
k: int
tie? smaller one is preferred

 */

public class ClosestKElement_19 {
    public int[] closestKElement(int[] array, int target, int k) {
        // corner case:
        // 1. array is invalid
        if (array == null || array.length == 0) {
            return new int[0];
        }
        // 2. k is invalid
        if (k <= 0 || k > array.length) {
            return new int[0];
        }

        //general case:
        //step1: find the closest number by binary search
        int j = closestNumber(array, target);		//traverse array forward
        //step2: traverse and compare to find Kth elements
        int i = j - 1;					//traverse array backward
        int[] result = new int[k];
        int index = 0;					//traverse result
        while (index < k) {
            if (j == array.length ||
                    (i >= 0 && Math.abs(array[i] - target) <= Math.abs(array[j] - target))) {
                result[index++] = array[i--];
            } else {
                result[index++] = array[j++];
            }
        }
        return result;
    }

    private int closestNumber(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                return mid;
            }
        }
        return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ?
                left : right;
    }
}

/*
time complexity: O(logn + k)
    step1: O(logn)
    step2: O(k)
space complexity: O(1)
 */
