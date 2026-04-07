class Solution {
    int N;
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        N = n;

        isValid(0, res, visited);
        return res;
    }

    private boolean isValid(int index, int[] res, boolean[] visited) {
        if (index == res.length)    return true;
        if (res[index] != 0)    return isValid(index + 1, res, visited);

        for (int i = N; i > 0 ; i--) {
            if (visited[i] || (i != 1 && (index + i >= res.length || res[index + i] != 0)))   continue;
            if (i != 1) {
                res[index + i] = i;
            }
            res[index] = i;
            visited[i] = true;
            if (isValid(index + 1, res, visited))   return true;
            if (i != 1) {
                res[index + i] = 0;
            }
            res[index] = 0;
            visited[i] = false;
        }
        return false;
    }
}