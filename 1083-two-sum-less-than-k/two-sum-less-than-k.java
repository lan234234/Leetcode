class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }

        int i = 0; 
        int j = count.length - 1;
        int res = -1;
        while (i < j) {
            if (count[i] == 0) {
                i++;
            } else if (count[j] == 0) {
                j--;
            } else {
                int sum = i + j;
                if (sum < k) {
                    res = Math.max(res, sum);
                    i++;
                } else {
                    j--;
                }
            }  
        }
        if (count[i] > 1 && i * 2 < k) {
            res = Math.max(res, i * 2);
        }
        return res;
    }
}