package sorting;

/*
Given two sorted arrays, merge them into one sorted array.

assume:
array: int[]
	null ? empty ?

 */

public class Merge2SortedArray_547 {
    public int[] mergeSort(int[] one, int[] two) {
        if (one == null) {
            return two;
        }
        if (two == null) {
            return one;
        }
        int i = 0;
        int j = 0;
        int[] result = new int[one.length + two.length];
        int k = 0;
        while(i < one.length && j < two.length) {
            if (one[i] <= two[j]) {
                result[k++] = one[i++];
            } else {
                result[k++] = two[j++];
            }
        }
        if (i == one.length) {
            while (j < two.length) {
                result[k++] = two[j++];
            }
        } else {
            while (i < one.length) {
                result[k++] = one[i++];
            }
        }
        return result;
    }
/*
time complexity: O(n)
space complexity: O(1)
 */
}
