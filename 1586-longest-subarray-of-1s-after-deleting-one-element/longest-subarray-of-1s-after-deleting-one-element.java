class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int zeroPos = -1;
        int max = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                if (zeroPos != -1) {
                    left = zeroPos + 1;
                }
                zeroPos = right;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}