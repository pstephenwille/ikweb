package wk4_Graphs;

import java.util.PriorityQueue;

public class KnightsTourOnChessBoardSwille {
    public static void main(String[] args) {
/**
 *
 * 5
 * 5
 * 0
 * 0
 * 4
 * 1
 *
 * out 3
 * */

        /*
         * [
         *   [00,01,02,03,04,05,06,07],
         *   [08,09,10,11,12,13,14,15]
         * ]
         *  05->01
         * */
        int answer = find_minimum_number_of_moves(
                5,
                5,
                0,
                0,
                4,
                1);

        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");
    }

    /*
     * Complete the function below.
     Knight obj; reach start from end position
     calc move against board

     */
    static int start_row, end_row, start_col, end_col, modulusNum, destinationSquare,
            beginSquare;
    static boolean[] visited;
    static PriorityQueue<Knight> que = new PriorityQueue<>((k1, k2) -> k1.numMoves - k2.numMoves);

    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col,
                                            int end_row, int end_col) {
        return 0;
    }


    static class Knight {
        int row, col;
        int numMoves;

        Knight(int row, int col, int moves) {
            row = row;
            col = col;
            numMoves = moves;
        }
    }


}
