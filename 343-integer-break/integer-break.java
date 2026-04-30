class Solution {
    /**
    0 1 2 3 4 5
      1 2 3 
            1 3
            2 2
            4

    
     */
    public int integerBreak(int n) {
        if (n == 1) return 1;

        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i != n) {
                max[i] = i;
            }
            for (int cut = 1; cut <= i / 2; cut++) {
                int product = max[cut] * max[i - cut];
                max[i] = Math.max(max[i], product);
            }
        }
        return max[n];
    }
}