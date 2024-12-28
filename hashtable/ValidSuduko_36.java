package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSuduko_36 {
    /**
     * method 1: hashtable
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    List<int[]> list = map.get(board[i][j]);
                    if (list == null) {
                        list = new ArrayList<>();
                        list.add(new int[9]);
                        list.add(new int[9]);
                        list.add(new int[9]);
                        map.put(board[i][j], list);
                    }
                    if (list.get(0)[i] == 1 || list.get(1)[j] == 1) return false;
                    int subBox = i / 3 * 3 + j / 3;
                    if (list.get(2)[subBox] == 1)  return false;
                    list.get(0)[i]++;
                    list.get(1)[j]++;
                    list.get(2)[subBox]++;
                }
            }
        }
        return true;
    }

    /**
     * method 2: matrix replace hashtable
     */
    public boolean solution2(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] subBox = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int pos = board[i][j] - '1';
                // row
                if (row[i][pos] == 1)   return false;
                row[i][pos] = 1;
                // col
                if (col[pos][j] == 1)   return false;
                col[pos][j] = 1;
                // subBox
                int sub = i / 3 * 3 + j / 3;
                if (subBox[sub][pos] == 1)   return false;
                subBox[sub][pos] = 1;
            }
        }
        return true;
    }

    /**
     * method 3: bitmap
     */
    public boolean solution3(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] subBox = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int pos = board[i][j] - '1';
                int bitmask = 1 << pos;
                // row
                if ((row[i] & bitmask) > 0)   return false;
                row[i] = row[i] | bitmask;
                // col
                if ((col[j] & bitmask) > 0)   return false;
                col[j] = col[j] | bitmask;
                // subBox
                int sub = i / 3 * 3 + j / 3;
                if ((subBox[sub] & bitmask) > 0)   return false;
                subBox[sub] = subBox[sub] | bitmask;
            }
        }
        return true;
    }
}
