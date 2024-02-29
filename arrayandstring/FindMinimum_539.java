package arrayandstring;

/*
Given an array, return its minimum value
 */

public class FindMinimum_539 {
    public int findMinimum(int[] array) {
        //corner case:
        if (array == null || array.length == 0)
            return 0;
        //general case:
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            min = min > array[i] ? array[i] : min;
        }
        return min;
    }
}
