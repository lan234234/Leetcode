package recursion;

/*
calculate factorial of n
 */

//Assumption: n > 1

public class CalculateFactorial_550 {
    // method 1:
    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
//    time complexity: O(n)
//    space complexity: O(1)

//    method 2: recursion
    public long factorial2(int n) {
        //base case:
        if (n == 1) {
            return 1;
        }
    //general case:
        return factorial(n - 1) * n;
    }

//    time complexity: O(1) * n = O(n)
//    space complexity: O(1) * n = O(n)

}
