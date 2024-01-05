package array;

public class InsertElementToArray {
    public int[] insertElementToArray(int[] array, int[] insertArray) {
        //corner case
        if (insertArray == null || insertArray.length < 2 || insertArray[1] < 0) return array;
        if (array == null) {
            if (insertArray[1] != 0) return array;
            return new int[]{insertArray[0]};
        }
        if (insertArray[1] > array.length) return array;
        //general case
        int[] result = new int[array.length + 1];
        for (int i = 0, j = 0; j < array.length + 1; j++) {
            if (j != insertArray[1]) {
                result[j] = array[i];
                i++;
            } else {
                result[j] = insertArray[0];
            }
        }
        return result;
    }
}
