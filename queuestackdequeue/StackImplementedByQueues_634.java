package queuestackdequeue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackImplementedByQueues_634 {
/**
    method 1:

    // field:
    LinkedList<Integer> q1;
    LinkedList<Integer> q2;
    // function:
    public StackImplementedByQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    public int size() {
        return q1.size() + q2.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean push(Integer n) {
        if (size() == 0) {
            return q1.offer(n);
        }
        if (q1.isEmpty()) {
            return q2.offer(n);
        } else {
            return q1.offer(n);
        }
    }
    public Integer top() {
        if (size() == 0) {
            return null;
        }
        int result = 0;
        if (q1.isEmpty()) {
            move(q2, q1);
            result = q2.peek();
            q1.offer(q2.poll());
        } else {
            move(q1, q2);
            result = q1.peek();
            q2.offer(q1.poll());
        }
        return result;
    }
    public Integer pop() {
        if (size() == 0) {
            return null;
        }
        int result = 0;
        if (q1.isEmpty()) {
            move(q2, q1);
            return q2.poll();
        } else {
            move(q1, q2);
            return q1.poll();
        }
    }
    public void move(LinkedList<Integer> out, LinkedList<Integer> in) {
        while (out.size() > 1) {
            in.offer(out.poll());
        }
    }
     */

/**
     method 2:
     assume: queue only has offer() and poll() operation

    // field:
    // emptyQueue: only used for pop() and peek()
    Queue<Integer> emptyQueue;
    // q: store the all elements
    Queue<Integer> q;
    int size;

    // function:
    // constructor:
    public StackImplementedByQueues() {
        emptyQueue = new ArrayDeque<>();
        q = new ArrayDeque<>();
        size = 0;
    }
    // get size of the stack
    public int size() {
        return size;
    }
    // check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }
    // add n to the stack
    public boolean push(Integer n) {
        size++;
        return q.offer(n);
    }
    // get top element in stack
    public Integer top() {
        if (size == 0) {
            return null;
        }
        // step 1: move all but the last elements from q to emptyQueue
        Integer cur = lastElementAfterMove(q, emptyQueue);
        // step 2: offer the last element to emptyQueue
        emptyQueue.offer(cur);
        // step 3: exchange the reference of q and emptyQueue
        Queue<Integer> temp = q;
        q = emptyQueue;
        emptyQueue = temp;
        return cur;
    }
    // remove the top element in stack
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        // step 1: move all but the last elements from q to emptyQueue
        Integer cur = lastElementAfterMove(q, emptyQueue);
        // step 2: exchange the reference of q and emptyQueue
        Queue<Integer> temp = q;
        q = emptyQueue;
        emptyQueue = temp;
        size--;
        return cur;
    }
    // move all elements but the last from q1 to q2. Then, poll and return the last element.
    public Integer lastElementAfterMove(Queue<Integer> q1, Queue<Integer> q2) {
        Integer cur = q1.poll();
        Integer next = q1.poll();
        while (next != null) {
            q2.offer(cur);
            cur = next;
            next = q1.poll();
        }
        return cur;
    }
 */

/**
    method 3: only use one queue to implement stack
 */
    // filed:
    Queue<Integer> q;
    // function:
    // constructor:
    public StackImplementedByQueues_634() {
        q = new ArrayDeque<>();
    }
    // get the stack size
    public int size() {
        return q.size();
    }
    // check whether the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
    // add element in the stack
    public boolean push(Integer n) {
        return q.offer(n);
    }
    // return top element in the stack
    public Integer top() {
        if (isEmpty()) {
            return null;
        }
        Integer cur = move(q);
        q.offer(cur);
        return cur;
    }
    // remove the top element from the stack and return it
    public Integer pop() {
        if (isEmpty()) {
            return null;
        }
        Integer cur = move(q);
        return cur;
    }
    // move the size() - 1 numbers of element from top to bottom
    // but for the last element, only poll() and return it
    public Integer move(Queue<Integer> q) {
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
        return q.poll();
    }

}

