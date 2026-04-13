class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = right + 1;
            } else {
                max = Math.max(right - left + 1, max);
            }
        }
        return max;
    }
}