package dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a word and a dictionary,
 * determine how many ways it can be broken to the concatenating words from the given dictionary.
 */
public class WordBreakII {
    public int wordBreak(String word, List<String> dict) {
        // assume word is not null and empty
        // assume dict is not null and empty
        Set<String> set = toSet(dict);
        // the element in index means the number of sentences the substring in [0, index] can be broken to
        int[] wordBreak = new int[word.length()];
        // iterate over all substrings in [0, i]
        for (int i = 0; i < word.length(); i++) {
            // j separate the substring to two parts: [0, j] and [j + 1, i]
            // when j is -1, it means not to separate the substring
            for (int j = -1; j < i; j++) {
                if (j == -1 || wordBreak[j] != 0) {
                    if (set.contains(word.substring(j + 1, i + 1))) {
                        wordBreak[i] += j == -1 ? 1 : wordBreak[j];
                    }
                }
            }
        }
        return wordBreak[word.length() - 1];
    }
    // store all strings in list to a set
    private Set<String> toSet(List<String> dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }
}


