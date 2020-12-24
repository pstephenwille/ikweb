package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        String[][] resp = find_all_arrangements(n);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(resp) + (char) 27 + "[0m");
    }

    static boolean[][] board;
    static List<String[]> list = new ArrayList<>();

    static String[][] find_all_arrangements(int n) {
        /*
         * check isSafeLocation()
         * record 'q' location
         * */
        board = new boolean[n][n];

        placeQueens(0);

        return list.toArray(new String[0][0]);
    }

    static void placeQueens(int row) {
        /*
         * basecase; row == board.length
         *   we've tried to populate entire board
         *
         * loop columns
         *   check isSafe
         *       set q on board
         *       recurse incrementing row
         *       unset q on board for following stack frames
         * */

        if (row == board.length) {
            list.add(printBoard());
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(row, col)) {
                board[row][col] = true;

                placeQueens(row + 1);

                board[row][col] = false;
            }
        }
    }


    static boolean isSafe(int row, int col) {
        /*
         * take in board, row, col
         * copy row/col to index and loop with
         * loop over board
         * check diagL, diagR, col
         * */

        //backSlash \
        int _row = row;
        int _col = col;
        while (_row >= 0 && _col >= 0) {
            if (board[_row--][_col--]) {
                return false;
            }
        }

        //forwardSlash /
        _row = row;
        _col = col;
        while (_row >= 0 && _col < board.length) {
            if (board[_row--][_col++]) {
                return false;
            }
        }

        //col
        _row = row;
        _col = col;
        while (_row >= 0) {
            if (board[_row--][_col]) {
                return false;
            }
        }

        return true;
    }

    static String[] printBoard() {
        String[] boardStr = new String[board.length];

        for (int r = 0; r < boardStr.length; r++) {
            String rowStr = "";
            for (boolean col : board[r]) {
                rowStr += (col) ? "q" : "-";
            }
            boardStr[r] = rowStr;
        }

        return boardStr;
    }
}
