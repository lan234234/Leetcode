package arrayandstring;

/*
Given a matrix, find the Kth index element.


assume:
if K == 0	first element

input: int[][], int
output: int

 */

public class KthElementInMatrix_561 {
    public int kthElementInMatrix(int[][] matrix, int k) {
        //corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0
                || k > matrix.length * matrix[0].length || k < 0) {
            return -1;
        }
        int c = k / matrix[0].length;
        int r = k % matrix[0].length;
        return matrix[r][c];
    }

}
