package dp;

public class GetDistinctGoodness {
    public int[] getDistinctGoodnessValues(int[] arr) {
        int maxGoodness = 0;
        for (int n : arr) {
            maxGoodness = maxGoodness | n;
        }
// dp[i]: i is the goodness, dp[i] is the corresponding last element of the subsequence
        // different subsequence may calculate to the same goodness, the value in the dp[i] is the minimum one
        int[] dp = new int[maxGoodness +1];
        dp[0] = -1;
        int count = 1;
        for (int n : arr) {
            for (int i = 0; i < dp.length; i++) {
                if(dp[i] != 0 && dp[i] < n) {
                    int goodness = i | n;
                    if (dp[goodness] == 0) {
                        dp[goodness] = n;
                        count++;
                    } else if (dp[goodness] > n) {
                        dp[goodness] = n;
                    }
                }
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] != 0) {
                result[index++] = i;
            }
        }
        return result;
    }

}
