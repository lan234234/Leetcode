package binarytree;

/**
 * Determine whether two given binary trees are identical.
 */
public class IsTweakedIdentical_50 {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // base case:
        if (one == null && two == null) {
            return true;
        }
        // recursive rule:
        if (one == null || two == null) {
            return false;
        }
        if (one.key != two.key) {
            return false;
        }
        boolean case1 = isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
        boolean case2 = isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
        return case1 || case2;
    }

}
