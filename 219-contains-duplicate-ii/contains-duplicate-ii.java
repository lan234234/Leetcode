class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (map.containsKey(nums[right]))  return true;
            map.put(nums[right], 1);
            if (right - left == k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0)   map.remove(nums[left]);
                left++;
            }
        }
        return false;
    }
}