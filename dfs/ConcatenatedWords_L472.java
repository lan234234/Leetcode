package dfs;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords_L472 {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (validConcatenated(word, 0, root, new Boolean[word.length()])) {
                res.add(word);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            add(word, root);
        }
        return root;
    }

    private boolean validConcatenated(String word, int index, TrieNode root, Boolean[] memo) {
        if (index == word.length()) return true;
        if (memo[index] != null)    return memo[index];

        boolean res = false;
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            cur = cur.children[charIndex];
            if (cur == null) break;
            if (cur.isWord) {
                if (i == word.length()  - 1 && index == 0)  return false;
                if (validConcatenated(word, i + 1, root, memo)) {
                    res = true;
                    break;
                }
            }
        }
        memo[index] = res;
        return res;
    }

    private void add(String word, TrieNode root) {
        for (int i = 0; i < word.length(); i++) {
            int charIndex = word.charAt(i) - 'a';
            TrieNode next = root.children[charIndex];
            if (next == null) {
                next = new TrieNode();
                root.children[charIndex] = next;
            }
            root = next;
        }
        root.isWord = true;
    }
}
