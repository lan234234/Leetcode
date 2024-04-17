package dp;

/**
 * Given an array A of non-negative integers, you are initially positioned at index 0 of the array.
 * A[i] means the maximum jump distance from that position
 * (you can only jump towards the end of the array).
 * Determine if you are able to reach the last index.
 */
public class ArrayHopperI_88 {
    public boolean arrayHopperI(int[] array) {
        // assume array is null or empty
        // assume all elements in array are non-negative
        // reachable[i] means if we can reach the index i
        boolean[] reachable = new boolean[array.length];
        // base case:
        reachable[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (reachable[j] && j + array[j] >= i) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[array.length - 1];
    }

}
