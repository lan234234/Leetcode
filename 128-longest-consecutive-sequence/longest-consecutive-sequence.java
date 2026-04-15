class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)   return nums.length;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int longest = 1;

        for (int num : nums) {
            if (left.containsKey(num))  continue;
            int leftBound = left.containsKey(num - 1) ? left.get(num - 1) : num;
            int rightBound = right.containsKey(num + 1) ? right.get(num + 1) : num;
            left.put(rightBound, leftBound);
            right.put(leftBound, rightBound);
            longest = Math.max(longest, rightBound - leftBound + 1);
            if (!left.containsKey(num)) left.put(num, 0);
        }
        return longest;
    }
}