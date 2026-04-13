class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int zeroIndex = -1;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)   zeroCount++;
            if (zeroCount > 1) {
                left = zeroIndex + 1;
                zeroCount--;
            }
            if (nums[right] == 0)   zeroIndex = right;
            max = Math.max(max, right - left);
        }
        return max;
    }
}