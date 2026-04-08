class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();

        // 1. reverse whole
        reverse(arr, 0, arr.length - 1);
        
        // 2. reverse each word
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            // find start
            while (j < arr.length && arr[j] == ' ') {
                j++;
            }
            if (j == arr.length)    break;
            i = j;

            // find end
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            reverse(arr, i, j - 1);
        }

        // 3. remove leading/trailing/dup spaces
        i = 0;
        j = 0;
        while (j < arr.length) {
            if (arr[j] != ' ' || (j != 0 && arr[j - 1] != ' ')) {
                arr[i++] = arr[j];
            }
            j++;
        }
        if (arr[i - 1] == ' ')  i--;
        return new String(arr, 0, i);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}