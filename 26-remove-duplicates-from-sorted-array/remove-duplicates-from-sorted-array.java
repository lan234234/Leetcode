class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (i == 0 || nums[j] != nums[i - 1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}