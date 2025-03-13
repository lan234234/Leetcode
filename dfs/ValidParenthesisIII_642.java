package dfs;

import java.util.*;

public class ValidParenthesisIII_642 {
    char[] p;
    int[] count;
    public List<String> validParenthesesIII(int l, int m, int n) {
        List<String> res = new ArrayList<>();
        count = new int[]{l, m, n};
        p = new char[]{'(', '<', '{', ')', '>', '}'};
        dfs((l + m + n) * 2, new StringBuilder(), res, new ArrayDeque<>());
        return res;
    }

    private void dfs(int remain, StringBuilder sb, List<String> res, Deque<Integer> stack) {
        if (remain == 0) {
            res.add(sb.toString());
            return;
        }

        // case 1: left
        Integer top = stack.peekFirst();
        top = top == null ? 3 : top;
        for (int i = 0; i < top; i++) {
            if (count[i] > 0) {
                sb.append(p[i]);
                count[i]--;
                stack.offerFirst(i);
                dfs(remain - 1, sb, res, stack);
                sb.deleteCharAt(sb.length() - 1);
                count[i]++;
                stack.pollFirst();
            }
        }

        // case 2: right
        if (top != 3) {
            stack.pollFirst();
            int right = top + 3;
            sb.append(p[right]);
            dfs(remain - 1, sb, res, stack);
            sb.deleteCharAt(sb.length() - 1);
            stack.offerFirst(top);
        }
    }
}
