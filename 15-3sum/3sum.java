class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)    return res;
        
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > 0)    break;
            if (i != 0 && nums[i] == nums[i - 1])   continue;   
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}