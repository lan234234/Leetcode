package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class CountPairObtainedFromSwap {

    public int solution(int[] array) {
        // corner case:
        if (array.length == 1)	return 0;

        // general case:
        Map<String, Integer> map = new HashMap<>();
        String[] stringArr = toStringArray(array);
        int result = 0;
        for (String s : stringArr) {
            int count = map.getOrDefault(s, 0);
            if (count != 0) {
                result += count;
            }
            map.put(s, count + 1);
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length - 1; i++) {
                for (int j = i + 1; j < charArr.length; j++) {
                    if (charArr[i] != charArr[j]) {
                        swap(charArr, i, j);
                        count = map.getOrDefault(new String(charArr), 0);
                        if (count != 0) {
                            result += count;
                        }
                        swap(charArr, i, j);
                    }
                }
            }
        }
        return result;
    }
    private String[] toStringArray(int[] array) {
        String[] stringArr = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            stringArr[i] = array[i] + "";
        }
        return stringArr;
    }
    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
