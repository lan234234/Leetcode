class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n < 2)    return 0;
        int sufMax = prices[n - 1];
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufMax = Math.max(sufMax, prices[i]);
            profit = Math.max(profit, sufMax - prices[i]);
        }
        return profit;
    }
}