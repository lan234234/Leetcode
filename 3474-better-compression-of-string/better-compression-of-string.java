class Solution {
    public String betterCompression(String compressed) {
        int[] count = new int[26];
        int i = 0;
        while (i < compressed.length()) {
            int index = compressed.charAt(i++) - 'a';
            int num = 0;
            while (i < compressed.length() && compressed.charAt(i) <= '9') {
                num = num * 10 + compressed.charAt(i++) - '0';
            }
            count[index] += num;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < count.length; j++) {
            if (count[j] > 0) {
                sb.append((char) (j + 'a'));
                sb.append(count[j]);
            }
        }
        return sb.toString();
    }
}