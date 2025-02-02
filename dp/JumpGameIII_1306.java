package dp;

public class JumpGameIII_1306 {
    public boolean canReach(int[] arr, int start) {
        if (start >= arr.length || start < 0 || arr[start] < 0)   return false;
        if (arr[start] == 0)    return true;

        arr[start] = -arr[start];
        if (canReach(arr, start + arr[start]) || canReach(arr, start - arr[start])) return true;
        arr[start] = -arr[start];
        return false;
    }
}
