package recursion;

public class SpiralOrderGenerateII_124 {
    public int[][] spiralOrderGenerateII(int m, int n) {
        // assume m >= 0 and n >= 0
        // assume when m == 0 n is also 0
        int[][] matrix = new int[m][n];
        // corner case
        if (m == 0) {
            return matrix;
        }
        // general case
        int circle = 0;
        int count = 1;
        int num = m * n;
        while (count <= num) {
            int row = circle;
            int col = circle;
            // if only one element left
            if (count == num) {
                matrix[row][col] = count;
                break;
            }
            while (col < n - 1 - circle && count <= num) {
                matrix[row][col++] = count++;
            }
            while (row < m - 1 - circle && count <= num) {
                matrix[row++][col] = count++;
            }
            while (col > circle && count <= num) {
                matrix[row][col--] = count++;
            }
            while (row > circle && count <= num) {
                matrix[row--][col] = count++;
            }
            circle++;
        }
        return matrix;
    }

}
