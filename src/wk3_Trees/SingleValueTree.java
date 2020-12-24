package wk3_Trees;

class SingleValueTree {
    public static void main(String[] args) {
        /** input
         7
         5 5 5 5 5 4 5
         0
         6
         0 1 L
         0 2 R
         1 3 L
         1 4 R
         2 5 L
         2 6 R

         out; 5
         * */
        TreeNode root = new TreeNode(5, 0);
        root.left_ptr = new TreeNode(5, 1);
        root.right_ptr = new TreeNode(5, 2);
        root.left_ptr.left_ptr = new TreeNode(5, 3);
        root.left_ptr.right_ptr = new TreeNode(5, 4);
        root.right_ptr.left_ptr = new TreeNode(5, 5);
//        root.right_ptr.right_ptr = new TreeNode(5, 6);

//        findSingleValueTrees(root);
//        System.out.println((char) 27 + "[97;43m" + count + (char) 27 + "[0m");
        isLeafAndCountSVTrees(root);

        System.out.println((char) 27 + "[97;43m" + count + (char) 27 + "[0m");

    }

    static int count = 0;

    static int findSingleValueTrees(TreeNode root) {
        countSVT(root);

        return count;
    }


    static boolean countSVT(TreeNode root) {
        if (root == null) return true;

        /* check for leaf node */
        if (root.left_ptr == null && root.right_ptr == null) {
            count++;
            return true;
        }

        boolean leftLeafNode = countSVT(root.left_ptr);
        boolean rightLeafNode = countSVT(root.right_ptr);

        /* is not a leaf; check for same value on left, right nodes */
        if (!leftLeafNode || root.left_ptr != null && (root.left_ptr.val != root.val)) return false;

        if (!rightLeafNode || root.right_ptr != null && (root.right_ptr.val != root.val)) return false;

        count++;

        return true;

    }

    static class Counter {
        int count = 0;
    }

    static boolean isLeafAndCountSVTrees(TreeNode root) {
        if (root == null) {
            return true;
        }


        boolean isLeftLeaf = isLeafAndCountSVTrees(root.left_ptr);
        boolean isRightLeaf = isLeafAndCountSVTrees(root.right_ptr);

        if (root.left_ptr == null && root.right_ptr == null) {
            count++;
            return true;
        }

        if (!isLeftLeaf || root.left_ptr != null && root.left_ptr.val != root.val) return false;
        if (!isRightLeaf || root.right_ptr != null && root.right_ptr.val != root.val) return false;

        count++;
        return true;
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
