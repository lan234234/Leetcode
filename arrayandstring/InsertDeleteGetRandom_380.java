package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class InsertDeleteGetRandom_380 {
    int[] nums;
    int size;
    Map<Integer, Integer> map;

    public InsertDeleteGetRandom_380() {
        nums = new int[200000];
        size = 0;
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))  return false;
        map.put(val, size);
        nums[size++] = val;
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.remove(val);
        if (index == null)  return false;
        size--;
        // TAKE CARE!!!!
        if (index != size) {
            nums[index] = nums[size];
            map.put(nums[index], index);
        }
        return true;
    }

    public int getRandom() {
        int index = (int) (Math.random() * size);
        return nums[index];
    }
}
