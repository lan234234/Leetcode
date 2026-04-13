class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int cur;
            if (height[left] <= height[right]) {
                cur = height[left] * (right - left);
                left++;
            } else {
                cur =  height[right] * (right - left);
                right--;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}