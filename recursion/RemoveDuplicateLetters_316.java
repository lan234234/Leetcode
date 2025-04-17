package recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] exist = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (exist[c - 'a']) continue;
            if (!stack.isEmpty() && stack.peekFirst() > c && last[stack.peekFirst() - 'a'] > i) {
                exist[stack.pollFirst() - 'a'] = false;
                i--;
            } else {
                stack.offerFirst(c);
                exist[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

}
