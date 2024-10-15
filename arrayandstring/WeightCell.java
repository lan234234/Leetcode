package arrayandstring;

import java.util.PriorityQueue;

public class WeightCell {
    public int[] solution(int[][] matrix) {
        // corner case:
        if (matrix.length == 1) {
            return new int[]{matrix[0][0]};
        }
        // general case:
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (int row = 0; row < matrix.length; row++) {
            int weight = 0;
            int curRow = row;
            int curCol = 0;
            while (curRow >= 0 && curCol < matrix[0].length) {
                weight += matrix[curRow--][curCol++];
            }
            curRow = curRow < 0 ? 1 : curRow;
            while (curRow < matrix[0].length && curCol < matrix[0].length) {
                weight += matrix[curRow++][curCol++];
            }
            minHeap.offer(new Node(matrix[row][0], weight));
        }
        int[] result = new int[minHeap.size()];
        for (int i = 0; !minHeap.isEmpty(); i++) {
            result[i] = minHeap.poll().value;
        }
        return result;
    }
    class Node implements Comparable<Node>{
        int value;
        int weight;
	    public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node node) {
            if (this.weight == node.weight) {
                return this.value - node.value;
            }
            return this.weight - node.weight;
        }
    }

}
