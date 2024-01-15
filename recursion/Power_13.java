package recursion;

/*
Evaluate a to the power of b


assumption:
b >= 0
0^0 = 1
not overflow
 */

public class Power_13 {
    public long power(int a, int b) {
        //base case:
        if (b == 0 || a == 1) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        //general case:
        long temp = power(a, b / 2);
        return b % 2 == 0 ? temp * temp : temp * temp * a;
    }

/*
time complexity: O(logb)
space complexity: O(logb)

 */

}
