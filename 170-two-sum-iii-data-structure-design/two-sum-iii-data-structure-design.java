class TwoSum {
    Map<Integer, Integer> freq;

    public TwoSum() {
        freq = new HashMap<>();
    }
    
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int diff = value - key;
            if ((key == diff && entry.getValue() > 1) || (key != diff && freq.containsKey(diff)))   return true;
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