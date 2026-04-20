class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i + 3 < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1])   continue;
            for (int j = i + 1; j + 2 < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])   continue;
                int k = j + 1;
                long sum = (long) nums[i] + nums[j];
                if (sum + nums[k] + nums[k + 1] > target) break;

                int l = n - 1;
                while (k < l) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) {
                        k++;
                        continue;
                    }
                    long curSum = sum + nums[k] + nums[l];
                    if (curSum == target) {
                        res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    } else if (curSum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}