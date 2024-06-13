package LinkedList;

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    public CLL() {
        this.size = 0;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if(head == null) {
            node.next = node;
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void insertAt(int i, int value) {
        if(i >= size || i < 0) {
            System.out.printf("Index out of bound: given %d, size %d",i, size);
            System.out.println();
            return;
        } else if (i == 0 || i == size - 1) {
            insert(value);
            return;
        }
        Node curr = head;
        while(i > 0) {
            curr = curr.next;
            i--;
        }
        curr.next = new Node(value,curr.next);
        size++;
    }

    public void deleteHead() {
        if(head == null) {
            System.out.println("LinkedList is empty!");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        tail.next = head.next;
        head = head.next;
        size--;
    }

    public void deleteTail() {
        if(head == null) {
            System.out.println("LinkedList is empty!");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        Node curr = head;
        while(curr.next.next != head) curr = curr.next;
        tail = curr;
        curr.next = head;
        size--;
    }

    public void deleteAt(int i) {
        if(i >= size || i < 0) {
            System.out.printf("Index out of bound: given %d, size %d",i, size);
            System.out.println();
            return;
        } else if (i == size - 1) {
            deleteHead();
            return;
        } else if (i == 0) {
            deleteTail();
            return;
        }
        Node curr = head;
        while(i > 1) {
            curr = curr.next;
            i--;
        }
        curr.next = curr.next.next;
        size--;
    }

    public void display(){
        if(size == 0) {
            System.out.print("[ ]");
            return;
        }
        System.out.print("[ ");
        Node curr = head;
        while(curr.next != head) {
            System.out.print(curr.value + ", ");
            curr = curr.next;
        }
        System.out.println(curr.value + " ]");
    }

    public int size() {
        return size;
    }

    public int getIndex(int value) {
        Node node = head;
        if(node == null) return -1;
        int i = 0;
        while(node.next != head) {
            if (node.value == value) return i;
            node = node.next;
            i++;
        }
        if (node.value == value) return i;
        return -1;
    }

    private static class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
