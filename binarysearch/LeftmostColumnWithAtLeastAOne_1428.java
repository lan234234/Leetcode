package binarysearch;

import java.util.Arrays;
import java.util.List;

public class LeftmostColumnWithAtLeastAOne_1428 {

    class BinaryMatrix {
        int[][] matrix;
        public BinaryMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public List<Integer> dimensions() {
            return Arrays.asList(matrix.length, matrix[0].length);
        }

        public int get(int row, int col) {
            return matrix[row][col];
        }
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = dimension.get(0);
        int col = dimension.get(1);
        int result = col;
        for (int i = 0; i < row; i++) {
            int firstOne = findFirstOne(i, binaryMatrix, col);
            if (result > firstOne) {
                result = firstOne;
                if (result == 0)    return 0;
            }
        }
        return result == col ? -1 : result;
    }

    private int findFirstOne(int row, BinaryMatrix binaryMatrix, int n) {
        int result = n;
        if (binaryMatrix.get(row, n - 1) == 0)  return result;
        if (binaryMatrix.get(row, 0) == 1)  return 0;
        int left = 1;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (binaryMatrix.get(row, mid) == 1) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
