package arrayandstring;

/*
Given a two-dimensional array, calculate the sum of all its elements
 */

public class SumOf2DArray_543 {
    public int sum(int[][] array) {
    /*
    assumption: int[]
    input: int[]
    output: int
    corner case:
    array == null || array.length == 0 || array[0].length == 0
    */
        int sum = 0;
        for (int r = 0; r < array.length; r++) {
            sum += sumRow(array[r]);
        }
        return sum;
    }
    private int sumRow(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
