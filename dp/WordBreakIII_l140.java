package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakIII_l140 {
    public List<String> wordBreak(String s, List<String> dict) {
        // assume s is not null and empty
        // assume dict is not null and empty
        // assume all String in dict are not null and empty
        // convert list to a set
        Set<String> set = toSet(dict);
        // array[index]: stores all possible break ways of substring start from 0 and with length of index
        List<List<String>>[] array = new List[s.length() + 1];
        array[0] = new ArrayList<>();
        List<String> list = new ArrayList<>();
        array[0].add(list);
        // iterate over all substring start from 0 and with length of index
        for (int index = 1; index <= s.length(); index++) {
            // iterate over all possible separation; separate the substring to two parts:
            // first part: substring start from 0 and with length of sep
            for (int sep = 0; sep < index; sep++) {
                String subs = s.substring(sep, index);
                if (array[sep] != null && set.contains(subs)) {
                    if (array[index] == null) {
                        array[index] = new ArrayList<>();
                    }
                    for (List<String> cur : array[sep]) {
                        list = new ArrayList<>(cur);
                        list.add(subs);
                        array[index].add(list);
                    }
                }
            }
        }
        return toList(array[s.length()]);
    }

    // return a set storing all strings in the given list
    private Set<String> toSet(List<String> list) {
        Set<String> set = new HashSet<>();
        for (String s : list) {
            set.add(s);
        }
        return set;
    }

    private List<String> toList(List<List<String>> list) {
        List<String> result = new ArrayList<>();
        for (List<String> cur : list) {
            StringBuilder sb = new StringBuilder();
            for (String s : cur) {
                sb.append(cur);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }
        return result;
    }

}
