class Solution {
    int n;
    public int kthSmallest(int[][] matrix, int k) {
        n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countSmaller(matrix, mid) >= k) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

    private int countSmaller(int[][] matrix, int target) {
        int r = 0;
        int c = n - 1;
        int count = 0;
        while (r < n && c >= 0) {
            if (matrix[r][c] < target) {
                count += c + 1;
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
}