package binarysearch;

public class ClosestKElement_19 {
    public int[] closestKElement(int[] array, int target, int k) {
        //corner case:
        if (array == null || array.length == 0 ||	k > array.length || k <=0) {
            return new int[0];
        }
        //general case:
        int index = closestElement(array, target);
        int[] result = new int[k];
        result[0] = array[index];
        int m = 1;
        int i = index - 1;
        int j = index + 1;
        while (m < k && i >= 0 && j < array.length) {
            if (Math.abs(array[i] - target) <= Math.abs(array[j] - target)) {
                result[m] = array[i];
                i--;
                m++;
            } else {
                result[m] = array[j];
                j++;
                m++;
            }
        }
        if (i < 0) {
            while (m < k) {
                result[m] = array[j];
                j++;
                m++;
            }
        }
        if (j == array.length) {
            while (m < k) {
                result[m] = array[i];
                i--;
                m++;
            }
        }
        return result;
    }

    private int closestElement(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }
        if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) {
            return left;
        }
        return right;
    }


}
