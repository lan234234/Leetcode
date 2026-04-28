class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right && nums[left] == nums[left + 1]) {
            left++;
        }
        while (left < right && nums[right] == nums[right - 1]) {
            right--;
        }
        if (nums[left] == target)   return true;
        if (nums[left] == nums[right])  left++;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)    return true;
            if (nums[mid] > nums[right] == target > nums[right]) {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target > nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}