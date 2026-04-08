class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            // find start
            if (arr[j] == ' ') j++;
            i = j;
            // find end
            while (j < arr.length && arr[j] != ' ') j++;
            reverse(arr, i, j - 1);
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}