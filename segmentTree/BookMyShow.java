package segmentTree;

public class BookMyShow {
    int row;
    int col;
    SegmentTree tree;

    public BookMyShow(int n, int m) {
        row = n;
        col = m;
        tree = new SegmentTree();
    }

    public int[] gather(int k, int maxRow) {
        int r = tree.findFirstRow(0, 0, row - 1, maxRow, col - k);
        if (r == -1)    return new int[0];
        int c = (int) tree.querySum(0, 0, row - 1, r, r);
        tree.update(0, 0, row - 1, r, k);
        return new int[]{r, c};
    }

    public boolean scatter(int k, int maxRow) {
        long sum = tree.querySum(0, 0, row - 1, 0, maxRow);
        if ((long) (maxRow + 1) * col - sum < k)   return false;

        int firstRow = tree.findFirstRow(0, 0, row - 1, maxRow, col - 1);
        while (k > 0) {
            int occupy = Math.min(k, col - (int) tree.querySum(0, 0, row - 1, firstRow, firstRow));
            tree.update(0, 0, row - 1, firstRow, occupy);
            k -= occupy;
            firstRow++;
        }
        return true;
    }

    class SegmentTree {
        int[] min;  // min occupied
        long[] sum;  // sum occupied

        public SegmentTree() {
            int size = 4 * row;
            min = new int[size];
            sum = new long[size];
        }

        // find the first row < maxRow in [left, right] with occupy < maxOccupy
        public int findFirstRow(int cur, int left, int right, int maxRow, int maxOccupy) {
            if (left > maxRow || min[cur] > maxOccupy)  return -1;
            if (left == right)  return left;

            int mid = (left + right) / 2;
            int leftChild = 2 * cur + 1;
            int res = findFirstRow(leftChild, left, mid, maxRow, maxOccupy);
            if (res != -1)  return res;
            return findFirstRow(leftChild + 1, mid + 1, right, maxRow, maxOccupy);
        }

        // find the sum of occupy in [minRow, maxRow] in [left, right]
        public long querySum(int cur, int left, int right, int minRow, int maxRow) {
            if (left >= minRow && right <= maxRow)  return sum[cur];
            if (left > maxRow || right < minRow)    return 0;
            long sum = 0;
            int mid = (left + right) / 2;
            int leftChild = 2 * cur + 1;
            if (mid >= minRow)  sum += querySum(leftChild, left, mid, minRow, maxRow);
            if (mid < maxRow)  sum += querySum(leftChild + 1, mid + 1, right, minRow, maxRow);
            return sum;
        }

        // put occupy into row r
        public void update(int cur, int left, int right, int r, int occupy) {
            if (occupy == 0)    return;
            sum[cur] += occupy;
            if (left == right) {
                min[cur] += occupy;
                return;
            }
            int mid = (left + right) / 2;
            int leftChild = 2 * cur + 1;
            if (r <= mid) {
                update(leftChild, left, mid, r, occupy);
            } else {
                update(leftChild + 1, mid + 1, right, r, occupy);
            }
            min[cur] = Math.min(min[leftChild], min[leftChild + 1]);
        }
    }
}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
