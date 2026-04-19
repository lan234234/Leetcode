class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (left.containsKey(num))  continue;
            int leftBound = left.getOrDefault(num - 1, num);
            int rightBound = right.getOrDefault(num + 1, num);
            left.put(rightBound, leftBound);
            right.put(leftBound, rightBound);
            longest = Math.max(rightBound - leftBound + 1, longest);
            if (!left.containsKey(num)) {
                left.put(num, 0);
            }
        }
        return longest;
    }
}