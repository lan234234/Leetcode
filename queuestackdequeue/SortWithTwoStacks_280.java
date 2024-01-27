package queuestackdequeue;

import java.util.LinkedList;

public class SortWithTwoStacks_280 {
    public void sort(LinkedList<Integer> s1) {
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        int sortCount = 0;
        int min = 0;
        int minCount = 0;
        while (s1.size() > 0) {
            while (s1.size() > 0) {
                min = s1.peekFirst();
                minCount = 1;
                if (s1.peekFirst() < min) {
                    min = s1.peekFirst();
                    minCount = 1;
                } else if (s1.peekFirst() == min) {
                    minCount++;
                }
                s2.offerFirst(s1.pollFirst());
            }
            while (s2.size() > sortCount) {
                if (s2.peekFirst() == min) {
                    s2.pollFirst();
                } else {
                    s1.offerFirst(s2.pollFirst());
                }
            }
            sortCount += minCount;
            while (s2.size() < sortCount) {
                s2.offerFirst(min);
            }
        }
        while (s2.size() > 0) {
            s1.offerFirst(s2.pollFirst());
        }



        // Write your solution here.

    }
}
