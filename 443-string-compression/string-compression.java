class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n < 2)  return n;

        int start = 0;
        int i = 0;
        for (int j = 0; j <= n; j++) {
            if (j == n || chars[j] != chars[start]) {
                chars[i++] = chars[start];
                int count = j - start;
                if (count > 1) {
                    String sCount = Integer.toString(count);
                    for (int k = 0; k < sCount.length(); k++) {
                        chars[i++] = sCount.charAt(k);
                    }
                }
                start = j;
            }
        }
        return i;
    }
}