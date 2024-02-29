package array;

/*
Given an array, return sum of all elements.
 */

public class ComputeSum_540 {
    public int computeSum(int[] array) {
        //corner case:
        if (array == null || array.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
