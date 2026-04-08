class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        int i = 0;
        int j = 0;
        while (j < s.length) {
            // find start of a word
            if (s[j] == ' ') j++;
            i = j;
            // find end
            while (j < s.length && s[j] != ' ') {
                j++;
            }
            reverse(s, i, j - 1);
        }
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}