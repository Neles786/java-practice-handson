package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail == null) tail = node;
        size += 1;
    }

    public void insertEnd(int value) {
        Node node = new Node(value);
        if(head == null) {
            insertFirst(value);
        } else {
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
        curr.next = new Node(value,curr.next);
        size++;
    }

    // insert at i using recursive approach
    public void insertRec(int i, int value) {
        head = insertAt(head, i, value);
    }
    private Node insertAt(Node Head, int i, int value) {
        if(i >= size || i < 0) return null;
        if(i == 0) {
            Node node = new Node(value, Head);
            size++;
            return node;
        } else {
            Head.next = insertAt(Head.next, i - 1, value);
        }
        return Head;
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
        Node curr = head;
        while(curr.next.next != null) curr = curr.next;
        tail = curr;
        curr.next = null;
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
        size--;
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

    public void bubbleSort() {
        head = bubbleSortHelper(head);
        tail = updateTail(head);
    }

    private Node bubbleSortHelper(Node Head) {
        if(Head == null || Head.next == null) return Head;
        int i = size - 1;
        Node newHead = Head;
        while(i > 0) {
            Node curr = newHead, prevCurr = null;
            while(curr.next != null) {
                if(curr.value > curr.next.value) {
                    Node temp = curr.next;
                    if(prevCurr == null) {
                        newHead = temp;
                    } else {
                        prevCurr.next = temp;
                    }
                    prevCurr = temp;
                    curr.next = temp.next;
                    temp.next = curr;
                } else {
                    prevCurr = curr;
                    curr = curr.next;
                }
            }
            i--;
        }
        return newHead;
    }

    public void mergeSort(){
        head = mergeSortHelper(head);
        tail = updateTail(head);
    }

    private Node mergeSortHelper(Node Head) {
        if(Head == null || Head.next == null) return Head;
        Node slow = Head, fast = Head, prevSlow = null;
        while(fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevSlow.next = null;
        return mergeList(mergeSortHelper(Head), mergeSortHelper(slow));
    }

    private Node mergeList(Node first, Node second) {
        Node l1 = first, l2 = second;
        Node merged = new Node();
        Node temp = merged;
        while(l1 != null && l2 != null) {
            if(l1.value <= l2.value) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) temp.next = l1;
        if(l2 != null) temp.next = l2;
        return merged.next;
    }

    private Node updateTail(Node Head) {
        if(Head == null || Head.next == null) return Head;
        Node curr = Head;
        while(curr.next != null) curr = curr.next;
        return curr;
    }

    private static class Node{
        int value;
        Node next;
        public Node(){}
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
