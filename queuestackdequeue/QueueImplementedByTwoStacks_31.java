package queuestackdequeue;

import java.util.LinkedList;

/*
Implement a queue by using two stacks.


CLARIFY:
1. field:
size

2. function:
size()
isEmpty()
peek()
poll()
offer()
principle: first in first out

When the queue is empty, poll() and peek() should return null.

 */

public class QueueImplementedByTwoStacks_31 {
    LinkedList<Integer> s1;
    LinkedList<Integer> s2;
    public QueueImplementedByTwoStacks_31() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    public int size() {
        return s1.size() + s2.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public Integer peek() {
        if (this.isEmpty()) {
            return null;
        }
        if (s2.size() == 0) {
            move();
        }
        return s2.peekFirst();
    }
    public Integer poll() {
        if (this.isEmpty()) {
            return null;
        }
        if (s2.size() == 0) {
            move();
        }
        return s2.pollFirst();
    }
    public boolean offer(Integer n) {
        return s1.offerFirst(n);
    }
    public void move() {
        while (!s1.isEmpty()) {
            s2.offerFirst(s1.pollFirst());
        }
    }
}

//    time complexity:
//        enqueue: O(1)
//        dequeue: amortized O(1)
