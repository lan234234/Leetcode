class TwoSum {
    Map<Integer, Integer> freq;

    public TwoSum() {
        freq = new HashMap<>();
    }
    
    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (int key : freq.keySet()) {
            if (2 * key == value) {
                if (freq.get(key) > 1)  return true;
            } else if (freq.containsKey(value - key)) {
                return true;
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