class Solution {
    public int[] shuffle(int[] array, int n) {
        n = array.length;
        int[] res = new int[n];
        int i = 0;  // array

        // first half
        for (int j = 0; j < n; j += 2) {
        res[j] = array[i++];
        }

        // second half
        for (int j = 1; j < n; j += 2) {
        res[j] = array[i++];
        }

        return res;
    }
}