class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        kSum(nums, 0, target, 4, new ArrayList<>());
        return res;
    }

    private void kSum(int[] nums, int start, long target, int k, List<Integer> cur) {
        if (nums.length - start < k)    return;
        if (k == 2) {
            twoSum(nums, start, target, cur);
            return;
        }

        for (int i = start; i + k - 1 < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1])   continue;
            cur.add(nums[i]);
            kSum(nums, i + 1, target - nums[i], k - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    private void twoSum(int[] nums, int start, long target, List<Integer> cur) {
        if (nums[start] + nums[start + 1] > target)   return;

        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            if (left != start && nums[left] == nums[left - 1]) {
                left++;
                continue;
            }
            long sum = nums[left] + nums[right];
            if (sum == target) {
                cur.add(nums[left]);
                cur.add(nums[right]);
                res.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                cur.remove(cur.size() - 1);
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}