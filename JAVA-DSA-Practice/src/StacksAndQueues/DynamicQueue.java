package StacksAndQueues;

public class DynamicQueue extends CircularQueue{
    public DynamicQueue() {
        super();
    }
    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public void insert(int value) throws Exception {
        if(isFull()) {
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++) temp[i] = data[(start + i) % data.length];
            start = 0;
            end = data.length - 1;
            data = temp;
        }
        super.insert(value);
    }
}
