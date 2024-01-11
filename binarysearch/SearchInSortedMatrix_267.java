package binarysearch;

/*
Given a 2D matrix and a target number,
returning the position that the target locates within the matrix.


assume:
matrix: int[][], sorted in ascending order,
        first element of next row is larger than the last element of this row
target: int
duplicate? return any

 */

public class SearchInSortedMatrix_267 {
    public int[] searchInSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = matrix.length * matrix[0].length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return new int[]{row, col};
            }
        }
        return new int[]{-1, -1};
    }


}

/*
    time complexity: O(log(matrix.length * matrix[0].length))
    space complexity: O(1)
 */
