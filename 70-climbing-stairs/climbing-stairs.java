class Solution {
    int[] wayCount;
    public int climbStairs(int n) {
        if (n <= 2) return n;
        wayCount = new int[n + 1];
        wayCount[1] = 1;
        wayCount[2] = 2;
        return countWays(n);
    }

    private int countWays(int n) {
        if (wayCount[n] != 0)   return wayCount[n];

        wayCount[n] = countWays(n - 1) + countWays(n - 2);
        return wayCount[n];
    }
}