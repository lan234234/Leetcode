class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length <= 1)  return 1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1) {
            int diff = maxHeap.poll() - maxHeap.poll();
            if (diff > 0) {
                maxHeap.offer(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}