class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < n; i++) {
            int j = i + 1;
            if (nums[i] + nums[j] + nums[j + 1] > target)   break;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}