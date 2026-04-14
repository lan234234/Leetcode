class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // it make sure max_val_diff in each bucket within valueDiff
        int bucketSize = valueDiff + 1;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // make sure remappedNum is a positive integer
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / bucketSize;
            if (map.containsKey(bucket) || 
            (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= valueDiff) ||
            (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= valueDiff))   return true;
            if (map.size() == indexDiff) {
                map.remove(((long) nums[i - indexDiff] - Integer.MIN_VALUE) / bucketSize);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}