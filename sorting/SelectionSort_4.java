package sorting;

/*
Given an array, sort the elements in the array in ascending order.
The selection sort algorithm should be used to solve this problem.
 */

public class SelectionSort_4 {
    public int[] selectionSort(int[] array) {
        //corner case:
        if (array == null || array.length <= 1) {
            return array;
        }
        //general case:
        for (int i = 0; i < array.length - 1; i++) {
            //find the min in the array in the range of [i, array.length - 1]
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    time complexity: O(n^2)
//    space complexity: O(1)

}
