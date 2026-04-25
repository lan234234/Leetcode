class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int replace = findFirstLargerOrEqual(list, nums[i]);
                list.set(replace, nums[i]);
            }
        }
        return list.size();
    }

    private int findFirstLargerOrEqual(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}