public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (n <=3) {
            return results;
        }
        
        getFactors(n, 2, new ArrayList<Integer>(), results);
        return results;
    }
    
    private void getFactors(int n, int start, List<Integer> current, List<List<Integer>> results) {
        if (n == 1) {
        	if (current.size() > 1) {
        		results.add(new ArrayList<Integer>(current));
        	}
            return;
        }
	        
        
        for (int i = start; i <= (int) Math.sqrt(n); i++) {  // ==> here, change 1
            if (n % i != 0) {
                continue;
            }   
            current.add(i);
            getFactors(n/i, i, current, results);
            current.remove(current.size()-1);
        }
        
        int i = n; // ===> here, change 2
        current.add(i);
        getFactors(n/i, i, current, results);
        current.remove(current.size()-1);
    }
}