package binarytree;

public class ConstructBinaryTreeFromString_536 {
    int index;
    boolean firstNode;
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty())   return null;
        index = 0;
        firstNode = true;
        return build(s, 0);
    }

    private TreeNode build(String s, int num) {
        if (index >= s.length())  return firstNode ? new TreeNode(num) : null;

        char c = s.charAt(index++);
        if (c == '(') {
            firstNode = false;
            if (num == 0) {
                int a = 0;
            }
            TreeNode root = new TreeNode(num);
            root.left = build(s, 0);
//            if (root.key == 2) {
//                int a = 2;
//            }
            if (index < s.length() && s.charAt(index) == '(') {
                root.right = build(s, 0);
                index++;
            }
            return root;
        } else if (Character.isDigit(c)) {
            num = num * 10 + c - '0';
            return build(s, num);
        } else {
            return new TreeNode(num);
        }
    }
}
