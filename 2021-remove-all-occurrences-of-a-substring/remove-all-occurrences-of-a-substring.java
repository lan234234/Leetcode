class Solution {
    public String removeOccurrences(String s, String part) {
        char[] arr = s.toCharArray();
        int[] lps = new int[part.length()];

        // 1. construct lps
        int i = 0;
        for (int j = 1; j < part.length(); j++) {
            if (part.charAt(i) == part.charAt(j)) {
                lps[j] = ++i;
            } else if (i != 0) {
                i = lps[i - 1];
                j--;
            }
        }

        int index = -1;
        int len = s.length();
        while ((index = findFirst(arr, lps, part, len)) != -1) {
            remove(arr, index, index + part.length(), len);
            len -= part.length();
        }
        return new String(arr, 0, len);
    }

    private void remove(char[] arr, int i, int j, int n) {
        while (j < n) {
            arr[i++] = arr[j++];
        }
    }

    private int findFirst(char[] arr, int[] lps, String part, int n) {
        if (arr.length < part.length()) return -1;

        int i = 0;
        for(int j = 0; j < n; j++) {
            if (arr[j] == part.charAt(i)) {
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