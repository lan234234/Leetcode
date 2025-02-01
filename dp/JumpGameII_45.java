package dp;

public class JumpGameII_45 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int maxIndex = 0;   // the current maxIndex I can reach with step
        int max = 0;    // current max index i can reach (in step/step + 1)
        int step = 0;
        for (int i = 0; i < n; i++) {
            int curMax = i + nums[i];
            if (curMax >= n - 1) return step + 1;
            max = Math.max(max, curMax);
            if (i == maxIndex) {
                step++;
                maxIndex = max;
            }
        }
        return step;
    }
}
