class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = first.get(nums[i]);
            if (index != null && i - index <= k)    return true;
            first.put(nums[i], i);
        }
        return false;
    }
}