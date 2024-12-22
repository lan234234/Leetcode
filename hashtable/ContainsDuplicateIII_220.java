package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int bucketSize = valueDiff + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int bucket = Math.floorDiv(nums[i], bucketSize);
            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket + 1) && map.get(bucket + 1) - nums[i] <= valueDiff) ||
                    (map.containsKey(bucket - 1) && nums[i] - map.get(bucket - 1) <= valueDiff))   return true;
            if (map.size() == indexDiff) {
                map.remove(Math.floorDiv(nums[i - indexDiff], bucketSize));
            }
            map.put(bucket, nums[i]);
        }
        return false;
    }
}
