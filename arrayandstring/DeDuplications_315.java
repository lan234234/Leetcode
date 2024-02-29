package arrayandstring;

import java.util.Arrays;

public class DeDuplications_315 {
    public int[] deDuplicationV(int[] array) {
        // corner case:
        if (array == null || array.length <= 2) {
            return array;
        }
// general case:
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (i == 0 || array[i - 1] != array[j]) {
                array[i++] = array[j++];
            } else {
                if (j < array.length && array[i - 1] == array[j]) {
                    j++;
                }
                array[i] = array[i - 1];
                i++;
            }
        }
        return Arrays.copyOf(array, i);
    }

}
