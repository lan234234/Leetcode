package recursion;

/*
Get the Kth number in the Fibonacci Sequence.
(K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).


assumption
f(n) = f(n - 1) + f(n - 2)
f(0) = 0
f(1) = 1
if n < 0		return 0
overflow???

 */

public class Fibonacci_624 {
    //method 1: recursion
    public int fibonacci(int n) {
        //corner case:
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //general case:
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
    time complexity: O(2^n)
    space complexity: O(n)
     */
}
