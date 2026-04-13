class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)   zeroCount++;
            while (zeroCount > 1) {
                if (nums[left++] == 0)    zeroCount--;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}