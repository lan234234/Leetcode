class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = toList(nums);
        dfs(0, list, res);
        return res;
    }

    private void dfs(int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < cur.size(); i++) {
            int num = cur.get(i);
            if (set.contains(num))  continue;
            set.add(num);
            swap(cur, index, i);
            dfs(index + 1, cur, res);
            swap(cur, index, i);
        }
    }

    private void swap(List<Integer> ls, int i, int j) {
        int temp = ls.get(i);
        ls.set(i, ls.get(j));
        ls.set(j, temp);
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for (int num : nums) {
            ls.add(num);
        }
        return ls;
    }
}