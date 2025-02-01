package dp;

public class JumpGameI_55 {
    public boolean canJump(int[] nums) {
        // corner case:
        if (nums.length == 1)   return true;
        // general case
        int maxIndex = 0;
        for (int i = 0; i < nums.length && i <= maxIndex; i++) {
            int curMax = i + nums[i];
            if (curMax > maxIndex) {
                if (curMax >= nums.length - 1)    return true;
                maxIndex = curMax;
            }
        }
        return false;
    }
}
