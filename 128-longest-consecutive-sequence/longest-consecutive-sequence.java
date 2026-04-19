class Solution {
    public int longestConsecutive(int[] nums) {
        // corner case
        if (nums.length <= 1)   return nums.length;
        // general case
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int res = 1;
        for (int num : set) {
            // find the left boundary
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}