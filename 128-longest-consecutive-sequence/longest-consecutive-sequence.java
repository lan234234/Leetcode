class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)   return nums.length;

        Map<Integer, Integer> len = new HashMap<>();
        int longest = 1;

        for (int num : nums) {
            if (len.containsKey(num))  continue;
            int leftLen = len.getOrDefault(num - 1, 0);
            int rightLen = len.getOrDefault(num + 1, 0);
            int total = leftLen + rightLen + 1;
            len.put(num - leftLen, total);
            len.put(num + rightLen, total);
            if (!len.containsKey(num)) len.put(num, 0);
            longest = Math.max(longest, total);
        }
        return longest;
    }
}