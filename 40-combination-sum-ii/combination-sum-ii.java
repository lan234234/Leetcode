class Solution {
    /**
    [10,1,2,7,6,1,5]
    
    
    
     */
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] arr, int index, int rem, List<Integer> cur) {
        if (rem == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index == arr.length || arr[index] > rem)    return;

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            cur.add(arr[i]);
            dfs(arr, i + 1, rem - arr[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}