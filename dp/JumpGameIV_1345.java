package dp;

import java.util.*;

public class JumpGameIV_1345 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;
        if (arr[0] == arr[n - 1])   return 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i);
        }

        Queue<Integer> curs = new ArrayDeque<>();
        curs.offer(0);
        Queue<Integer> others = new ArrayDeque<>();
        others.offer(n - 1);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        visited[n - 1] = true;

        int step = 0;
        while (!curs.isEmpty()) {
            if (curs.size() > others.size()) {
                Queue<Integer> temp = curs;
                curs = others;
                others = temp;
            }

            Queue<Integer> next = new ArrayDeque<>();
            for (int cur : curs) {
                if (others.contains(cur + 1) || others.contains(cur - 1))   return step + 1;

                if (cur + 1 < n && !visited[cur + 1]) {
                    next.add(cur + 1);
                    visited[cur + 1] = true;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    next.add(cur - 1);
                    visited[cur - 1] = true;
                }

                List<Integer> neis = map.get(arr[cur]);
                if (neis == null)   continue;
                for (int nei : neis) {
                    if (others.contains(nei))   return step + 1;
                    if (!visited[nei]) {
                        next.add(nei);
                        visited[nei] = true;
                    }
                }
                map.remove(arr[cur]);
            }
            step++;
            curs = next;
        }
        return -1;
    }
}
