package wk4_Graphs;

import java.util.*;

public class BFSPractice {

    public static void main(String[] args) {
        int[][] graphA = {{1, 2}, {3}, {3}, {}};

        List result = bfsPaths(graphA);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(result.toArray()) + (char) 27 + "[0m");

    }

    public static List bfsPaths(int[][] graph) {
        Queue<Integer> que = new LinkedList<>();
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        que.add(0);

        while (que.size() > 0) {
            int currentNode = que.poll();
            int[] neighbors = graph[currentNode];

            if (paths.isEmpty()) {
                for (int neighbor : neighbors) {
                    paths.add(new ArrayList<>() {{
                        add(currentNode);
                    }});
                }
            }
            for (int neighbor : neighbors) {
                if (visited.contains(neighbor)) {

                } else {
                    que.add(neighbor);
                    visited.add(currentNode);
                }

                for (List<Integer> path : paths) {
                    if (path.contains(currentNode)) {
                        path.add(neighbor);
                    }
                }
            }
        }

        return paths;
    }
}
