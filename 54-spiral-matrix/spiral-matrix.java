class Solution {
    /**
    
    1 2 3   b
    4 5 6   t     
    l r
    
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                list.add(matrix[top][c]);
            }
            top++;
            if (top > bottom)   break;

            for (int r = top; r <= bottom; r++) {
                list.add(matrix[r][right]);
            }
            right--;
            if (right < left)   break;

            for (int c = right; c >= left; c--) {
                list.add(matrix[bottom][c]);
            }
            bottom--;

            for (int r = bottom; r >= top; r--) {
                list.add(matrix[r][left]);
            }
            left++;
        }
        return list;
    }
}