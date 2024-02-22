package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords_67 {
    public String[] topKFrequentWords(String[] words, int k) {
        // assume k > 0
        // assume the max count of a word is in int range
        // assume the indexes of String[] words are in int range
        // corner case:
        if (words == null || words.length <= 1) {
            return words;
        }
        // step 1: iterate over all words in the map and store word count key value pair in map
        Map<String, Integer> map = countWords(words);
        // store word count entry
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return 0;
                }
                // the word with less count has the priority
                return e1.getValue() < e2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            // step 2: offer k entries to the minHeap
            if (minHeap.size() < k) {
                minHeap.offer(e);
            } else {
                // step 3: compare the rest entry with the top entry
                Map.Entry<String, Integer> top = minHeap.peek();
                if (top.getValue() < e.getValue()) {
                    minHeap.poll();
                    minHeap.offer(e);
                }
            }
        }
        String[] result = copyHeap(minHeap);
        return result;
    }
    private Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            int count = !map.containsKey(word) ? 1 : map.get(word) + 1;
            map.put(word, count);
        }
        return map;
    }
    private String[] copyHeap(PriorityQueue<Map.Entry<String, Integer>> heap) {
        String[] result = new String[heap.size()];
        for (int i = result.length - 1; i >= 0 ; i--) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }


}
