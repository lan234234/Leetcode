class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int end = 0;
        while (end < chars.length) {
            int start = end;
            while (end < chars.length && chars[end] == chars[start]) {
                end++;
            }
            int count = end - start;
            chars[i++] = chars[start];
            if (count == 1) continue;
            String countS = Integer.toString(count);
            for (int j = 0; j < countS.length(); j++) {
                chars[i++] = countS.charAt(j);
            }
        }
        return i;
    }
}