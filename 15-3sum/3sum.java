class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)    return res;
        
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])   continue;
            int target = -nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[j] + nums[k];
                if (sum == target) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}