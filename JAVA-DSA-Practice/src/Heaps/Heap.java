package Heaps;

import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{

    private ArrayList<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    private void swap(int i, int j) {
        T k = list.get(i);
        list.set(i,list.get(j));
        list.set(j, k);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2*index + 1;
    }

    private int right(int index) {
        return 2*index + 2;
    }

    public void insert(T value) {
        list.add(value);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {
        if(index == 0) return;
        int pIndex = parent(index);
        if(list.get(index).compareTo(list.get(pIndex)) < 0) {
            swap(index,pIndex);
            upHeap(pIndex);
        }
    }

    public T remove() throws Exception {
        if(list.isEmpty()) {
            throw new Exception("Removing from an Empty Heap!");
        }
        T temp = list.getFirst();
        T last = list.removeLast();
        if(!list.isEmpty()) {
            list.set(0, last);
            downHeap(0);
        }
        return temp;
    }

    private void downHeap(int index) {
        int min = index;
        int l = left(index);
        int r = right(index);
        if(l < list.size() && list.get(l).compareTo(list.get(min)) < 0) min = l;
        if(r < list.size() && list.get(r).compareTo(list.get(min)) < 0) min = r;
        if(min != index) {
            swap(min, index);
            downHeap(min);
        }
    }

    public void display() {
        display(list, 0, 0);
    }

    private void display(ArrayList<T> list, int ind, int level) {
        if(ind >= list.size()) return;
        display(list, 2 * ind + 2, level + 1);
        if(level > 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-----> " + list.get(ind));
        } else {
            System.out.println(list.get(ind));
        }
        display(list, 2 * ind + 1, level + 1);
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}
