package StacksAndQueues;

public class CircularQueue {
    protected int start = -1;
    protected int end = -1;
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    public CircularQueue() {
        data = new int[DEFAULT_SIZE];
    }

    public CircularQueue(int size) {
        data = new int[size];
    }

    public boolean isEmpty() {
        return start == -1;
    }

    public boolean isFull() {
        return (end - start + 2 * data.length + 1) % data.length == 0;
    }

    public void insert(int value) throws Exception{
        if(isFull()) {
            System.out.println(start + " " + end);
            throw new Exception("Queue is Full!");
        }
        if(start == -1) {
            start = end = 0;
        } else {
            end = (end + 1) % data.length;
        }
        data[end] = value;
    }

    public int remove() throws Exception {
        if(isEmpty()) {
            throw new Exception("Queue is Empty!");
        }
        int removed = data[start];
        if(start == end) {
            start = end = -1;
        } else {
            start = (start + 1) % data.length;
        }
        return removed;
    }

    public void display() {
        if(start == -1) {
            System.out.println("Empty Queue!");
            return;
        }

        System.out.printf("[%d , %d] : ", start, end);

        int i = start;
        while(i != end) {
            System.out.print(data[i] + ", ");
            i = (i + 1) % data.length;
        }
        System.out.println(data[i]);
    }




}
