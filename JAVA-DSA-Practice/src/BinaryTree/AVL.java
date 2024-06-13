package BinaryTree;

public class AVL {
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

    public int getHeight() {
        return root.height;
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
        return rotate(node);
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node cLeft = c.left;
        c.left = p;
        p.right = cLeft;
        p.height = 1 + Math.max(height(p.left),height(p.right));
        c.height = 1 + Math.max(height(c.left),height(c.right));
        return c;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node cRight = c.right;
        c.right = p;
        p.left = cRight;
        p.height = 1 + Math.max(height(p.left),height(p.right));
        c.height = 1 + Math.max(height(c.left),height(c.right));
        return c;
    }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1) {
            if(height(node.left.left) - height(node.left.right) > 0) {
                // left - left case
                // rotate right on current node
                return rightRotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0) {
                // left - right case
                // first rotate left on current node.left
                // second rotate right on current node
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (height(node.right) - height(node.left) > 1) {
            if(height(node.right.right) - height(node.right.left) > 0) {
                // right - right case
                // rotate right on current node
                return leftRotate(node);
            }
            if(height(node.right.right) - height(node.right.left) < 0) {
                // right - left case
                // first rotate right on current node.right
                // second rotate left on current node
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        // No adjustment needed
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
