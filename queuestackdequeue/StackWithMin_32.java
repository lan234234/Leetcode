package queuestackdequeue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Enhance the stack implementation to support min() operation.
 * min() should return the current minimum value in the stack.
 *
 *
 *
 *
 * clarify:
 * if stack == null or stack.size() == 0		return -1
 */

public class StackWithMin_32 {
/**
 *  method 1

    // field:
    Deque<Integer> s;
    Deque<Integer> minStack;
    // function:
    // constructor:
    public StackWithMin_32() {
        s = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    // get size of the stack
    public int size() {
        return s.size();
    }
    // check whether the stack is empty:
    public boolean isEmpty() {
        return s.isEmpty();
    }
    // add a element
    public boolean push(Integer n) {
        s.offerFirst(n);
        if (minStack.isEmpty()) {
            return minStack.offerFirst(n);
        }
        return minStack.offerFirst(minStack.peekFirst() > n ? n : minStack.peekFirst());
    }
    // return the element in the top
    public Integer top() {
        return s.isEmpty() ? -1 : s.peekFirst();
    }
    // remove the top element
    public Integer pop() {
        if (s.isEmpty()) {
            return -1;
        }
        minStack.pollFirst();
        return s.pollFirst();
    }
    // min()
    public Integer min() {
        return s.isEmpty() ? -1 : minStack.peekFirst();
    }
    */

/**
 *  method 2: optimize space complexity

    // field:
    Deque<Integer> stack;
    Deque<Integer> minStack;
    // function:
    // constructor:
    public StackWithMin_32() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    // get size of the stack
    public int size() {
        return stack.size();
    }
    // check whether the stack is empty:
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    // add a element
    public boolean push(Integer n) {
        if (minStack.isEmpty() || minStack.peekFirst() >= n) {
            minStack.offerFirst(n);
        }
        return stack.offerFirst(n);
    }
    // return the element in the top
    public Integer top() {
        return stack.isEmpty() ? -1 : stack.peekFirst();
    }
    // remove the top element
    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (minStack.peekFirst() == stack.peekFirst()) {
            minStack.pollFirst();
        }
        return stack.pollFirst();
    }
    // min()
    public Integer min() {
        return minStack.isEmpty() ? -1 :minStack.peekFirst();
    }
 */

/**
 *  method 3: optimize space complexity if lots of duplicates exist
 */
    // field:
    Deque<Integer> stack;		// store original elements
    Deque<Integer> minStack;	// store the min elements
    Deque<Integer> minStartSize;	// store the size of s when this element starts to be min
    // function:
    // constructor:
    public StackWithMin_32() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStartSize = new ArrayDeque<>();
    }
    public int size() {
        return stack.size();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public boolean push(Integer n) {
        if (stack.isEmpty() || minStack.peekFirst() > n) {
            minStack.offerFirst(n);
            minStartSize.offerFirst(stack.size() + 1);
        }
        return stack.offerFirst(n);
    }
    public Integer top() {
        return stack.isEmpty() ?  -1 : stack.peekFirst();
    }
    public Integer pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        if (stack.peekFirst() == minStack.peekFirst() && stack.size() == minStartSize.peekFirst()) {
            minStack.pollFirst();
            minStartSize.pollFirst();
        }
        return stack.pollFirst();
    }
    public Integer min() {
        return stack.isEmpty() ? -1 : minStack.peekFirst();
    }

}
