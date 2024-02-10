package heap;

public class IsMinHeap_391 {
    public boolean isMinHeap(int[] array) {
        // corner case:
        if (array == null || array.length == 0) {
            return true;
        }
        // general case:
        for (int index = 0; index < array.length; index++) {
            int child1 = index * 2 + 1;
            int child2 = index * 2 + 2;
            if (child1 >= array.length) {
                return true;
            } else if (array[index] > array[child1]) {
                return false;
            }
            if (child2 >= array.length) {
                return true;
            } else if (array[index] > array[child2]) {
                return false;
            }
        }
        return true;
    }

}
