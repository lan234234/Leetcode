class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int rob = 0;
        int notRob = 0;
        for (int i = 0; i < n; i++) {
            int curRob = notRob + nums[i];
            notRob = Math.max(rob, notRob);
            rob = curRob;
        }
        return Math.max(rob, notRob);
    }
}