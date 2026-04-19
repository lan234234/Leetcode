class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int a = 0; a + 3 < n; a++) {
            if (a != 0 && nums[a] == nums[a - 1])   continue;
            for (int b = a + 1; b + 2 < n; b++) {
                if (b != a + 1 && nums[b] == nums[b - 1])   continue;
                int c = b + 1;
                long minSum = (long) nums[a] + nums[b] + nums[c] + nums[c + 1];
                if (minSum > target) break;
                int d = n - 1;
                while (c < d) {
                    if (c != b + 1 && nums[c] == nums[c - 1]) {
                        c++;
                        continue;
                    }
                    long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        res.add(List.of(nums[a], nums[b], nums[c], nums[d]));
                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }
        return res;
    }
}