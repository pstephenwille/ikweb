package wk3_Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge2BSTs {
    public static void main(String[] args) {
        Node root3 = new Node(6);
        root3.left = new Node(2);
        root3.right = new Node(7);
        root3.left.left = new Node(1);
        root3.left.right = new Node(3);
        root3.right.right = new Node(8);

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);

        Node root2 = new Node(7);
        root2.left = new Node(6);
        root2.right = new Node(8);

        Result.mergeTwoBSTs(root1, root2);


    }


    static class Result {

        public static Node mergeTwoBSTs(Node root1, Node root2) {
            /**
             * in-order loop over nodes to build sorted lists
             * merge lists by recursively looping through lists
             *  split from left;0-mid, right; mid - end
             *  building node.left and right
             * */
            List<Node> list = new ArrayList<>();
            inOrder(root1, list);
            inOrder(root2, list);
            list.sort(Comparator.comparingInt(o -> o.key));

            Node newTree = createBst(0, list.size() - 1, list);

            return newTree;
        }

        /**
         * get larger of list1[end] or list2[0] for first node
         * left = list[end -1]
         * right = list2[i]
         */
        public static Node createBst(int startIndex, int endIndex, List<Node> list) {
            //pre-order
            if (startIndex > endIndex) {
                return null;
            }
            int mid = startIndex + (endIndex - startIndex) / 2;

            Node root = list.get(mid);
            root.left = createBst(startIndex, mid - 1, list);
            root.right = createBst(mid + 1, endIndex, list);

            return root;
        }

        public static List<Node> inOrder(Node root, List<Node> list) {
            if (root == null) {
                return null;
            }

            inOrder(root.left, list);
            list.add(root);
            inOrder(root.right, list);

            return list;
        }
    }

    private static class Node {
        int key;
        Node left = null;
        Node right = null;

        Node(int k) {
            key = k;
        }
    }
}
