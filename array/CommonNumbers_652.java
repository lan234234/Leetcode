package array;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbers_652 {
    /**
     * method 1: two pointer
     */
    public List<Integer> commonNumbers(int[] one, int[] two) {
        // assume one and two are not null
        List<Integer> result = new ArrayList<>();
        int i = 0;	// used for traversing one
        int j = 0;	// used for traversing two
        while (i < one.length && j < two.length) {
            if (one[i] == two[j]) {
                result.add(one[i]);
                i++;
                j++;
            } else if (one[i] < two[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
    // TC: O(m + n)
    // SC: O(1)
    /**
     * method 2: binary search
     */
    public List<Integer> commonNumbers2(int[] one, int[] two) {
        // assume one and two are not null
        List<Integer> result = new ArrayList<>();
        int[] moreNumber = one.length > two.length ? one : two;
        int[] lessNumber = one.length > two.length ? two : one;
        // search each number of lessNumber in moreNumber
        // startSearchIndex: the start index for searching
        int startSearchIndex = 0;
        for (int number : lessNumber) {
            // when the number is larger than the largest number in moreNumber, terminate the loop
            if (startSearchIndex >= moreNumber.length) {
                break;
            }
            // search number in moreNumber start from the index of startSearchIndex
            int firstOccurance = firstOccurance(number, moreNumber, startSearchIndex);
            // if number is found in the certain range, update the result and statSearchIndex
            if (firstOccurance >= startSearchIndex) {
                result.add(number);
                startSearchIndex = firstOccurance + 1;
            }
        }
        return result;
    }
    // using binary search to find the first occurrence of the target in array
    private int firstOccurance(int target, int[] array, int left) {
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] == target ? left : -1;
    }
    // assume n is the length of array with more elements, m is the length of array with less elements
    // TC: O(mlogn)
    // SC: O(1)

}
