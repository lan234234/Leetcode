package others;

/*
check Goldbach's conjecture
    "Every even integer greater than 2 can be expressed as the sum of two primes."
 */

public class CheckGoldbachConjecture {
    public boolean checkGoldbachConjecture(int n) {
        for (int i = 4; i <= n; i += 2) {
            if (!checkOneEvenInteger(i))
                return false;
        }
        return true;
    }

    private boolean checkOneEvenInteger(int n) {
        for(int i = 2; i <= n / 2; i++) {
            if (isPrime(i) && isPrime(n - i))
                return true;
        }
        return false;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

}
