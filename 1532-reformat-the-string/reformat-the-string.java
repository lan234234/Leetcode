class Solution {
    public String reformat(String s) {
        char[] arr = s.toCharArray();
        int firstDig = -1;
        int firstLet = -1;
        int i;
        for (i = 1; i < arr.length; i++) {
            if (Character.isDigit(arr[i - 1]) == Character.isDigit(arr[i])) {
                if (Character.isDigit(arr[i])) {
                    firstLet = Math.max(firstLet, i + 1);
                    while (firstLet < arr.length && Character.isDigit(arr[firstLet])) {
                        firstLet++;
                    }
                    if (firstLet == arr.length) break;
                    swap(arr, i, firstLet);
                    firstLet++;
                } else {
                    firstDig = Math.max(firstDig, i + 1);
                    while (firstDig < arr.length && Character.isLetter(arr[firstDig])) {
                        firstDig++;
                    }
                    if (firstDig == arr.length) break;
                    swap(arr, i, firstDig);
                    firstDig++;
                }
            }
        }

        if (i == arr.length)    return new String(arr);
        if (i != arr.length - 1 || (Character.isDigit(arr[0]) == Character.isDigit(arr[i])))    return "";
        oneShift(arr);
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void oneShift(char[] arr) {
        char temp = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = temp;
    }
}