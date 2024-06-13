package BinaryTree;

public class SegmentTree {
    private static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }
    private Node root;

    private Node constructTree(int[] arr, int start, int end) {
        if(start > end) return null;
        if(start == end) {
            Node node = new Node(start, end);
            node.data = arr[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        Node node = new Node(start, end);
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr,mid + 1, end);
        node.data = (node.left != null ? node.left.data : 0) + (node.right != null ? node.right.data : 0);
        return node;
    }

    public SegmentTree(int[] arr) {
        root = constructTree(arr, 0, arr.length - 1);
    }

    public void update(int index, int value) {
        root = update(root, index, value);
    }

    private Node update(Node node, int index, int value) {
        if(node == null) return null;
        int start = node.startInterval, end = node.endInterval;
        if(start == end) {
            node.data = value;
            return node;
        }
        int mid = start + (end - start) / 2;
        if(index <= mid) {
            node.left = update(node.left, index, value);
        } else {
            node.right = update(node.right, index, value);
        }
        node.data = (node.left != null ? node.left.data : 0) + (node.right != null ? node.right.data : 0);
        return node;
    }

    public int query(int left, int right) {
        return query(root, left, right);
    }

    private int query(Node node, int left, int right) {
        if(node == null) return 0;
        int start = node.startInterval, end = node.endInterval;
        if(start > end || end < left || start > right) return 0;
        if(start >= left && end <= right) return node.data;
        return query(node.left, left, right) + query(node.right, left, right);
    }

    public void display() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node == null) return;
        prettyDisplay(node.right, level + 1);
        if(level > 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t\t\t");
            }
            System.out.println("|-----> " + node.data + "|(" + node.startInterval + "," + node.endInterval + ")");
        } else {
            System.out.println(node.data + "|(" + node.startInterval + "," + node.endInterval + ")");
        }
        prettyDisplay(node.left, level + 1);
    }

}
