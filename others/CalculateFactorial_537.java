package others;

/*
calculate factorial of n
 */

//Assumption: n > 1

public class CalculateFactorial_537 {
    public int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

}
