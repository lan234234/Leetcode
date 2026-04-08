class Solution {
    public String clearDigits(String s) {
        if (s == null || s.length() < 2)    return s;

        char[] arr = s.toCharArray();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (!Character.isDigit(arr[j])) {
                arr[i++] = arr[j++];
            } else {
                j++;
                if (i > 0)  i--;
            }
        }
        return new String(arr, 0, i);
    }
}