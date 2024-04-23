package dp;

/**
 * Given a matrix that contains integers, find the submatrix with the largest sum.
 *
 * Return the sum of the submatrix.
 */
public class LargestSubMatrixSum_106 {
    // input: int[][] matrix
    // output: int
    // high level:
    // step 1: iterate each top and bottom pair, calculate the sum (between the top and bottom)
    //         arraySum[j] represents the sum of column of j between the top and bottom
    // step 2: calculate the largest sum of a subarray for each arraySum
    // matrix:
    //  1, -2, -1, 4
    //  1, -1,  1, 1
    //  0, -1, -1, 1
    //  0,  0,  1, 1
    // i: top [0, matrix.length]
    // j: bottom [i, matrix.length]
    // arraySum[index]: sum for the column of index between top and bottom
    // i = 1, j = 1 -->  arraySum = {1, -1, 1, 1}
    // i = 1, j = 2 -->  arraySum = {1, -2, 0, 2}
    // i = 1, j = 3 -->  arraySum = {1, -2, 1, 3} ---> arraysum[index] = arraysum[index] + matrix[j][index]
    //                          M    1  -1  1  4
    // M[index]: largest subarray sum in [0, index] must including arraySum[index]
    // M[i] = (M[i - 1] <= 0 ? arraySum[i] : arraySum[i]) + M[i - 1]
    // optimize: int curMax representing M[i - 1]

    // Time complexity: O((row ^ 2) * col)
    // Space complexity: O(col) if GC happens immediately

    public int largest(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = matrix[0][0];
        //compress every col between i and j
        for (int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for (int j = i; j < row; j++) {
                calculateColSum(cur, matrix[j]);
                //largest subarray
                int curMax = largestSubarray(cur);
                max = Math.max(max, curMax);
            }
        }
        return max;
    }
    public void calculateColSum(int[] cur, int[] array) {
        for (int index = 0; index < array.length; index++) {
            cur[index] += array[index];
        }
    }
    public int largestSubarray(int[] cur) {
        int max = cur[0];
        int curMax = cur[0];
        for (int index = 1; index < cur.length; index++) {
            curMax = curMax > 0 ? curMax + cur[index] : cur[index];
            max = Math.max(max, curMax);
        }
        return max;
    }
}
