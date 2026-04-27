class Solution {
    /**
    n: total len of words
    l: max len of words
    m: unique words

    1. quick select
                        TC      SC
    get freq:           nl      ml
    unique word arr:            m    
    quick select        m       log(m)
    sort                klog(k) log(k)  
    
    2. sort
    get freq:           nl      ml
    sort                mlogm   logm  
    
    3. heap
    get freq:           nl      ml
    heap:               mlogk
    to array            klogk
    
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> (freq.get(a).equals(freq.get(b)) ? b.compareTo(a) : Integer.compare(freq.get(a), freq.get(b))));
        
        // not valid! must use equals to compare refernce type
        // ((a, b) -> (freq.get(a) == freq.get(b) ? b.compareTo(a) : (freq.get(a) - freq.get(b))));
        
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (String word : freq.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll());
        }
        return res;
    }
}