class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroIndex = -1;
        int zeroCount = 0;

        long prod = 1L;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount > 1) {
                    break;
                } else {
                    zeroIndex = i;
                }    
            } else {
                prod *= nums[i];
            }
        }

        if (zeroCount > 0)   Arrays.fill(nums, 0);

        if (zeroCount == 1) {
            nums[zeroIndex] = (int) prod;
            return nums;
        } else if (zeroCount == 0) {
            for (int i = 0; i < n; i++) {
                nums[i] = (int) (prod / nums[i]);
            }
        }
        return nums;
    }
}