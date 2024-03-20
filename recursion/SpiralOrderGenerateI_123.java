package recursion;

public class SpiralOrderGenerateI_123 {
    public int[][] spiralOrderGenerateI(int n) {
        // assume n >= 0
        int[][] matrix = new int[n][n];
        // corner case
        if (n == 0) {
            return matrix;
        }
        // general case
        int circle = 0;	// current traversing circle
        int count = 1;
        int num = n * n;
        while (count <= num) {
            int row = circle;
            int col = circle;
            // if only one element left
            if (count == num) {
                matrix[row][col] = count;
                break;
            }
            while (col < n - 1 - circle) {
                matrix[row][col++] = count++;
            }
            while (row < n - 1 - circle) {
                matrix[row++][col] = count++;
            }
            while (col > circle) {
                matrix[row][col--] = count++;
            }
            while (row > circle) {
                matrix[row--][col] = count++;
            }
            circle++;
        }
        return matrix;
    }

}
