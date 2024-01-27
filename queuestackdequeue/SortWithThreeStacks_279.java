package queuestackdequeue;

import java.util.LinkedList;

/*
Given one stack with integers, sort it with two additional stacks (total 3 stacks).



assume:
input: 1 or 3 stack ? LinkedList
output: LinkedList or void ? sort in ascending order from top to bottom?

 */

public class SortWithThreeStacks_279 {
    /*
    / method 1:
     */
    public void sortWithThreeStacks(LinkedList<Integer> s1) {
        // corner case:
        if (s1 == null || s1.size() == 1) {
            return;
        }
        // general case:
        LinkedList<Integer> buffer = new LinkedList();
        LinkedList<Integer> result = new LinkedList();
        while (s1.size() > 0) {
            // step 1: find the min and store the value in global min
            int min = s1.peekFirst();
            while (!s1.isEmpty()) {
                if (s1.peekFirst() < min) {
                    min = s1.peekFirst();
                }
                buffer.offerFirst(s1.pollFirst());
            }
            // step 2: find the min and move it to result
            while (!buffer.isEmpty()) {
                if (buffer.peekFirst() == min) {
                    result.offerFirst(buffer.pollFirst());
                } else {
                    s1.offerFirst(buffer.pollFirst());
                }
            }
        }
        System.out.println(result);
        // move element from result back to s1
        while (!result.isEmpty()) {
            s1.offerFirst(result.pollFirst());
        }
    }
//    time complexity: O(n^2)
//    space complexity: O(n)

    /*
    / method 2: merge sort
     */
    public void sortWithThreeStacks2(LinkedList<Integer> s1) {
        // base case:
        if (s1 == null || s1.size() <= 1) {
            return;
        }
        // general case:
        int mid = s1.size() / 2;
        LinkedList<Integer> s2 = new LinkedList<>();
        LinkedList<Integer> s3 = new LinkedList<>();
        while (s2.size() < mid) {
            s2.offerFirst(s1.pollFirst());
        }
        sortWithThreeStacks2(s1);
        sortWithThreeStacks2(s2);
        merge(s1, s2, s3);
    }

    private void merge(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3) {
        // offer smaller element to s3
        while (s1.size() > 0 && s2.size() > 0) {
            s3.offerFirst(s1.peekFirst() <= s2.peekFirst() ? s1.pollFirst() : s2.pollFirst());
        }
        LinkedList<Integer> temp = s1.size() > 0 ? s1 : s2;
        while (temp.size() > 0) {
            s3.offerFirst(temp.pollFirst());
        }
        // move all elements from s3 to s1
        while (s3.size() > 0) {
            s1.offerFirst(s3.pollFirst());
        }
    }
//    time complexity: O(nlogn)
//    space complexity: O(n)
}
