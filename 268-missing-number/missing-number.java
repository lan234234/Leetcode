class Solution {
    /**
    0 1 2 3
    4 1 2 3
    
    
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (i != nums[i]) {
                if (nums[i] == n)   break;
                swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i)   return i;
        }
        return n;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}