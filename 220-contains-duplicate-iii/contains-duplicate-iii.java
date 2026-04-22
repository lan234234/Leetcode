class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        int delta = 1000000000;
        // key: bucket index
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < n; right++) {
            int bucketIndex = (nums[right] + delta) / (valueDiff + 1);
            if (map.containsKey(bucketIndex) || 
                (map.containsKey(bucketIndex + 1) && map.get(bucketIndex + 1) - nums[right] <= valueDiff) ||
                (map.containsKey(bucketIndex - 1) && nums[right] - map.get(bucketIndex - 1) <= valueDiff))
                return true;
            map.put(bucketIndex, nums[right]);
            if (map.size() > indexDiff) {
                map.remove((nums[left++] + delta) / (valueDiff + 1));
            }
        }
        return false;
    }
}