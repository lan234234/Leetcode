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
        List<Integer> factors = getAllFactors(n);
        Collections.sort(factors);

        if (n == 1) return res;
        dfs(n, factors, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int num, List<Integer> factors, int index, List<Integer> cur) {
        if (num == 1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = index; i < factors.size(); i++) {
            if (factors.get(i) > num)   break;
            int f = factors.get(i);
            if (num % f == 0) {
                cur.add(f);
                dfs(num / f, factors, i, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private List<Integer> getAllFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                if (i * i < num) {
                    factors.add(num / i);
                }
            }
        }
        return factors;
    }
}