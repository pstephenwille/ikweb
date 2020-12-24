package wk4_Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnections {
    public static void main(String[] args) {
        /**
         4
         4
         0 1
         1 2
         2 0
         1 3

         out; 1,3
         **/

        int numServers = 4;
        int numConnects = 4;
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> connect = new ArrayList<>();
        connect.add(4);
        connect.add(0);
        List<Integer> connect1 = new ArrayList<>();
        connect1.add(0);
        connect1.add(1);
        List<Integer> connect2 = new ArrayList<>();
        connect2.add(1);
        connect2.add(4);
        List<Integer> connect3 = new ArrayList<>();
        connect3.add(3);
        connect3.add(2);
        connections.add(connect);
        connections.add(connect1);
        connections.add(connect2);
        connections.add(connect3);

        Result.findCriticalConnections(numServers, numConnects, connections);
    }

    private static List<Integer> adj[];


    static class Result {

        static List<List<Integer>> connections;
        static Map<Integer, List<Integer>> adjList = new HashMap<>();
        static int numServers;
        static int numConnects;
        static int[] visited;

        public static List<List<Integer>> findCriticalConnections(int noOfServers, int noOfConnections, List<List<Integer>> c) {
            numServers = noOfServers;
            numConnects = noOfConnections;
            connections = c;
            visited = new int[numServers];
            // Write your code here
            buildAdjListUtil();

            for (int i = 0; i < numServers; i++) {
                if (visited[i] == 0) {
                    countConnectsDFS(i);
                }
            }

            return connections;
        }


        static void countConnectsDFS(int node) {
            visited[node]++;

            List<Integer> server = adjList.get(node);

        }

        static void buildAdjListUtil() {
            for (List<Integer> server : connections) {
                int key = server.get(0);
                adjList.computeIfAbsent(
                        key,
                        v -> new ArrayList<>()
                ).add(server.get(1));

            }
        }
    }

}
