class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j + 1 < n; j++) {
                int sum = nums[i] + nums[j];
                if (nums[j + 1] > target - sum) break;
                int k = findLargestSmaller(nums, j + 1, target - sum);
                count += k == -1 ? 0 : (k - j);
            }
        }
        return count;
    }

    private int findLargestSmaller(int[] nums, int left, int target) {
        int res = -1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/ 2;
            if (nums[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}