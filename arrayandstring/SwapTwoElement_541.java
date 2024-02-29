package arrayandstring;

/*
Given an array, and two indices i and j.
Swap the element at position i and element at position j.
*/
public class SwapTwoElement_541 {
    public void swapTwoElement(int[] array, int i, int j) {
        // assume: int array
        // input: int[]
        // output: int[]
        /* corner case
        array == null || array.length == 0
        i or j is/are invalid
        */
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
