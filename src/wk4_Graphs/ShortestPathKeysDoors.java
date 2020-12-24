package wk4_Graphs;

import java.util.*;

public class ShortestPathKeysDoors {

    public static void main(String[] args) {
/*
* 3
...B
.b#.
@#+.
* */

        int rows = 3;
        String[] grid = new String[]{"...B", ".b#.", "@#+."};

        int[][] result = find_shortest_path(grid);

        for (int i = 0; i < result.length; i++) {
            System.out.println((char) 27 + "[97;43m" + Arrays.toString(result[i]) + (char) 27 + "[0m");
        }
    }


    static char[][] matrix;
    static List<int[]> paths = new ArrayList<int[]>();

    static int[][] find_shortest_path(String[] grid) {
        if (grid == null) return new int[1][1];

        Position start = createGridAndReturnStart(grid);

        bfs(start);

        if (paths.size() == 0) return new int[0][0];

        Collections.reverse(paths);

        return paths.toArray(new int[paths.size() - 1][]);
    }

    static void bfs(Position start) {
        Deque<Position> q = new ArrayDeque<>();
        q.addLast(start);

        int[] rowMoves = new int[]{-1, 1, 0, 0};
        int[] colMoves = new int[]{0, 0, -1, 1};

        boolean[][][] visited = new boolean[matrix.length][matrix[0].length][1024];
        // this is 0000000000 (10) every other 1 bit shift reps that letter a-j
        visited[start.row][start.col][0] = true;

        while (!q.isEmpty()) {
            Position popped = q.removeFirst();
            char currChar = matrix[popped.row][popped.col];

            // this path is longer than the one we've already found but we only care about shortest
            if (paths.size() != 0 && paths.size() <= popped.depth) {
                continue;
            }

            // check if its the end
            if (currChar == '+') {
                // first path reached || found a shorter path than the last found one so update
                if (paths.size() == 0 || paths.size() > popped.depth) {
                    // clear the old one
                    paths.clear();
                    while (popped != null) {
                        paths.add(new int[]{popped.row, popped.col});
                        popped = popped.parent;
                    }
                    continue;
                }
            }

            //check the neighbors
            for (int i = 0; i < rowMoves.length; i++) {
                int neighborRow = popped.row + rowMoves[i];
                int neighborCol = popped.col + colMoves[i];

                // if this neighbor position is off the grid, cant go there
                if (!isOnGrid(neighborRow, neighborCol)) {
                    continue;
                }

                // safe to get a value on the grid
                char neighborValue = matrix[neighborRow][neighborCol];

                // neighbor is water, can't go there
                if (neighborValue == '#') {
                    continue;
                }

                // if this neighbor is a door we can only enter it if we have the key
                if (isDoor(neighborValue)) {
                    // key is not fount, 1 left-shit of popped
                    if ((popped.key & (1 << neighborValue - 'A')) == 0) {
                        continue;
                    }
                }

                Position neighbor = new Position(neighborRow, neighborCol, popped.depth + 1);
                neighbor.key = popped.key;

                // if this is a key, add it to the key ring
                if (isKey(neighborValue)) {
                    neighbor.key = popped.key | (1 << neighborValue - 'a');
                }

                // for path recontruction purposes
                neighbor.parent = popped;

                // only if we havent been to this position with this particular key ring
                if (!visited[neighborRow][neighborCol][neighbor.key]) {
                    // remember it
                    visited[neighborRow][neighborCol][neighbor.key] = true;
                    // add it to the bfs queue
                    q.addLast(neighbor);
                }
            }
        }
    }

    static Position createGridAndReturnStart(String[] grid) {
        matrix = new char[grid.length][grid[0].length()];
        Position startPosition = null;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '@') {
                    startPosition = new Position(i, j, 0, 0);
                }
                matrix[i][j] = grid[i].charAt(j);
            }
        }

        return startPosition;
    }

    static boolean isOnGrid(int r, int c) {
        return r >= 0 && c >= 0 && r < matrix.length && c < matrix[0].length;
    }

    static boolean isKey(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    static boolean isDoor(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    static class Position {
        int row;
        int col;
        int depth;
        int key;
        Position parent;

        public Position(int r, int c, int d, int k) {
            row = r;
            col = c;
            depth = d;
            key = k;
        }

        public Position(int r, int c, int d) {
            row = r;
            col = c;
            depth = d;
        }
    }
}
