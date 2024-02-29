package arrayandstring;

/*
Given an array, reverse all its elements.
 */

public class ReverseArray_542 {
    public void reverse(int[] array) {
    /*
    assumption: int[]
    input: int[]
    output: void
    corner case:
    array == null || array.length <= 0
    */
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
