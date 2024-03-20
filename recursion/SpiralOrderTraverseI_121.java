package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner.
 */
public class SpiralOrderTraverseI_121 {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int cycle = 0;
        while (matrix.length - 2 * cycle > 0) {
            int i = cycle;
            int j = cycle;
            while (j < matrix.length -1 - cycle) {
                result.add(matrix[i][j++]);
            }
            while (i < matrix.length -1 - cycle) {
                result.add(matrix[i++][j]);
            }
            while (j > cycle) {
                result.add(matrix[i][j--]);
            }
            while (i > cycle) {
                result.add(matrix[i--][j]);
            }
            cycle++;
        }
        // if only one element left
        if (matrix.length - 2 * cycle == -1) {
            result.add(matrix[--cycle][cycle]);
        }
        return result;
    }
}
