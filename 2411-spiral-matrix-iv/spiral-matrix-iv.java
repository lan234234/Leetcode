/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        for (int r = 0; r < m; r++) {
            Arrays.fill(matrix[r], -1);
        }

        if (head == null)   return matrix;

        outerloop:
        while (left <= right && top <= bottom) {
            for (int c = left; c <= right; c++) {
                matrix[top][c] = head.val;
                head = head.next;
                if (head == null)   break outerloop;
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                matrix[r][right] = head.val;
                head = head.next;
                if (head == null)   break outerloop;
            }
            right--;

            for (int c = right; c >= left; c--) {
                matrix[bottom][c] = head.val;
                head = head.next;
                if (head == null)   break outerloop;
            }
            bottom--;

            for (int r = bottom; r >= top; r--) {
                matrix[r][left] = head.val;
                head = head.next;
                if (head == null)   break outerloop;
            }
            left++;
        }
        return matrix;
    }
}