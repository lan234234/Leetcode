class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int[] wayCount = new int[n + 1];
        wayCount[1] = 1;
        wayCount[2] = 2;

        for (int i = 3; i <= n; i++) {
            wayCount[i] = wayCount[i - 1] + wayCount[i - 2];
        }
        return wayCount[n];
    }
}