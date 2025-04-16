import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    class TrieNode {
        TrieNode[] children;
        List<String> words;
        boolean sorted;
        public TrieNode() {
            children = new TrieNode[26];
            words = new ArrayList<>();
            sorted = false;
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        // 1. construct Trie
        TrieNode root = new TrieNode();
        for (String product : products) {
            TrieNode cur = root;
            for (int i = 0; i < product.length(); i++) {
                int index = product.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                cur.words.add(product);
            }
        }

        // 2. search
        List<List<String>> res = new ArrayList<>();
        TrieNode cur = root;
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> list = new ArrayList<>();
            int index = searchWord.charAt(i) - 'a';
            if (cur.children[index] != null) {
                cur = cur.children[index];
                if (!cur.sorted) {
                    Collections.sort(cur.words);
                }
                for (String word : cur.words) {
                    list.add(word);
                    if (list.size() == 3)   break;
                }
            }
            res.add(list);
        }

        return res;
    }
}
