class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            maxHeap.offer(s);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int sec = maxHeap.poll();
            if (max == sec) continue;
            maxHeap.offer(max - sec);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}