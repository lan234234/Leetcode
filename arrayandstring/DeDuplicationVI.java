package arrayandstring;

import java.util.Arrays;

public class DeDuplicationVI {
    public int[] deDuplications(int[] array) {
        // corner case:
        if (array == null || array.length <= 1) {
            return array;
        }
        // general case:
        int i = 0;
        int j = 0;
        while (j < array.length) {
            if (i == 0 || array[i - 1] != array[j]) {
                array[i++] = array[j++];
            } else {
                while (j < array.length && array[i - 1] == array[j]) {
                    j++;
                }
                if (j < array.length) {
                    array[i - 1] = array[j++];
                } else {
                    i--;
                }
            }
        }
        return Arrays.copyOf(array, i);
    }

}
