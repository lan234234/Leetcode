class Solution {
    /**
    [1,3,5,4,7]
     1 2 3 3 
    max = 3
    count = 2
    
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int max = 0;
        int res = 0;
        int[] longest = new int[n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            longest[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    int curLen = longest[j] + 1;
                    if (curLen > longest[i]) {
                        longest[i] = curLen;
                        count[i] = count[j];
                    } else if (curLen == longest[i]) {
                        count[i] += count[j];
                    }
                }
            }

            if (longest[i] > max) {
                max = longest[i];
                res = count[i];
            } else if (longest[i] == max) {
                res += count[i];
            } 
        }
        return res;
    }
}