package wk4_Graphs;

import java.util.ArrayList;
import java.util.List;
/* DFS */
public class ZombieCluster {
    public static void main(String[] args) {
        /**
         * 4
         * 1100
         * 1110
         * 0110
         * 0001
         * */

        List<String> input = new ArrayList<>();
        input.add("1100");
        input.add("1110");
        input.add("0110");
        input.add("0001");
        int answer = zombieCluster(input);

        System.out.println((char) 27 + "[97;43m" + answer + (char) 27 + "[0m");
    }

    static boolean[] visited;

    public static int zombieCluster(List<String> allZombies) {
        int connectedComponents = 0;
        visited = new boolean[allZombies.size()];

        for (int zombie = 0; zombie < allZombies.size(); zombie++) {
            if (!visited[zombie]) {
                dfs(allZombies, zombie);
                connectedComponents++;
            }
        }
        return connectedComponents;
    }

    public static void dfs(List<String> allZombies, int zombie) {
        visited[zombie] = true;
        for (int friend = 0; friend < allZombies.size(); friend++) {
            boolean zombieHasMetFriend = allZombies.get(zombie).charAt(friend) == '1';

            if (zombieHasMetFriend && !visited[friend]) {
                //get friend and see who he's met
                dfs(allZombies, friend);
            }
        }
    }


}
