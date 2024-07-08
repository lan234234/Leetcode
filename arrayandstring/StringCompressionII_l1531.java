package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class StringCompressionII_l1531 {
    public int getLengthOfOptimalCompression(String s, int k) {
        // assume k >= 0
        // assume s is not null
        // corner case:
        if (s.length() <= k)	return 0;
        // general case:
        Map<Quartet, Integer> map = new HashMap();
        return helper(s, k, 0, ' ', 0, map);
    }
    // firstly, process the substring in [index, end], delete certain number of characters,
    // then, calculate the increase of length to append the compress substring to the substring in [0, index - 1]
    private int helper(String s, int delete, int index, char preC, int preCount, Map<Quartet, Integer> map) {
        // base case:
        if (s.length() == index)	return 0;
        Integer result = map.get(new Quartet(delete, index, preC, preCount));
        if (result != null)	return result;
        // case 1: current character is the same as the previous character
        // it means in one of the previous operation, we choose to not delete this character, so we cannot delete it anymore
        if (preC == s.charAt(index)) {
            int increase = 0;
            if (preCount == 1 || preCount == 9 || preCount == 99) {
                increase = 1;
            }
            result = helper(s, delete, index + 1, preC, preCount + 1, map) +  increase;
            map.put(new Quartet(delete, index, preC, preCount), result);
            return result;
        } else {
        // case 2: not the same
            // case 2.1 choose not to delete
            result = 1 + helper(s, delete, index + 1, s.charAt(index), 1, map);
            // case 2.2 choose to delete
            if (delete > 0) {
                result = Math.min(result, helper(s, delete - 1, index + 1, preC, preCount, map));
            }
            map.put(new Quartet(delete, index, preC, preCount), result);
            return result;
        }
    }

    class Quartet {
        int index;
        int delete;
        char preC;
        int preCount;
        // constructor
        Quartet(int index, int delete, char preC, int preCount) {
            this.index = index;
            this.delete = delete;
            this.preC = preC;
            this.preCount = preCount;
        }
        @Override
        public boolean equals(Object obj) {
            // Step 1: Check if the objects are the same instance
            if (this == obj) {
                return true;
            }

            // Step 2: Check if the argument is an instance of Person
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            // Step 3: Cast the argument to Person
            Quartet other = (Quartet) obj;

            return this.index == other.index && this.delete == other.delete && this.preC == other.preC && this.preCount == other.preCount;
        }
    }
}
