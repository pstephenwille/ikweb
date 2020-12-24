package wk4_Graphs;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        /**
         This is a typical topological sorting problem which can be solved using DFS.  A directed graph is formed using each prerequisite as an edge. Note that a possible ordering only exists if there is no cycle in the directed acyclic graph formed. To find cycle in a directed acyclic graph, we keep three visited states (0 for a node which has not been visited yet, 1 for those who are in current DFS stack and 2 for those whose all children are completely visited. The example will make it more clear, so let's dive into one.

         4
         4
         0 1
         0 3
         3 1
         3 2
         *
         * out:1,2,3,0
         *
         1 0
         2 0
         3 1
         3 2

         out: 0,1,2,3
         */
        List<List<Integer>> prereqs = new ArrayList<>();
        List<Integer> course1 = new ArrayList<>();
        List<Integer> course2 = new ArrayList<>();
        List<Integer> course3 = new ArrayList<>();
        List<Integer> course4 = new ArrayList<>();
        course1.add(0);
        course1.add(1);
        prereqs.add(course1);
        course2.add(0);
        course2.add(3);
        prereqs.add(course2);
        course3.add(3);
        course3.add(1);
        prereqs.add(course3);
        course4.add(3);
        course4.add(2);
        prereqs.add(course4);

        List answer = Result.course_schedule(4, prereqs);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(answer.toArray()) + (char) 27 + "[0m");
    }

    static class Result {
        static int[] visited;
        static List<Integer> answer = new ArrayList<>();
        static Map<Integer, List<Integer>> dependencyMap = new HashMap<>();

        static List<Integer> course_schedule(int numOfCourses, List<List<Integer>> prereqs) {
            visited = new int[numOfCourses];

            //build dependency map
            for (List<Integer> req : prereqs) {
                int course = req.get(0);
                int dependsOn = req.get(1);

                dependencyMap.computeIfAbsent(
                        course,
                        v -> new ArrayList<>()
                ).add(dependsOn);
            }

            for (int i = 0; i < numOfCourses; i++) {
                if (visited[i] == 0) {
                    https:

                    if (!dfs(i)) {
                        answer.clear();
                        answer.add(-1);
                        return answer;
                    }
                }
            }

            return answer;
        }

        static boolean dfs(int node) {
            visited[node] = 1;

            List<Integer> dependency = dependencyMap.get(node);

            if (dependency != null) {
                for (int n : dependency) {
                    if (visited[n] == 1) {
                        // cycle found
                        return false;
                    }

                    if (visited[n] == 0) {
                        if (!dfs(n)) {
                            // check for cycle with this node
                            return false;
                        }
                    }
                }
            }


            visited[node] = 2;
            answer.add(node);

            return true;
        }

    }


}
