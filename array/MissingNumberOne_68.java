package array;

/**
 * Given an integer array of size N - 1,
 * containing all the numbers from 1 to N except one,
 * find the missing number.
 */
public class MissingNumberOne_68 {
    public int findOneMissing(int[] array) {
        // assume array is not null
        // index of exist represents a integer with value of index,
        // if exist[index] is 0, it means the number index does not exist
        //  if exist[index] is 0, it means the number index exists
        int[] exist = new int[array.length + 2];
        // step 1: iterate over all numbers in array and update exist[number]
        for (int number : array) {
            exist[number] = 1;
        }
        // step 2: iterate over all elements in exist from the index 1, find exist[number] whose value is 0
        for (int number = 1; number < exist.length; number++) {
            if (exist[number] == 0) {
                return number;
            }
        }
        return 1;
    }

}
