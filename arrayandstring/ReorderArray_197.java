package arrayandstring;

/**
 * Given an array of elements, reorder it as follow:
 *
 * { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }
 *
 * { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }
 *
 * Try to do it in place.
 */
public class ReorderArray_197 {
    public int[] reorder(int[] array) {
        // corner case:
        if (array == null || array.length <= 3) {
            return array;
        }
        // general case:
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            reorder(array, 0, array.length - 2);
        }
        return array;
    }
    // reorder the part [left, right]
    private void reorder(int[] array, int left, int right) {
        // base case:
        if (right - left <= 1) {
            return;
        }
        // recursive rule:
        int mid = left + (right - left) / 2;
        int leftMid = left + (mid - left) / 2;
        int rightMid = right - (mid - leftMid);
        reverse(array, leftMid + 1, rightMid);
        int newMid = leftMid + (rightMid - mid);
        reverse(array, leftMid + 1, newMid);
        reverse(array, newMid + 1, rightMid);
        reorder(array, left, newMid);
        reorder(array, newMid + 1, right);
    }
    private void reverse(int[] array, int start, int end) {
        while (end > start) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    // TC: O(nlogn)
    // SC: O(logn)

}
