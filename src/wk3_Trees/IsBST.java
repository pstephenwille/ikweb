package wk3_Trees;

public class IsBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(300, 0);
        root.left_ptr = new TreeNode(200, 1);
        root.right_ptr = new TreeNode(400, 2);
        root.left_ptr.left_ptr = new TreeNode(100, 3);
        root.left_ptr.right_ptr = new TreeNode(250, 4);
        root.left_ptr.right_ptr.left_ptr = new TreeNode(225, 4);
        root.left_ptr.right_ptr.right_ptr = new TreeNode(275, 4);

        System.out.println((char) 27 + "[97;43m" + isBST(root) + (char) 27 + "[0m");
    }

    static boolean isBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        return checkIsBST(root, min, max);
    }

    static boolean checkIsBST(TreeNode root, int min, int max) {
        if (root == null) return true;

        //        assert root.left_ptr != null;
        if (root.val > max || root.val < min) return false;

//        assert root.right_ptr != null;
//        if (root.val < min) return false;
//

        return checkIsBST(root.left_ptr, min, root.val) && checkIsBST(root.right_ptr, root.val, max);
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
