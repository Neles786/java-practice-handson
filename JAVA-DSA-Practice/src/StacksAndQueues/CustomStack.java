package StacksAndQueues;

public class CustomStack {
    protected int[] data;
    private int ptr = -1;
    private static final int DEFAULT_SIZE = 10;

    public CustomStack() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public void push(int value) throws Exception{
        if(isFull()) {
            throw new Exception("Stack is full! Cannot insert new value");
        }
        data[++ptr] = value;
    }

    public int pop() throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot pop from an empty stack");
        }
        return data[ptr--];
    }

    public int peek() throws Exception{
        if(isEmpty()) {
            throw new Exception("Cannot peek from an empty stack");
        }
        return data[ptr];
    }
}
