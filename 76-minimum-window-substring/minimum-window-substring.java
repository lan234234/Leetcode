class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())    return "";
        int start = -1;
        int end = -1;
        Map<Character, Integer> freq = new HashMap<>();
        int match = 0;

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer count = freq.get(c);
            if (count == null)  continue;
            freq.put(c, --count);
            if (count == 0)   match++;
            while (match == freq.size()) {
                if (start == -1 || (end - start > right - left)) {
                    start = left;
                    end = right;
                }
                char cur = s.charAt(left++);
                Integer leftCount = freq.get(cur);
                if (leftCount == null)  continue;
                freq.put(cur, ++leftCount);
                if (leftCount == 1)   match--;
            }
        }
        return start == -1 ? "" : s.substring(start, end + 1);
    }
}