/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> inorderMap;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        index = n - 1;
        inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(0, index, postorder);
    }

    private TreeNode build(int left, int right, int[] postorder) {
        if (left > right)  return null;

        int rootVal = postorder[index--];
        TreeNode root = new TreeNode(rootVal);
        int rootInd = inorderMap.get(rootVal);
        root.right = build(rootInd + 1, right, postorder);
        root.left = build(left, rootInd - 1, postorder);
        return root;
    }
}