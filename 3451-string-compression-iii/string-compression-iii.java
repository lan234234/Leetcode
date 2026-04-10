class Solution {
    public String compressedString(String word) {
        int MAX = 9;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < word.length()) {
            char c = word.charAt(start);
            int end = start + 1;
            while (end < word.length() && word.charAt(end) == c && end - start < MAX) {
                end++;
            }
            sb.append(end - start);
            sb.append(c);
            start = end;
        }
        return sb.toString();
    }
}