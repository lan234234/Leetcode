package arrayandstring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingSubarraysWithKDuplicatePairs {
    public int solution(List<Integer> list, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pair = 0;
        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            int count = map.getOrDefault(list.get(j), 0);
            if (count % 2 == 1) {
                pair++;
            }
            map.put(list.get(j), count + 1);
            if (pair >= k) {
                count = map.get(list.get(i));
                if (count % 2 == 0) {
                    pair--;
                }
                if (count == 1) {
                    map.remove(list.get(i));
                } else {
                    map.put(list.get(i), count - 1);
                }
                result += list.size() - j;
            }
        }
        return result;
    }

}
