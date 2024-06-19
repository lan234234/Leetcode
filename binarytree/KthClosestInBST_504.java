package binarytree;

import java.util.ArrayList;
import java.util.List;

public class KthClosestInBST_504 {
    public int[] closestNumberInBST(TreeNode root, double target, int k) {
        // corner case:
        if (root == null)		return null;
        // general case:
        // step 1: inOrder traverse and find the closest
        List<Integer> list = new ArrayList<>();
        // corner case 2:
        if (k <= 0)	return new int[0];
        int[] closestIndex = new int[1];
        inOrder(root, list, target, closestIndex);
        // step 2: find kth closest
        return kthClosest(list, target, k, closestIndex[0]);
    }
    // inOrder traversal the BST, store keys in the list and update the index of the closest key to the target
    private void inOrder(TreeNode root, List<Integer> list, double target, int[] index) {
        // base case:
        if (root == null) return;
        inOrder(root.left, list, target, index);
        list.add(root.key);
        if (Math.abs(root.key - target) < Math.abs(list.get(index[0]) - target))	index[0] = list.size() - 1;
        inOrder(root.right, list, target, index);
    }
    // find kth closest number in the list
    private int[] kthClosest(List<Integer> list, double target, int k, int index) {
        if (list.size() <= k) {
            return toArray(list, 0, list.size() - 1);
        }
        // elements in [start, end] are in kth closest
        int start = index;
        int end = index;
        k--;	// k is the remaining elements we need to find
        while (k > 1) {
            if (start == 0) {
                end += k;
                k = 0;
                break;
            }
            if (end == list.size() - 1) {
                start -= k;
                k = 0;
                break;
            }
            int left = start - k / 2;
            int right = end + k - k / 2;
            if (left < 0) {
                left = 0;
                right = end + (k - start);
            } else if (right > list.size() - 1) {
                right = list.size() - 1;
                left = start - (k - (right - end));
            }
            if (Math.abs(target - list.get(left)) <= Math.abs(target - list.get(right))) {
                k = k - (start - left);
                start = left;
            } else {
                k = k - (right - end);
                end = right;
            }
        }
        if (k == 1) {
            if (start == 0) {
                end++;
            } else if (end == list.size() - 1) {
                start--;
            } else {
                if (Math.abs(target - list.get(start - 1)) < Math.abs(target - list.get(end +1))) {

                    start--;
                } else {
                    end++;
                }
            }
        }
        return toArray(list, start, end);
    }
    // convert list to array
    private int[] toArray(List<Integer> list, int start, int end) {
        int[] result = new int[end - start +1];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(start + i);
        }
        return result;
    }
}
