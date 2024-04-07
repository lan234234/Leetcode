package dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a word and a dictionary,
 * determine if it can be composed by concatenating words from the given dictionary.
 */
public class WordBreakI_99 {
    public boolean dictionaryWordI(String word, String[] dict) {
        // assume the given word is not null and is not empty
        // assume the given dictionary is not null and is not empty
        // assume all the words in the dictionary are not null or empty
        // convert the string array to a set
        Set<String> set = toSet(dict);
        // the element in the index means whether the substring in [0, i] can be composed by the dictionary words
        boolean[] isComposed = new boolean[word.length()];
        // iterate over all substring in [0, i], check if they can be composed by the dictionary words
        for (int i = 0; i < isComposed.length; i++) {
            // j is the index separate the substring to two parts: [0, j] and [j + 1, i]
            for (int j = -1; j < i; j++) {
                if (j == -1 || isComposed[j]) {
                    if (set.contains(word.substring(j + 1, i + 1))) {
                        isComposed[i] = true;
                        break;
                    }
                }
            }
        }
        return isComposed[word.length() - 1];
    }
    // store all strings in dict to a set
    private Set<String> toSet(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String word: dict) {
            set.add(word);
        }
        return set;
    }

}
