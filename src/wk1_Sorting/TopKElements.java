package wk1_Sorting;

import java.util.Arrays;
import java.util.Objects;
import java.util.TreeSet;

public class TopKElements {
    public static void main(String[] args) {

        int[] data = {1, 5, 4, 2};

//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(getTopKElements(data, 2)) + (char) 27 + "[0m");


//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(simpleTopKNums(data, 2)) + (char) 27 + "[0m");

        int[] result = topkNums(data, 2);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(result) + (char) 27 + "[0m");

    }

    public static int[] simpleTopKNums(int[] arr, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer num : arr) {
            set.add(num);

            if (set.size() > k) {
                set.pollFirst();
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getTopKElements(int[] arr, int numOfTopElements) {
        /**
         * time: O(n*log(k))
         * space: O(k) */
        TreeSet<Node> tree = new TreeSet<>();

        for (int num : arr) {// O(n^1)
            tree.add(new Node(num));

            if (tree.size() > numOfTopElements) {
                int x = Objects.requireNonNull(tree.pollFirst(), "tree element failed").data;//O(n log n)
            }
        }

        int[] topNums = tree.stream().mapToInt((node) -> node.data).toArray();
        return topNums;
    }


    public static class Node implements Comparable<Node> {
        int data;

        Node(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.data, node.data);
        }

    }


    /* updated 03/2020 */
    static int[] topkNums(int[] arr, int k) {
        TreeSet<Integer> que = new TreeSet<>((o1, o2) -> o1 - o2);
        Arrays.sort(arr);

        for (Integer i : arr) {
            que.add(i);

            if (que.size() > k) {
                que.pollFirst();
            }
        }

        return que.stream().mapToInt(i -> i).toArray();
    }
}
