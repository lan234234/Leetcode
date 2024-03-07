package arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithUniqueCharcters_253 {
    public int longestSubstringWithUniqueCharacters(String input) {
        // assume input is not null
        // corner case:
        if (input.length() <= 1) {
            return input.length();
        }
        //general case:
        int i = 0;	// the begin of the substring
        int j = 0;	// j - 1 is the end of the substring
        // set: store unique characters between i and j - 1
        Set<Character> set = new HashSet<>();
        int maxLength = 0;	// store result
        while (j < input.length()) {
            if (set.contains(input.charAt(j))) {
                // remove the characters between input.charAt(i) to input.charAt(j)
                while (input.charAt(i) != input.charAt(j)) {
                    set.remove(input.charAt(i++));
                }
                // move i to the next character of the first input.charAt(j)
                i++;
            } else {
                set.add(input.charAt(j));
            }
            j++;
            int curLength = j - i;
            // update maxLength if necessary
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }
    // TC: O(n)
    // SC: O(n)

}
