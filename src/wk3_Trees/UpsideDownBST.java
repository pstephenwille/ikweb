package wk3_Trees;

public class UpsideDownBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);

        root.left_ptr.left_ptr = new TreeNode(4);
        root.left_ptr.right_ptr = new TreeNode(5);

//        root.left_ptr.right_ptr.left_ptr = new TreeNode(8);
//        root.left_ptr.right_ptr.right_ptr = new TreeNode(9);
//
//        root.right_ptr.left_ptr = new TreeNode(6);
//        root.right_ptr.right_ptr = new TreeNode(7);


        TreeNode newRoot = flipUpsideDown(root);

    }


    static TreeNode flipUpsideDown(TreeNode root) {

        if (root == null || root.left_ptr == null) {
            return root;
        }

        TreeNode nextRoot = root.left_ptr;
        TreeNode newRightNode = root.right_ptr;

        TreeNode finalRoot = flipUpsideDown(nextRoot);

        nextRoot.left_ptr = newRightNode;
        nextRoot.right_ptr = root;
        root.left_ptr = null;
        root.right_ptr = null;

        return finalRoot;

    }

    private static class TreeNode {
        public int val;
        public TreeNode left_ptr;
        public TreeNode right_ptr;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
