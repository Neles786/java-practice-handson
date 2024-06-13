package LinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        if(tail == null) tail = node;
        size += 1;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        if(head == null) {
            insertFirst(value);
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        size += 1;
    }

    public void insertAt(int i, int value) {
        if(i >= size || i < 0) {
            System.out.printf("Index out of bound: given %d, size %d",i, size);
            System.out.println();
            return;
        } else if (i == 0) {
            insertFirst(value);
            return;
        } else if (i == size - 1) {
            insertEnd(value);
            return;
        }
        Node curr = head;
        while(i > 0) {
            curr = curr.next;
            i--;
        }
        Node node = new Node(value,curr.next,curr);
        curr.next.prev = node;
        curr.next = node;
        size++;
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("LinkedList is empty!");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteEnd() {
        if(head == null) {
            System.out.println("LinkedList is empty!");
            return;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void deleteAt(int i) {
        if(i >= size || i < 0) {
            System.out.printf("Index out of bound: given %d, size %d",i, size);
            System.out.println();
            return;
        } else if (i == size - 1) {
            deleteEnd();
            return;
        } else if (i == 0) {
            deleteFirst();
            return;
        }
        Node curr = head;
        while(i > 1) {
            curr = curr.next;
            i--;
        }
        curr.next = curr.next.next;
        curr.next.prev = curr;
        size--;
    }

    public int size() {
        return size;
    }

    public int getIndex(int value) {
        Node node = head;
        int i = 0;
        while(node != null) {
            if (node.value == value) return i;
            node = node.next;
            i++;
        }
        return -1;
    }

    public void display(){
        System.out.print("[ ");
        Node curr = head;
        while(curr != null) {
            if (curr.next != null)
                System.out.print(curr.value + ", ");
            else
                System.out.print(curr.value);
            curr = curr.next;
        }
        System.out.println(" ]");
    }

    private static class Node{
        int value;
        Node next;
        Node prev;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
