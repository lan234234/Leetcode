package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindArrayGivenSubsetSums_1982 {
//    int N;
//    public int[] recoverArray(int n, int[] sums) {
//        N = 10000;
//        Arrays.sort(sums);
//        int[] freq = new int[2 * N + 1];
//        int unique = 0;
//        for (int sum : sums) {
//            int actualNum = sum + N;
//            if (freq[actualNum] == 0)   unique++;
//            freq[actualNum]++;
//        }
//        freq[N]--;
//        List<Integer> res = new ArrayList<>();
//        List<Integer> curSum = new ArrayList<>();
//        curSum.add(0);
//        // Map<List<Integer>, List<Integer>> memo = new HashMap<>();
//        // memo.put(res, curSum);
//        recover(sums, 0, res, curSum, n, freq, freq[N] == 0 ? unique - 1 : unique);
//        return res.stream().mapToInt(k -> k).toArray();
//    }
//
//    private boolean recover(int[] sums, int index, List<Integer> res, List<Integer> curSum, int n, int[] freq, int unique) {
//        // base case:
//        if (unique == 0)   return true;
//        if (res.size() == n)    return false;
//
//        int remain = sums.length - index;
//        int need = n - res.size();
//        int available = remain - need;
//        for (int i = index; i <= index + available; i++) {
//            if (i != index && sums[i] == sums[i - 1])   continue;
//            int size = curSum.size();
//            int[] copy = Arrays.copyOf(freq, freq.length);
//            int uniqueCopy = unique;
//            List<Integer> added = new ArrayList<>();
//            for (int j = 0; j < size; j++) {
//                int cur = curSum.get(j) + sums[i] + N;
//                if (copy[cur] == 0) break;
//                copy[cur]--;
//                if (copy[cur] == 0) uniqueCopy--;
//                added.add(cur - N);
//            }
//            if (added.size() == size) {
//                res.add(sums[i]);
//                curSum.addAll(added);
//                if (recover(sums, i + 1, res, curSum, n, copy, uniqueCopy)) return true;
//                res.remove(res.size() - 1);
//                while (curSum.size() != size) {
//                    curSum.remove(curSum.size() - 1);
//                }
//            }
//        }
//        return false;
//    }

    public int[] recoverArray(int n, int[] sums) {
        Arrays.sort(sums);
        int[] res = new int[n];
        int index = 0;

        while (sums.length > 1) {
            int len = sums.length;
            int absDiff = sums[1] - sums[0];
            //using absDiff to separate sums to 2 parts: left[i] + absDiff = right[i]
            int[] left = new int[len / 2];
            int[] right = new int[len / 2];
            int leftIndex = 0;
            int rightIndex = 0;
            int rightPending = 0;   // used to find corresponding element in sums
            boolean leftContainsZero = false;
            for (int i = 0; i < len; i++) {
                // sums[i] already added to right
                if (rightPending < rightIndex && right[rightPending] == sums[i]) {
                    rightPending++;
                } else {
                    left[leftIndex++] = sums[i];
                    right[rightIndex++] = sums[i] + absDiff;
                    if (sums[i] == 0)   leftContainsZero = true;
                }
            }
            if (leftContainsZero) {
                res[index++] = absDiff;
                sums = left;
            } else {
                res[index++] = -absDiff;
                sums = right;
            }
        }
        return res;
    }
}
