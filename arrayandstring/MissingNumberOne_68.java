package arrayandstring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array of size N - 1,
 * containing all the numbers from 1 to N except one,
 * find the missing number.
 */
public class MissingNumberOne_68 {
    /**
     * method 1: use int[] to track whether the number exists
     */
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
    /**
     * method 2: use hash set to store the numbers exist
     */
    public int findOneMissing2(int[] array) {
        // assume array is not null
        // set: store the numbers exist in array
        Set<Integer> set = new HashSet<>();
        // step 1: iterate over all numbers in array, and add them to set
        for (int number : array) {
            set.add(number);
        }
        // step 2: iterate over all numbers from 1 to array.length + 1, find the number that not exist in set
        for (int number = 1; number < array.length + 2; number++) {
            if (!set.contains(number)) {
                return number;
            }
        }
        return 1;
    }
    /**
     * bit operation
     */
    public int findOneMissing3(int[] array) {
        // assume array is not null
        int result = 0;
        // calculate XOR of all numbers in array
        for (int number : array) {
            result ^= number;
        }
        // continue to calculate XOR of number from 1 to array.length + 1
        // because n ^ n = 0, the calculation result is the missing number
        for(int number = 1; number <= array.length + 1; number++) {
            result ^= number;
        }
        return result;
    }

}
