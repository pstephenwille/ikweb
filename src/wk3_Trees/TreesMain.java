package wk3_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TreesMain {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, 1);
        root.left_ptr = new TreeNode(2, 2);
        root.left_ptr.left_ptr = new TreeNode(1, 4);
        root.left_ptr.right_ptr = new TreeNode(3, 5);
        root.right_ptr = new TreeNode(5, 3);

//        int[] answer = postorderTraversal2(root);
//        System.out.println((char) 27 + "[97;43m" + Arrays.toString(answer) + (char) 27 + "[0m");

        preOrder(root);
        inOrder(root);
        postOrder(root);

        recursiveOrder(root);
        System.out.println((char) 27 + "[97;43m" + Arrays.toString(preList.toArray()) + (char) 27 + "[0m");

    }


    static List<TreeNode> recursiveOrderTree = new ArrayList<>();

    static void recursiveOrder(TreeNode node) {
        // pre-order; 4,2,1,3,5
        // in-order; 1,2,3,4,5
        // post-order 1,3,2,5,4
        if (node == null) {
            return;
        }

        recursiveOrderTree.add(node);

        recursiveOrder(node.left_ptr);

        recursiveOrder(node.right_ptr);
    }

    static List<TreeNode> preList = new ArrayList<>();

    static void preOrder(TreeNode root) {
        /* 1, 2, 4, 5, 3*/
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        Arrays.toString(preList.toArray());
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            preList.add(node);

            if (node.right_ptr != null) {
                stack.add(node.right_ptr);
            }

            if (node.left_ptr != null) {
                stack.add(node.left_ptr);
            }
        }
    }

    static List<Integer> inList = new ArrayList<>();

    static void inOrder(TreeNode root) {
        /* 4, 2, 5, 1, 3*/
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {//go to lowest node
            stack.add(node);
            node = node.left_ptr;
        }

        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            inList.add(n.val);

            n = n.right_ptr;
            while (n != null) {
                stack.add(n);
                n = n.left_ptr;
            }
        }


    }


    static Stack<TreeNode> postResults = new Stack<>();

    static void postOrder(TreeNode root) {
        /* 4, 5, 2, 3, 1*/
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postResults.add(node);

            if (node.left_ptr != null) {
                stack.push(node.left_ptr);
            }

            if (node.right_ptr != null) {
                stack.push(node.right_ptr);
            }

        }
    }


    private static class TreeNode {
        public int val;
        public int index;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        TreeNode(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
