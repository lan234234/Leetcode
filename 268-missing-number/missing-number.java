class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] exist = new boolean[n + 1];
        for (int num : nums) {
            exist[num] = true;
        }
        for (int i = 0; i <= n; i++) {
            if (!exist[i])    return i;
        }
        return -1;
    }
}