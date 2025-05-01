package segmentTree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BlockPlacementQuery {
    public List<Boolean> getResults(int[][] queries) {
        // find the max distance
        int max = 0;
        for (int[] q : queries) {
            max = Math.max(q[1], max);
        }
        max++;  // max as right boundary

        List<Boolean> res = new ArrayList<>();
        TreeSet<Integer> blocks = new TreeSet<>(List.of(0, max));   // add boundary
        SegmentTree tree = new SegmentTree(4 * (max + 1));
        for (int[] q : queries) {
            int cur = q[1];
            int pre = blocks.lower(cur);
            if (q[0] == 1) {
                int next = blocks.higher(cur);
                blocks.add(cur);
                tree.update(0, 0, max, cur, cur - pre); // update block
                tree.update(0, 0, max, next, next - cur);
            } else {
                int maxBlock = tree.getMaxBlock(0, 0, max, pre);
                maxBlock = Math.max(maxBlock, cur - pre);
                res.add(maxBlock >= q[2]);
            }
        }
        return res;
    }

    class SegmentTree {
        /**
         tree[i] is the max of all the block with right boundary in the interval
         e.g. if tree[0] represents the interval [0...6]
         tree[0] is the max of the blocks end with i in [0...6]
         */
        int[] tree;
        int n;
        public SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        /**
         cur represent the current index of tree
         tree[cur] represent the interval [left...right]
         */
        public void update(int cur, int left, int right, int block, int gap) {
            if (left == right) {
                tree[cur] = gap;
                return;
            }
            int mid = (left + right) / 2;
            int leftChild = 2 * cur + 1;
            if (block <= mid) {
                update(leftChild, left, mid, block, gap);
            } else {
                update(leftChild + 1, mid + 1, right, block, gap);
            }
            tree[cur] =  Math.max(tree[leftChild], tree[leftChild + 1]);
        }

        /**
         cur represent the current index of tree
         tree[cur] represent the interval [left...right]
         */
        public int getMaxBlock(int cur, int left, int right, int rightBoundary) {
            if (right <= rightBoundary) return tree[cur];

            int mid = (left + right) / 2;
            int leftChild = 2 * cur + 1;
            if (mid >= rightBoundary) {
                return getMaxBlock(leftChild, left, mid, rightBoundary);
            }
            return Math.max(tree[leftChild], getMaxBlock(leftChild + 1, mid + 1, right, rightBoundary));
        }
    }
}
