package wk3_Trees;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class LCA {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node a = new Node(2);
        Node b = new Node(3);
//        System.out.println((char) 27 + "[97;43m" + lca(root, a, b) + (char) 27 + "[0m");

        Node answer = lcaLoop(root, a, b);
        System.out.println((char)27 + "[97;43m"+ answer.data  +(char)27+"[0m");

    }

    static int lca(Node head, Node a, Node b) {
        if (head == null) return 0;

        if (head.data == a.data || head.data == b.data) return head.data;

        int left = lca(head.left, a, b);
        int right = lca(head.right, a, b);

        if (left == 0) return right;
        if (right == 0) return left;
        return head.data;

//        if (left > 0 && right > 0) {
        /*lca found*/
//            return head.data;
//        }
//        return right <= 0 ? left : right;
//        return left > 0 ? left : right;

    }

    static int lcaNode;
    static Queue<Node> que = new LinkedList<>();// fifo
    static Queue<Node> lcaCandidates = new LinkedList<>();// fifo

    static Node lcaLoop(Node head, Node a, Node b) {
        // post-order
        // short circuit
        while (head != null)
        {
            // If both n1 and n2 are smaller
            // than root, then LCA lies in left
            if (head.data > a.data &&
                    head.data > b.data)
                head = head.left;

                // If both n1 and n2 are greater
                // than root, then LCA lies in right
            else if (head.data < a.data &&
                    head.data < b.data)
                head = head.right;

            else break;
        }
        return head;
    }

    static void lcaLoopHelpr(Node head, Node a, Node b) {

    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}
