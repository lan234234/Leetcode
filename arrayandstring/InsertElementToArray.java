package arrayandstring;

/*
given an array, and an element to insert, and the position to insert this element,
return a new array with the element inserted
* */

public class InsertElementToArray {

    public int[] insertElementToArray(int[] array, int[] element) {
        //corner case
        //1. element is invalid
        if (element == null || element.length != 2 || element[1] < 0)
            return array;
        //2. array is null or empty
        if (array == null || array.length == 0) {
            if (element[1] == 0)
                return new int[]{element[0]};
            return array;
        }
        //3. position is invalid
        if (array.length < element[1])
            return array;

        //general case
        int[] result = new int[array.length + 1];
        for (int i = 0, j = 0; j < result.length; j++) {
            if (j == element[1]) {
                result[j] = element[0];
            } else {
                result[j] = array[i];
                i++;
            }
        }
        return result;
    }

}
