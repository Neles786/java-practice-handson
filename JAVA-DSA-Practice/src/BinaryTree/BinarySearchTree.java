package BinaryTree;

public class BinarySearchTree {

    private static class Node{
        int value;
        int height;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    private int height(Node node) {
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
//        display(root, "Root Node : ");
        prettyDisplay(root,0);
    }

    private void display(Node node, String details) {
        if(node == null) {
            System.out.println(details + "Null");
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left Child of " + node.value + " : ");
        display(node.right, "Right Child of " + node.value + " : ");
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

    public void insert(int value) {
        root = insert(value,root);
    }

    private Node insert(int value, Node node) {
        if(node == null) return new Node(value);
        if(value < node.value) node.left = insert(value, node.left);
        else node.right = insert(value,node.right);
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        return node;
    }

    public void populateSorted(int[] nums) {
        sortedInsert(nums,0,nums.length - 1);
    }

    private void sortedInsert(int[] nums, int start, int end) {
        if(start > end) return;
        int mid = start + (end - start) / 2;
        this.insert(nums[mid]);
        sortedInsert(nums, start, mid - 1);
        sortedInsert(nums,mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if(node == null) return true;
        return Math.abs(height(node.right) - height(node.left)) <= 1 && balanced(node.left) && balanced(node.right);
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
}
