package sorting;

/*
Given an array of integers, sort the elements in the array in ascending order.
The quick sort algorithm should be used to solve this problem.
 */

public class QuickSort_10 {
    public int[] quickSort(int[] array) {
        //corner case:
        if (array == null || array.length == 0) {
            return array;
        }
        sort(array, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int left, int right) {
        //base case:
        if (left >= right) {
            return;
        }
        //choose a pivot
        //Math.random() --> random integer in [0, 1)
        //[left, right] --> left + [0, right - left] --> [0, right - left +1)
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        //partition
        swap(array, pivotIndex, right);
        //[left, i): element smaller than array[right]
        //(j, right]: element larger than array[right]
        int i = left;
        int j = right - 1;
        while (i != j + 1) {
            if (array[i] <= array[right]) {
                i++;
            } else if (array[j] > array[right]) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, right);
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /*
    time complexity:
    average case: O(nlogn)
    worst case: O(n^2)
    space complexity:
    average case: O(logn)
    worst case: O(n)
     */

}
