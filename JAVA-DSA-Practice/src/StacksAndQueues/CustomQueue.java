package StacksAndQueues;

public class CustomQueue {
    protected int[] data;
    private int end = 0;
    private static final int DEFAULT_SIZE = 10;

    public CustomQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return end == data.length;
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public void insert(int value) throws Exception{
        if(isFull()) {
            throw new Exception("Queue is full! Cannot insert new value");
        }
        data[end++] = value;
    }

    public int remove() throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot pop from an empty queue");
        }
        int removed = data[0];
        for(int i = 0; i < end - 1; i++) {
            data[i] = data[i + 1];
        }
        end--;
        return removed;
    }

    public int last() throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot peek from an empty queue");
        }
        return data[end - 1];
    }

    public int first() throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot peek from an empty queue");
        }
        return data[0];
    }

    public void display() {
        for(int i = 0; i < end; i++) System.out.print(data[i] + ", ");
        System.out.println();
    }
}
