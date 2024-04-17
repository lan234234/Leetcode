package dp;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from index i (you can only jump towards the end of the array).
 * Determine the minimum number of jumps you need to reach the end of array.
 * If you can not reach the end of the array, return -1.
 */
public class ArrayHopperII_89 {
    public int ArrayHopperII(int[] array) {
        // assume array is not null and empty
        // assume all elements in array are non-negative
        // minJump[i] represents the minimum number of jumps we need to reach the i
        int[] minJump = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            minJump[i] = -1;
            for (int j = 0; j < i; j++) {
                if (minJump[j] != -1 && j + array[j] >= i) {
                    if (minJump[i] != -1) {
                        minJump[i] = Math.min(minJump[j] + 1, minJump[i]);
                    } else {
                        minJump[i] = minJump[j] + 1;
                    }
                }
            }
        }
        return minJump[array.length - 1];
    }

}
