package arrayandstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an original string input, and two strings S and T,
 * replace all occurrences of S in input with T.
 */
public class StringReplace_172 {
    public String stringReplace(String input, String source, String target) {
        // assume source is not null or empty
        // assume target is not null
        // corner case 1:
        if (input == null || input.length() == 0) {
            return input;
        }
        // step 1: get a list of the index of the occurrence of source
        List<Integer> list = getOccurrence(input, source);
        // corner case 2: input does not contain source
        if (list.isEmpty()) {
            return input;
        }
        char[] array = input.toCharArray();
        // case 1:
        if (source.length() >= target.length()) {
            int end = replace(array, array, source, target, list);
            return new String(array, 0, end);
        } else {
            int diff = list.size() * (target.length() - source.length());
            char[] result = new char[array.length + diff];
            replace(array, result, source, target, list);
            return new String(result);
        }
    }
    // get a list of the index of the occurrence of source
    private List<Integer> getOccurrence(String input, String source) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        while (start + source.length() - 1 < input.length()) {
            // from the range of [start, input.length()), get the index when source first occur
            int occurrenceIndex = getFirstOccurrence(input, source, start);
            if (occurrenceIndex == -1) {
                break;
            }
            result.add(occurrenceIndex);
            start = occurrenceIndex + source.length();
        }
        return result;
    }
    // replace all sources in origin with target, the result will be stored in result
    // return the index next to end of the new one
    private int replace(char[] origin, char[] result, String source, String target, List<Integer> occurrenceOfSource) {
        // [0, i) in result: the characters should be remain
        // [j, result.length) in origin: the characters waiting for processing
        int i = 0;
        int j = 0;
        // replace all sources with target
        for (int index : occurrenceOfSource) {
            while (j < index) {
                result[i++] = origin[j++];
            }
            for (int k = 0; k < target.length(); k++) {
                result[i++] = target.charAt(k);
            }
            j += source.length();
        }
        // copy remaining character from origin to result
        while (j < origin.length) {
            result[i++] = origin[j++];
        }
        return i;
    }
    // from the range of [start, input.length()), get the index when source first occur
    // if source not exist in the searching range, return -1
    private int getFirstOccurrence(String input, String source, int start) {
        for (int i = start; i + source.length() -1 < input.length(); i++) {
            // check if the substring start from i to i + source.length() -1 in input is source
            if (isSubstring(input, source, i)) {
                return i;
            }
        }
        return -1;
    }
    private boolean isSubstring(String input, String source, int start) {
        for (int i = 0; i < source.length(); i++) {
            if (input.charAt(start + i) != source.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
