class Solution {
    // 0 1 2 3 4 5 6 7
    // l e d e c o e t
    // 0 2 6 7 4 1 1 3



    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            while (indices[i] != i) {
                swap(arr, i, indices[i]);
                swap(indices, i, indices[i]);
            }
        }
        return new String(arr);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}