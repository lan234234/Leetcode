class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int bit = 0;
        for (int i = 1; i <= n; i++) {
            bit ^= i;
        }

        for (int num : nums) {
            bit ^= num;
        }
        return bit;
    }
}