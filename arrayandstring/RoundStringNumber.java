package arrayandstring;

public class RoundStringNumber {
    public String roundStringNumber(String s) {
        int num = Integer.parseInt(s);
        int n = s.length();
        int mod = (int) Math.pow(10, n - 1);
        int rem = num % mod;

        if (rem == 0)  return s;

        int first = num - rem;
        if (rem > mod / 2) {
            return String.valueOf(first + mod);
        } else {
            return String.valueOf(first);
        }

    }
}
