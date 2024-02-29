package arrayandstring;

public class IsSubstring_85 {
    public int isSubstring(String large, String small) {
        // assume both large and small are not null
        // corner case:
        if (small.length() == 0) {
            return 0;
        }
        if (large.length() < small.length()) {
            return -1;
        }
        // general case:
        for (int i = 0; i < large.length() - small.length() + 1; i++) {
            int result = helper(large, small, i);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
    private int helper(String large, String small, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (large.charAt(start + i) != small.charAt(i)) {
                return -1;
            }
        }
        return start;
    }
    // TC: O((m - n) * n)
    // SC: O(1)

}
