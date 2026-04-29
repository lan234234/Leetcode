class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(max(nums, 0, n - 2), max(nums, 1, n - 1));
    }

    private int max(int[] nums, int left, int right) {
        int pre1 = nums[left];
        int pre2 = 0;
        for (int i = left + 1; i <= right; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}