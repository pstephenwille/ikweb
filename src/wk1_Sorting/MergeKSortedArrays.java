package wk1_Sorting;

import java.util.*;

public class MergeKSortedArrays {
    public static void main(String[] args) {

        int[][] data = {{1, 3, 5, 7}, {2, 4, 6, 8}, {0, 9, 10, 11}};
//        int[] result = mergeArrays(data);
//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(result) + (char) 27 + "[0m");

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(simpleMergeKSortedArrays(data)) + (char) 27 + "[0m");

    }

    public static int[] simpleMergeKSortedArrays(int[][] arr) {
        PriorityQueue<Integer> que;

        if (arr[0][0] < arr[0][arr[0].length - 1]) {
            que = new PriorityQueue<>();
        } else {
            que = new PriorityQueue<>(Collections.reverseOrder());
        }

        for (int i = 0; i < arr.length; i++) {
            for (int ii = 0; ii < arr[i].length; ii++) {
                que.add(arr[i][ii]);
            }
        }

        List<Integer> sortedInts = new ArrayList<>();
        while (que.size() > 0) {
            sortedInts.add(que.poll());
        }

        return sortedInts.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] mergeArrays(int[][] arr) {
        PriorityQueue<Integer> queue = makePriorityQueue(arr[0]);

        for (int j = 0; j < arr.length; j++) {
            for (int jj = 0; jj < arr[j].length; jj++) {
                System.out.println((char) 27 + "[97;43m" + "jj " + arr[j][jj] + (char) 27 + "[0m");
            }
        }
        int i = 0;
        while (i < arr.length) {
            for (int j = 0; j < arr[i].length; j++) {
                int data = arr[i][j];
                queue.add(data);
            }
            i++;
        }

        List<Integer> sortedInts = new ArrayList<>();
        while (queue.size() > 0) {
            sortedInts.add(queue.poll());
        }

        int[] ints = queue.stream().mapToInt(Integer::intValue).toArray();
        System.out.println((char) 27 + "[97;43m" + "ints " + Arrays.toString(ints) + (char) 27 + "[0m");

        int[] answer = sortedInts.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static PriorityQueue<Integer> makePriorityQueue(int[] arr) {
        System.out.println((char) 27 + "[97;43m" + "make queue " + arr[0] + "," + arr[arr.length - 1] + (char) 27 + "[0m");
        if (arr[0] < arr[arr.length - 1]) {
            return new PriorityQueue<Integer>();
        }

        return new PriorityQueue<>(Collections.reverseOrder());
    }

    public static class Node implements Comparable<Node> {
        int data;
        int left;
        int right;

        Node(int data) {
            this.data = data;
//            this.left = left;
//            this.right = right;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.data, o.data);
        }
    }

}
