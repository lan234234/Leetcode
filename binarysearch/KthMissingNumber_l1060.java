package binarysearch;

public class KthMissingNumber_l1060 {
    public int kthMissingNumber(int[] arr, int k) {
        //step1: binary search to find the last element having missing number of k - 1
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int midMissing = arr[mid] - mid - arr[0];
            if (midMissing < k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        //step2: calculate the missing number
        //case1: the missing number is after the right
        int rightMissing = arr[right] - right - arr[0];
        if (rightMissing < k) {
            return arr[right] - rightMissing + k;
        }
        //case2: the missing number is before the left--impossible in this problem
        //case3: the missing number is between the right and left
        int leftMissing = arr[left] - right - arr[0];
        return arr[left] - leftMissing + k;
    }

}
