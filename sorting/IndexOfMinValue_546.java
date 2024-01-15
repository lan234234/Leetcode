package sorting;

public class IndexOfMinValue_546 {
    public int indexOfMinValue(int[] array, int i) {
        int minIndex = i;
        while (i < array.length) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

//    time complexity: O(n)
//    space complexity: O(1)

}
