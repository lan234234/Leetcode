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

        cur.add(arr[index]);
        dfs(arr, index + 1, rem - arr[index], cur);
        cur.remove(cur.size() - 1);

        int next = index + 1;
        while (next < arr.length && arr[next] == arr[index]) {
            next++;
        }
        dfs(arr, next, rem, cur);
    }
}