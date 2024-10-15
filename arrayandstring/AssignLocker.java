package arrayandstring;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AssignLocker {
    public int assignLocker(String[] clients) {
        // write your code here
        // "Alice", "Eve", "Bob", "Eve", "Carl", "Alice"
        //    1        2     3      4       5        2
        // nextUnassignedNum = 5
        // minHeap:  2
        // map: A-1 E-4 B-3 C-5 A

        int lastAssignedLocker = 1;
        int nextUnassignedNum = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<String, Integer> lockMap = new HashMap<>();
        for (int i = 0; i < clients.length; i++) {
            Integer locker = lockMap.get(clients[i]);;
            if (locker != null) {
                minHeap.offer(locker);
                lockMap.remove(clients[i]);
            } else {
                int curLocker = minHeap.isEmpty() ? nextUnassignedNum++ : minHeap.poll();
                lockMap.put(clients[i], curLocker);
                lastAssignedLocker = curLocker;
            }
        }

        return lastAssignedLocker;
    }
}
