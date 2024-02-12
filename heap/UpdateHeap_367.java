package heap;

public class UpdateHeap_367 {
    public int[] updateHeap(int[] array, int index, int ele) {
        if (array == null || array.length == 0 || index <0 || index >= array.length) {
            return array;
        }
        int temp = array[index];
        array[index] = ele;
        if (array[index] < temp) {
            percolateUp(array, index);
        }
        if (array[index] > temp) {
            percolateDown(array, index);
        }
        return array;
    }
    private void percolateUp(int[] array, int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(array, index, parent);
                index = parent;
            } else {
                return;
            }
        }
    }
    private void percolateDown(int[] array, int index) {
        //leftChild is valid, can not be index < (array.length - 1) / 2
        while (2 * index < array.length - 1) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int swapIndex = leftChild;
            if (rightChild < array.length && array[rightChild] < array[leftChild]) {
                swapIndex = rightChild;
            }
            if (array[swapIndex] < array[index]) {
                swap(array, index, swapIndex);
                index = swapIndex;
            } else {
                break;
            }
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
