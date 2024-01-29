package queuestackdequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DequeByStacks_645 {
/**
 *  method 1:
 */
//    // field:
//    Deque<Integer> stack1;	// for first-related operation
//    Deque<Integer> stack2;	// for last-related operation
//    // function:
//    // constructor:
//    public DequeByStacks_645() {
//        stack1 = new LinkedList<>();
//        stack2 = new LinkedList<>();
//    }
//    // get the size of deque
//    public int size() {
//        return stack1.size() +  stack2.size();
//    }
//    // check whether deque is empty
//    public boolean isEmpty() {
//        return size() == 0;
//    }
//    // offer from top
//    public boolean offerFirst(Integer n) {
//        return stack1.offerFirst(n);
//    }
//    // offer from bottom
//    public boolean offerLast(Integer n) {
//        return stack2.offerFirst(n);
//    }
//    // peek from top
//    public Integer peekFirst() {
//        if (size() == 0) {
//            return null;
//        }
//        if (!stack1.isEmpty()) {
//            return stack1.peekFirst();
//        }
//        move(stack2, stack1);
//        return stack1.peekFirst();
//    }
//    // peek from bottom
//    public Integer peekLast() {
//        if (size() == 0) {
//            return null;
//        }
//        if (!stack2.isEmpty()) {
//            return stack2.peekFirst();
//        }
//        move(stack1, stack2);
//        return stack2.peekFirst();
//    }
//    // poll from top
//    public Integer pollFirst() {
//        if (size() == 0) {
//            return null;
//        }
//        if (!stack1.isEmpty()) {
//            return stack1.pollFirst();
//        }
//        move(stack2, stack1);
//        return stack1.pollFirst();
//    }
//    // poll from bottom
//    public Integer pollLast() {
//        if (size() == 0) {
//            return null;
//        }
//        if (!stack2.isEmpty()) {
//            return stack2.pollFirst();
//        }
//        move(stack1, stack2);
//        return stack2.pollFirst();
//    }
//    // move elements from a non-empty stack to an empty stack
//    public void move(Deque<Integer> stack, Deque<Integer> emptyStack) {
//        while (stack.size() > 0) {
//            emptyStack.offerFirst(stack.pollFirst());
//        }
//    }
  /**
   * time complexity:
   * 	offer: O(1)
   * 	peek/poll: worst case - O(n)
   */

  // member field:
    Deque<Integer> stackFirst;
    Deque<Integer> stackLast;
    Deque<Integer> buffer;
    // API:
    // constructor:
    public DequeByStacks_645() {
        stackFirst = new ArrayDeque<>();
        stackLast = new ArrayDeque<>();
        buffer = new ArrayDeque<>();
    }
    public int size() {
        return stackFirst.size() + stackLast.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public boolean offerFirst(Integer n) {
        return stackFirst.offerFirst(n);
    }
    public boolean offerLast(Integer n) {
        return stackLast.offerLast(n);
    }
    public Integer peekFirst() {
        if (this.isEmpty()) {
            return null;
        }
        if (stackFirst.isEmpty()) {
            moveHalves(stackLast, stackFirst, buffer);
        }
        return stackFirst.peekFirst();
    }
    public Integer peekLast() {
        if (this.isEmpty()) {
            return null;
        }
        if (stackLast.isEmpty()) {
            moveHalves(stackFirst, stackLast, buffer);
        }
        return stackLast.peekLast();
    }
    public Integer pollFirst() {
        if (this.isEmpty()) {
            return null;
        }
        if (stackFirst.isEmpty()) {
            moveHalves(stackLast, stackFirst, buffer);
        }
        return stackFirst.pollFirst();
    }
    public Integer pollLast() {
        if (this.isEmpty()) {
            return null;
        }
        if (stackLast.isEmpty()) {
            moveHalves(stackFirst, stackLast, buffer);
        }
        return stackLast.pollFirst();
    }
    // move half of the elements from stack to emptyStack
    public void moveHalves(Deque<Integer> stack, Deque<Integer> emptyStack, Deque<Integer> buffer) {
        int mid = stack.size() / 2;
        while (mid > 0) {
            buffer.offerFirst(stack.pollFirst());
            mid--;
        }
        while (stack.size() > 0 ) {
            emptyStack.offerFirst(stack.pollFirst());
        }
        while (buffer.size() > 0 ) {
            stack.offerFirst(buffer.pollFirst());
        }
    }

}
