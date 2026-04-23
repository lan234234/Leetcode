class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int max = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}