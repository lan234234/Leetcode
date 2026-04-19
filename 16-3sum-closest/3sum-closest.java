class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])   continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (target == sum)  return target;
                res = Math.abs(sum - target) < Math.abs(target - res) ? sum : res;
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}