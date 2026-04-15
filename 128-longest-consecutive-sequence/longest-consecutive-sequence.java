class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2)   return nums.length;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int longest = 1;

        for (int num : nums) {
            if (left.containsKey(num))  continue;
            int leftBound = Math.min(find(num - 1, left, true, right), num);
            int rightBound = Math.max(find(num + 1, right, false, left), num);
            left.put(num, leftBound);
            right.put(num, rightBound);
            longest = Math.max(longest, rightBound - leftBound + 1);
        }
        return longest;
    }

    private int find(int num, Map<Integer, Integer> map, boolean findLeft, Map<Integer, Integer> map2) {
        Integer res = map.get(num);
        if (res == null)  return findLeft ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (res != num) {
            res = find(res, map, findLeft, map2);
            map.put(num, res);
        }
        int bound = map2.get(res);
        map2.put(res, findLeft ? Math.max(bound, num + 1) : Math.min(bound, num - 1));
        return res;
    }
}