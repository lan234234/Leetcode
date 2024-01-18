package sorting;

/*
Given an array of balls, where the color of the balls can only be Red, Green or Blue,
sort the balls such that all the Red balls are grouped on the left side,
all the Green balls are grouped in the middle and
all the Blue balls are grouped on the right side.


assume:
(Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
input: int[] array only contain -1, 0, 1
	if array == null or array.length == 0	return array
output: int[] or void ?

sort: red, green , blue
        -1,..., 0,..., 1...

 */

public class RainbowSort_11 {
    public int[] rainbowSort(int[] array) {
        //corner case:
        if (array == null || array.length == 0) {
            return array;
        }
//general case:
//[0, i): elements equal to -1
//[i, j): elements equal to 0
//(k, array.length - 1]: elements equal to 1
//[j, k]: unsorted
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else if (array[j] == 1) {
                swap(array, j, k--);
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
