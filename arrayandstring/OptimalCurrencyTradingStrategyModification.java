package arrayandstring;

public class OptimalCurrencyTradingStrategyModification {
    public int solution(int[] rates, int[] strategy, int k) {
        int len = rates.length;
        int[] prefixSum = new int[len];
        int[] sell = new int[len];
        prefixSum[0] = rates[0] * strategy[0];
        sell[0] = rates[0];
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + rates[i] * strategy[i];
            sell[i] = sell[i - 1] + rates[i];
        }
        int max = prefixSum[len - 1];
        if (k == 0)	return max;
        for (int i = 0; i + k <= rates.length; i++) {
            int cur;
            if (i == 0) {
                cur = prefixSum[len - 1] - prefixSum[i + k - 1] + sell[i + k - 1]  - sell[i + k / 2 - 1];
            } else {
                cur = prefixSum[len - 1] - (prefixSum[i + k - 1] - prefixSum[i - 1]) + sell[i + k - 1] - sell[i + k / 2 - 1];
            }
            max = Math.max(max, cur);
        }
        return max;
    }

}
