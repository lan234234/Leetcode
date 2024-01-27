package queuestackdequeue;

import java.util.LinkedList;

/*
Given an array that is initially stored in one stack,
sort it with one additional stacks (total 2 stacks).




input: one or two stacks? LinkedList<Integer>
output: void

duplicate?
sort in ascending order from top to bottom?

 */

public class SortWithTwoStacks_280 {
    public void sort(LinkedList<Integer> s1) {
        // corner case;
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        // step 1: sort all elements in descending order from top to bottom in s2
        int sortCount = 0;
        LinkedList<Integer> s2 = new LinkedList<>();
        while (!s1.isEmpty()) {
            // step 1.1: move elements to s2 and find min and minCount in the unsorted elements
            // min: store the minimum value
            int min = s1.peekFirst();
            // minCount: store the number of the min
            int minCount = 0;
            while (!s1.isEmpty()) {
                if (min > s1.peekFirst()) {
                    min = s1.peekFirst();
                    minCount = 1;
                } else if (min == s1.peekFirst()) {
                    minCount++;
                }
                s2.offerFirst(s1.pollFirst());
            }
            // step 1.2 move unsorted elements back to s1 and offer minCount number of min to s2
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
        // step 2: move elements from s2 to s1
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }
//    time complexity: O(n^2)
//    space complexity: O(n)

}
