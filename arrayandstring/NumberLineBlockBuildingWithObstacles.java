package arrayandstring;

import java.util.*;

public class NumberLineBlockBuildingWithObstacles {
    public String solution(List<List<Integer>> operations) {
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        List<Integer> obstacles = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            List<Integer> operation = operations.get(i);
            if (operation.get(0) == 1) {
                if (set.add(operation.get(1))) {
                    obstacles.add(operation.get(1));
                }
            } else {
                int startIndex = operation.get(1) - operation.get(2);
                if (i != 0 && operations.get(i - 1).get(0) == 1) {
                    Collections.sort(obstacles);
                }
                Integer index = findSmallestLargerOrEqual(obstacles, startIndex);
                if (index != null && index < operation.get(1)) {
                    sb.append('0');
                } else {
                    sb.append('1');
                }
            }
        }
        return sb.toString();
    }

    private Integer findSmallestLargerOrEqual(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else if (list.get(mid) == target) {
                return mid;
            } else {
                right = mid;
            }
        }
        return list.get(left) < target ? null : list.get(left);
    }

}
