class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i + 2 < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int curDiff = target - sum;
                if (curDiff == 0)   return target;
                if (Math.abs(curDiff) < Math.abs(diff)) {
                    diff = curDiff;
                }
                if (curDiff > 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return target - diff;
    }
}