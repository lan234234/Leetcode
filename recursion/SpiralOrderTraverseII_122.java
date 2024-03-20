package recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseII_122 {
    public List<Integer> spiralOrderTraverseII(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // corner case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        // general case
        int circle = 0;	// current traversing circle
        int num = matrix.length * matrix[0].length;
        while (result.size() < num) {
            int row = circle;
            int col = circle;
            // if only one element left
            if (result.size() + 1 == num) {
                result.add(matrix[row][col]);
                break;
            }
            while (col < matrix[0].length - 1 - circle && result.size() < num) {
                result.add(matrix[row][col++]);
            }
            while (row < matrix.length - 1 - circle && result.size() < num) {
                result.add(matrix[row++][col]);
            }
            while (col > circle && result.size() < num) {
                result.add(matrix[row][col--]);
            }
            while (row > circle && result.size() < num) {
                result.add(matrix[row--][col]);
            }
            circle++;
        }
        return result;
    }

}
