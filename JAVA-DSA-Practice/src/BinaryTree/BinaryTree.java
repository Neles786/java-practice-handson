package BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }

    public void populate(Scanner sc) {
        System.out.println("Enter the root Node: ");
        int value = sc.nextInt();
        root = new Node(value);
        insertNodes(sc, root);
    }

    private void insertNodes(Scanner sc, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = sc.nextBoolean();
        if(left) {
            System.out.println("Enter the value of left child of " + node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            insertNodes(sc, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = sc.nextBoolean();
        if(right) {
            System.out.println("Enter the value of right child of " + node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            insertNodes(sc, node.right);
        }
    }

    public void display() {
//        display(root, "");
        prettyDisplay(root, 0);
    }

    private void display(Node node, String indent) {
        if(node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    private void prettyDisplay(Node node, int level) {
        if(node == null) return;
        prettyDisplay(node.right, level + 1);
        if(level > 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-----> " + node.value);
        } else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level + 1);
    }

    public void preOrder() {
        System.out.println("PreOrder traversal: ");
        preOrder(root);
        System.out.println();
    }

    public void postOrder() {
        System.out.println("PostOrder traversal: ");
        postOrder(root);
        System.out.println();
    }

    public void inOrder() {
        System.out.println("InOrder traversal: ");
        inOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    private void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // Morris InOrder and PreOrder traversal - using threaded binary tree (O(N) time complexity, O(1) space complexity)
    // InOrder algo -> L - N - R
    // One pattern here is whenever there is root.left we need to come back from the extreme right node of the root.left back to root
    // before printing it, so create a thread from extreme right to root before visiting the curr.left else if there is no left node and
    // move to curr.right, the other case is the thread already exists then remove the thread and then go to the curr.right
//    https://leetcode.com/problems/binary-tree-preorder-traversal/description/
//    https://www.naukri.com/code360/problems/preorder-traversal_3838888?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website


    private static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
