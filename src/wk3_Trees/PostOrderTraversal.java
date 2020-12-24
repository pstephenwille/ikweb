package wk3_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
/**
 5
 1 2 3 4 5
 0
 4
 0 1 L
 0 2 R
 1 3 L
 1 4 R

 out; 4 5 2 3 1
 * */
        TreeNode root = new TreeNode(1, 1);
        root.left_ptr = new TreeNode(2, 2);
        root.left_ptr.left_ptr = new TreeNode(4, 4);
        root.left_ptr.right_ptr = new TreeNode(5, 5);
        root.right_ptr = new TreeNode(3, 3);


        postOrder(root);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(nodeValues.toArray()) + (char) 27 + "[0m");
    }

    static List<Integer> nodeValues = new ArrayList<>();

    static int[] postorderTraversal(TreeNode root) {
        // DFS(root);

        return nodeValues.stream().mapToInt(Integer::intValue).toArray();
    }


    static Stack<TreeNode> postResults = new Stack<>();

    static void postOrder(TreeNode root) {
        /* 4, 5, 2, 3, 1*/
        /* lifo */
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


    static class TreeNode {
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
