package arrayandstring;

import java.util.*;

public class AnalyzeUserWebsiteVisitPattern_1152 {
    class Pair {
        int time;
        String web;
        public Pair(int time, String web) {
            this.time = time;
            this.web = web;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Pair> list = map.get(username[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(username[i], list);
            }
            list.add(new Pair(timestamp[i], website[i]));
        }
        Map<List<String>, Integer> count = new HashMap<>();
        for (Map.Entry<String, List<Pair>> entry : map.entrySet()) {
            update(count, entry.getValue());
        }

        List<String> max = null;
        int countMax = 0;
        for (Map.Entry<List<String>, Integer> entry : count.entrySet()) {
            if (entry.getValue() > countMax) {
                max = entry.getKey();
                countMax = entry.getValue();
            } else if (entry.getValue() == countMax && compare(max, entry.getKey()) == 1) {
                max = entry.getKey();
            }
        }

        return max;
    }

    private void update(Map<List<String>, Integer> map, List<Pair> list) {
        list.sort((p1, p2) -> (p1.time - p2.time));

        int n = list.size();
        Set<List<String>> set = new HashSet<>();
        List<String> cur = new ArrayList<>();
        cur.add("");
        cur.add("");
        cur.add("");
        for (int i = 0; i + 2 < n; i++) {
            cur.set(0, list.get(i).web);
            for (int j = i + 1; j + 1 < n; j++) {
                cur.set(1, list.get(j).web);
                for (int k = j + 1; k < n; k++) {
                    cur.set(2, list.get(k).web);
                    if (!set.contains(cur)) {
                        List<String> copy = new ArrayList<>(cur);
                        map.put(copy, map.getOrDefault(cur, 0) + 1);
                        set.add(copy);
                    }
                }
            }
        }
    }

    private int compare(List<String> l1, List<String> l2) {
        for (int i = 0; i < l1.size(); i++) {
            int num = l1.get(i).compareTo(l2.get(i));
            if (num == 0)   continue;
            return num > 0 ? 1 : -1;
        }
        return 0;
    }
}
