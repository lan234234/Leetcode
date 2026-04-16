class TwoSum {
    Map<Integer, Integer> freq;
    Set<Integer> sum;

    public TwoSum() {
        freq = new HashMap<>();
        sum = new HashSet<>();
    }
    
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        if (sum.contains(value))    return true;
        for (int key : freq.keySet()) {
            if (freq.containsKey(value - key)) {
                if (value != 2 * key || freq.get(key) > 1) {
                    sum.add(value);
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */