class Solution {
    public String removeOccurrences(String s, String part) {
        if (s.length() < part.length()) return s;

        int[] lps = new int[part.length()];
        int i = 0;
        for (int j = 1; j < part.length(); j++) {
            if (part.charAt(j) == part.charAt(i)) {
                lps[j] = ++i;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }

        StringBuilder sb = new StringBuilder(s);
        int index;
        while ((index = findFirst(sb, part, lps)) != -1) {
            StringBuilder next = new StringBuilder();
            next.append(sb.substring(0, index));
            next.append(sb.substring(index + part.length(), sb.length()));
            sb = next;
        }
        return sb.toString();
    }

    private int findFirst(StringBuilder sb, String part, int[] lps) {
        int i = 0;
        for (int j = 0; j < sb.length(); j++) {
            if (sb.charAt(j) == part.charAt(i)) {
                i++;
                if (i == part.length()) return j - i + 1;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }
        return -1;
    }
}