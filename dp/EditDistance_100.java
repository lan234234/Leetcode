package dp;

/**
 * Given two strings of alphanumeric characters, determine the minimum number of Replace,
 * Delete, and Insert operations needed to transform one string into the other.
 */
public class EditDistance_100 {
    public int editDistance(String s1, String s2) {
        // assume s1 and s2 are not null
        // operations[i][j] represents the operation number needed to transform the s1.substring(0, i) to s2.substring(0, j)
        int[][] operations = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    operations[i][j] = j;
                } else if (j == 0) {
                    operations[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    operations[i][j] = operations[i - 1][j - 1];
                } else {
                    operations[i][j] = Math.min(Math.min(operations[i - 1][j], operations[i][j - 1]), operations[i - 1][j - 1]) + 1;
                }
            }
        }
        return operations[s1.length()][s2.length()];
    }
//    TC: O(n * m)
//    SC: O(n * m)
}
