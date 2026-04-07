class Solution {
    Map<String, Integer> map;

    public List<String> topKFrequent(String[] words, int k) {
        map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> (compare(a, b)));
        for (String s : map.keySet()) {
            minHeap.offer(s);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.add(0, minHeap.poll());
        }
        return res;
    }

    private int compare(String a, String b) {
        int count1 = map.get(a);
        int count2 = map.get(b);
        if (count1 == count2)   return b.compareTo(a);
        return count1 - count2;
    }
}