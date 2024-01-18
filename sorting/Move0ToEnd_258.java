package sorting;

/*
Given an array of integers, move all the 0s to the right end of the array.

assume:
if array == null or array.length == 0	return array;
input: int[]
output: int[]

 */

public class Move0ToEnd_258 {
    public int[] move0ToEnd(int[] array) {
        // corner case:
        if (array == null || array.length == 0) {
            return array;
        }
        // general case:
        // [0, i): elements not equal to 0
        // (j, array.length - 1]: elements equal to 0
        // [i, j]: not sorted
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (array[j] == 0) {
                j--;
            } else if (array[i] != 0) {
                i++;
            } else {
                swap(array, i++, j--);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
