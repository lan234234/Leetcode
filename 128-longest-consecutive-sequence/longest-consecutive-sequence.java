class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (map.containsKey(num))  continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int total = left + right + 1;
            map.put(num + right, total);
            map.put(num - left, total);
            longest = Math.max(total, longest);
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
        }
        return longest;
    }
}