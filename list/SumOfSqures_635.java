package list;

import java.util.List;

/*
Problem: Give an array list of integer, calculate the sum of squares of all its elements.
 */

public class SumOfSqures_635 {
    public int sumOfSquare(List<Integer> list) {
        // corner case
        if (list == null || list.size() == 0)
            return 0;
        // general case
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * list.get(i);
        }
        return result;
    }
}
