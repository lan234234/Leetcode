package bfs;

import java.util.*;

/**
 * Given three arrays sorted in ascending order.
 * Pull one number from each array to form a coordinate <x,y,z> in a 3D space.
 * Find the coordinates of the points that is k-th closest to <0,0,0>.
 */

public class KthClosestPoint_194 {
    public List<Integer> kthClosestPoint(int[] a, int[] b, int[] c, int k) {
        // assume a, b, c are not null
        // assume k > 0 and k <= a.length * b.length * c.length;
        // assume all elements in a, b, c are non-negative
        // key is list of coordinates index, value is the distance to <0, 0, 0>
        Map<List<Integer>, Long> visited = new HashMap<>();
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                if (visited.get(l1) == visited.get(l2)) {
                    return 0;
                }
// the coordinate with smaller distance has the priority
                return visited.get(l1) < visited.get(l2) ? -1 : 1;
            }

        });
        List<Integer> initial = Arrays.asList(0, 0, 0);
        visited.put(initial, distance(initial, a, b, c));
        minHeap.offer(initial);
        while (k > 1) {
            List<Integer> coordinate = minHeap.poll();
            k--;
            // generate valid neighbors and add them to visited and minHeap
            update(coordinate, visited, minHeap, a, b, c);
        }
        List<Integer> result = minHeap.poll();
        return Arrays.asList(a[result.get(0)], b[result.get(1)], c[result.get(2)]);
    }
    private Long distance(List<Integer> index, int[] a, int[] b, int[] c) {
        long x = a[index.get(0)];
        long y = b[index.get(1)];
        long z = c[index.get(2)];
        return x * x + y * y + z * z;
    }
    private void update(List<Integer> coordinate, Map<List<Integer>, Long> visited, PriorityQueue<List<Integer>> minHeap, int[] a, int[] b, int[] c) {
        int[][] increments = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        for (int[] increment : increments) {
            int x = increment[0] +  coordinate.get(0);
            int y = increment[1] +  coordinate.get(1);
            int z = increment[2] +  coordinate.get(2);
            List<Integer> newCoordinate = Arrays.asList(x, y, z);
            if (x < a.length && y < b.length && z < c.length && !visited.containsKey(newCoordinate)) {
                visited.put(newCoordinate, distance(newCoordinate, a, b, c));
                minHeap.offer(newCoordinate);
            }
        }
    }
}
