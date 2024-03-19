package dfs;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII_234 {
    public int nQueens(int n) {
        // assume n > 0
        int[] result = new int[1];
        // element in columns represents queen's column, index represents queen's row
        int[] columns = new int[n];
        boolean[] usedColumns = new boolean[n];
        // diagonals with slope of 1
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        // diagonals with slope of -1
        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
        helper(0, result, columns, usedColumns, usedDiagonals, usedRevDiagonals);
        return result[0];
    }
    // for each queen, determine i's position
    private void helper(int row, int[] result, int[] columns, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        // terminal condition: we have determined all n queens' position
        if (row == columns.length) {
            result[0]++;
            return;
        }
        // determine current queen's column position
        for (int column = 0; column < columns.length; column++) {
            if(valid(row, column, usedColumns, usedDiagonals, usedRevDiagonals)) {
                markAsUsed(row, column, columns, usedColumns, usedDiagonals, usedRevDiagonals);
                helper(row + 1, result, columns, usedColumns, usedDiagonals, usedRevDiagonals);
                markAsUnused(row, column, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }

    // check if current queen's locate is valid
    private boolean valid(int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        return !usedColumns[column] && !usedDiagonals[row - column + usedColumns.length - 1] && !usedRevDiagonals[row + column];
    }

    private void markAsUsed(int row, int column, int[] columns, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        columns[row] = column;
        usedColumns[column] = true;
        usedDiagonals[row - column + usedColumns.length - 1] = true;
        usedRevDiagonals[row + column] = true;
    }

    private void markAsUnused(int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        usedColumns[column] = false;
        usedDiagonals[row - column + usedColumns.length - 1] = false;
        usedRevDiagonals[row + column] = false;
    }


}
