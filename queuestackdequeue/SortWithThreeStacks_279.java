package queuestackdequeue;

import java.util.Deque;
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
    public void sortWithThreeStacks(Deque<Integer> s1) {
        // corner case:
        if (s1 == null || s1.size() == 1) {
            return;
        }
        // general case:
        Deque<Integer> buffer = new LinkedList();
        Deque<Integer> result = new LinkedList();
        while (s1.size() > 0) {
            // step 1: traverse all elements in s1 to find the min and store the value in global min
            // move all elements from s1 to buffer
            int min = s1.peekFirst();
            while (!s1.isEmpty()) {
                if (s1.peekFirst() < min) {
                    min = s1.peekFirst();
                }
                buffer.offerFirst(s1.pollFirst());
            }
            // step 2: traverse again to find min and move min to result
            // and move rest back to s1
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
    public void sort(Deque<Integer> s1) {
        Deque<Integer> s2 = new LinkedList<Integer>();
        Deque<Integer> s3 = new LinkedList<Integer>();
        sort(s1, s2, s3, s1.size());
    }

    private void sort(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3, int size) {
        if (size <= 1)  return;
        int mid1 = size / 2;
        int mid2 = size - mid1;
        for (int i = 0; i < mid2; i++) {
            s2.offerFirst(s1.pollFirst());
        }
        sort(s1, s2, s3, mid1);
        sort(s2, s1, s3, mid2);
        while (mid1 > 0 || mid2 > 0) {
            if (mid1 != 0 && (mid2 == 0 || s1.peekFirst() <= s2.peekFirst())) {
                s3.offerFirst(s1.pollFirst());
                mid1--;
            } else {
                s3.offerFirst(s2.pollFirst());
                mid2--;
            }
        }
        while (size > 0) {
            s1.offerFirst(s3.pollFirst());
            size--;
        }
    }
    //    time complexity: O(nlogn)
//    space complexity: O(n)
}
