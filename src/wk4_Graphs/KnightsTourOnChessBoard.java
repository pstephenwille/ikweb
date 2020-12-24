package wk4_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightsTourOnChessBoard {
    public static void main(String[] args) {
        int answer = find_minimum_number_of_moves(
                5,
                5,
                0,
                0,
                4,
                1);

        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");
    }

    static boolean[][] board;
    static Queue<Knight> que = new LinkedList<>();
    static int maxRows, maxCols;

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        maxRows = rows;
        maxCols = cols;
        board = new boolean[cols][rows];
        que.add(new Knight(start_col, start_row, 0));

        while (!que.isEmpty()) {
            Knight knight = que.remove();
            if (knight.col == end_col && knight.row == end_row) {
                return knight.depth;
            }

            makePossibleKnightMoves(que, knight);
        }
        return -1;
    }

    static void makePossibleKnightMoves(Queue<Knight> que, Knight knight) {
        int row = knight.row;
        int col = knight.col;
        int numMoves = knight.depth;

        if (col + 1 < maxCols && row + 2 < maxRows && !board[col + 1][row + 2]) {
            board[col + 1][row + 2] = true;
            que.add(new Knight(col + 1, row + 2, numMoves + 1));
        }
        if (col + 1 < maxCols && row - 2 >= 0 && !board[col + 1][row - 2]) {
            board[col + 1][row - 2] = true;
            que.add(new Knight(col + 1, row - 2, numMoves + 1));
        }
        if (col + 2 < maxCols && row + 1 < maxRows && !board[col + 2][row + 1]) {
            board[col + 2][row + 1] = true;
            que.add(new Knight(col + 2, row + 1, numMoves + 1));
        }
        if (col + 2 < maxCols && row - 1 >= 0 && !board[col + 2][row - 1]) {
            board[col + 2][row - 1] = true;
            que.add(new Knight(col + 2, row - 1, numMoves + 1));
        }
        if (col - 1 >= 0 && row + 2 < maxRows && !board[col - 1][row + 2]) {
            board[col - 1][row + 2] = true;
            que.add(new Knight(col - 1, row + 2, numMoves + 1));
        }
        if (col - 1 >= 0 && row - 2 >= 0 && !board[col - 1][row - 2]) {
            board[col - 1][row - 2] = true;
            que.add(new Knight(col - 1, row - 2, numMoves + 1));
        }
        if (col - 2 >= 0 && row + 1 < maxRows && !board[col - 2][row + 1]) {
            board[col - 2][row + 1] = true;
            que.add(new Knight(col - 2, row + 1, numMoves + 1));
        }
        if (col - 2 >= 0 && row - 1 >= 0 && !board[col - 2][row - 1]) {
            board[col - 2][row - 1] = true;
            que.add(new Knight(col - 2, row - 1, numMoves + 1));
        }
    }


    static class Knight {
        int row;
        int col;
        int depth;

        Knight(int x, int y, int d) {
            col = x;
            row = y;
            depth = d;
        }
    }

}
