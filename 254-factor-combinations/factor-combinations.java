class Solution {
    /**
    12
    factors: 2, 3, 4, 6
           2                        3
    2,2         2,3 2,4 2,6     3,3  3,4
    2,2,2 2,2,3                 
    
    
    
     */
    List<List<Integer>> res;
    public List<List<Integer>> getFactors(int n) {
        res = new ArrayList<>();
        dfs(n, 2, new ArrayList<>());
        return res;
    }

    private void dfs(int num, int start, List<Integer> cur) {
        if (num == 1) {
            if (cur.size() > 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        
        for (int i = start; i * i <= num; i++) {
            if (num % i == 0) {
                cur.add(i);
                dfs(num / i, i, cur);
                cur.remove(cur.size() - 1);
            }
        }

        cur.add(num);
        dfs(1, num, cur);
        cur.remove(cur.size() - 1);
    }
}