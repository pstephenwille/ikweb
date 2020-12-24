package wk3_Trees;

public class CircularDoublyLinkedList {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, 0);
        root.left_ptr = new TreeNode(2, 1);
        root.right_ptr = new TreeNode(5, 2);
        root.left_ptr.left_ptr = new TreeNode(1, 3);
        root.left_ptr.right_ptr = new TreeNode(3, 4);

        BTtoLL(root);
    }

    static TreeNode BTtoLL(TreeNode root) {
        if (root == null) {
            return root;
        }
        createDLL(root);

        head.left_ptr = prev;
        prev.right_ptr = head;

        return head;
    }

    static TreeNode head = null, prev = null;

    static void createDLL(TreeNode root) {
        if (root == null) {
            return;
        }

        createDLL(root.left_ptr);

        if (head == null) {
            head = root;
        } else {
            prev.right_ptr = root;
            root.left_ptr = prev;
        }
        prev = root;

        createDLL(root.right_ptr);
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
