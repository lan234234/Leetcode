package heap;

public class OfferHeap_363 {
    public int[] offerHeap(int[] array, int ele) {
        // step 1: offer ele in the last cell
        int index = array.length - 1;
        array[index] = ele;
        // step 2: percolate up
        while (index > 0)  {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > ele) {
                swap(array, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
        return array;
    }

    public void swap(int[] array, int index, int parentIndex) {
        int temp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = temp;
    }

}
