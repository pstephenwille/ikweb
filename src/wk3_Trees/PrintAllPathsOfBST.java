package wk3_Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintAllPathsOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, 1);
        root.left_ptr = new TreeNode(20, 2);
        root.left_ptr.left_ptr = new TreeNode(40, 4);
        root.left_ptr.right_ptr = new TreeNode(50, 5);
        root.right_ptr = new TreeNode(30, 3);

//        List<List<Integer>> answer = allPathsOfABinaryTree(root);

        getAllPaths(root, list, paths);

        System.out.println((char) 27 + "[97;43m" + Arrays.toString(paths.toArray()) + (char) 27 + "[0m");
    }

    static List<List<Integer>> allPathsOfABinaryTree(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (root == null)
            return results;

        allPathsOfABinaryTreeRec(root, new ArrayList<Integer>(), results);
        return results;
    }

    static void allPathsOfABinaryTreeRec(TreeNode root, List<Integer> list, List<List<Integer>> results) {
        if (root.left_ptr == null && root.right_ptr == null) {
            list.add(root.val);
            results.add(list);
            return;
        }

        List<Integer> leftList = new ArrayList<>(list);
        leftList.add(root.val);

        List<Integer> rightList = new ArrayList<>(list);
        rightList.add(root.val);

        if (root.left_ptr != null)
            allPathsOfABinaryTreeRec(root.left_ptr, leftList, results);

        if (root.right_ptr != null)
            allPathsOfABinaryTreeRec(root.right_ptr, rightList, results);

    }

    static List<List<Integer>> paths = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    static void getAllPaths(TreeNode root, List<Integer> list, List<List<Integer>> paths) {
        //pre-order
        if (root == null) return;

        if (root.left_ptr == null && root.right_ptr == null) {
            list.add(root.val);
            paths.add(list);
            return;
        }

        List<Integer> leftList = new ArrayList(list);
        leftList.add(root.val);

        List<Integer> rightList = new ArrayList(list);
        rightList.add(root.val);

        getAllPaths(root.left_ptr, leftList, paths);
        getAllPaths(root.right_ptr, rightList, paths);

    }


    private static class TreeNode {
        int val;
        int index;
        TreeNode left_ptr;
        TreeNode right_ptr;

        TreeNode(int val, int index) {
            this.val = val;
            this.index = index;
        }

    }
}
