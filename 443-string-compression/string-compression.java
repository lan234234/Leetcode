class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] != chars[start]) {
                int count = end - start;
                chars[i++] = chars[start];
                if (count != 1) {
                    String countS = Integer.toString(count);
                    for (int j = 0; j < countS.length(); j++) {
                        chars[i++] = countS.charAt(j);
                    }
                }
                start = end;
            }
        }
        return i;
    }
}