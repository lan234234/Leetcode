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
    /*
    / method 1:
     */
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


/*
time complexity: O(logn + k)
    step1: O(logn)
    step2: O(k)
space complexity: O(1)
 */

    /*
    / method 2:
     */
    public int[] kthClosestElement(int[] array, int target, int k) {
        //corner case:
        if (array == null || array.length == 0) {
            return new int[0];
        }
        if (k <= 0 || k > array.length) {
            return new int[0];
        }
        //step1: binary search to find the closest number index
        int index = findClosest(array, target);
        if (k == 1)		return new int[]{array[index]};
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = helper(array, index + 1, index, target, i + 1);
        }
        return result;
    }

    private int findClosest(int[] array, int target) {
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
        return Math.abs(array[left] - target) <= Math.abs(array[right] - target) ? left : right;
    }

    private int helper(int[] array, int i, int j, int target, int k) {
        //corner case:
        if (i <= 0) {
            return array[j + k];
        }
        if (j >= array.length - 1) {
            return array[i - k];
        }
        if (k == 1) {
            return Math.abs(array[i - 1] - target) <= Math.abs(array[j + 1] - target) ?
                    array[i - 1] : array[j + 1];
        }
        i -= k / 2;
        j += k / 2;
        if (i < 0) {
            return helper(array, i + k / 2, j, target, k - k / 2);
        }
        if (j > array.length - 1) {
            return helper(array, i, j - k / 2, target, k - k / 2);
        }
        if (Math.abs(array[i] - target) <= Math.abs(array[j] - target)) {
            return helper(array, i, j - k / 2, target, k - k / 2);
        }
        return helper(array, i + k / 2, j, target, k - k / 2);
    }

    /*
    time complexity: O(logn + klogk)
        step1: O(logn)
        step2: O(klogk)
    space complexity: O(klogk)
     */
}