class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;

        // 1. remove leading
        while (j < s.length() && s.charAt(j) == ' ') {
            j++;
        }

        // 2. remove dup
        while (j < s.length()) {
            if (i == 0 || arr[i - 1] != ' ' || arr[j] != ' ') {
                arr[i] = arr[j];
                i++;
            }
            j++;
        }

        // 3. remove trailing
        if (i > 0 && arr[i - 1] == ' ') {
            i--;
        }

        // reverse
        reverse(arr, 0, i);
        int start = 0;
        while (start < i) {
            int end = start;
            while (end < i && arr[end] != ' ') {
                end++;
            }
            reverse(arr, start, end);
            start = end + 1;
        }
        return new String(arr, 0, i);
    }

    private void reverse(char[] arr, int i, int j) {
        j--;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}