package wk2_Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensIKWeb {
    public static void main(String[] args) {
        int n = 4;
        String[][] ikweb = find_all_arrangements(4);

        for (String[] arr : ikweb) {
            System.out.println((char) 27 + "[97;43m" + Arrays.toString(arr) + (char) 27 + "[0m");
        }
    }

    public static String[][] find_all_arrangements(int n) {
        /* TODO: 12/9/19, stephen; build out vectors */
        List<String[]> res = new ArrayList<String[]>();
        boolean[] cols = new boolean[n];
        boolean[] forwardDiagonals = new boolean[2 * n - 1];
        boolean[] backwardDiagonals = new boolean[2 * n - 1];

        /* TODO: 12/9/19, stephen; place queens */
        helper(res, new int[n], 0, cols, forwardDiagonals, backwardDiagonals);

        return res.toArray(new String[0][0]);
    }

    private static void helper(List<String[]> res,
                               int[] board,
                               int row, // 0
                               boolean[] cols, //[bool,bool,bool,bool]
                               boolean[] forwardDiagonals,
                               boolean[] backwardDiagonals) {

        if (row == board.length) {
            /* build board with 'q' '-' */
            String[] arrangement = new String[board.length];
            for (int i = 0; i < board.length; i++) {
                arrangement[i] = rowToString(board, i);
            }
            res.add(arrangement);
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col, cols, forwardDiagonals, backwardDiagonals)) {
                board[row] = col;

                cols[col] = true;
                forwardDiagonals[row + col] = true;//'q' at 0,0
                backwardDiagonals[row - col + board.length - 1] = true;//'q' at 0,3

                helper(res, board, row + 1, cols, forwardDiagonals, backwardDiagonals);

                cols[col] = false;
                forwardDiagonals[row + col] = false;
                backwardDiagonals[row - col + board.length - 1] = false;
            }
        }
    }

    private static boolean isSafe(int[] board, int row, int col, boolean[] cols, boolean[] forwardDiagonals, boolean[] backwardDiagonals) {
        if (cols[col]) {
            return false;
        }

        if (forwardDiagonals[row + col]) {
            return false;
        }

        if (backwardDiagonals[row - col + board.length - 1]) {
            return false;
        }

        return true;
    }

    private static boolean isSafe2(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col) {
                return false;
            }

            if (Math.abs(((double) row - i) / (col - board[i])) == 1.0) {
                return false;
            }
        }
        return true;
    }

    private static String rowToString(int[] board, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            if (board[row] == i) {
                sb.append('q');
            } else {
                sb.append('-');
            }
        }
        return sb.toString();

    }
}
