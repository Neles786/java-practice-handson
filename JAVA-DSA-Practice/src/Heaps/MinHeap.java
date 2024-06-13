package Heaps;

import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> arr;
    int size;

    MinHeap() {
        arr = new ArrayList<>();
        size = 0;
    }

    public void insert(int value) {
        arr.add(value);
        size++;
        int cInd = size - 1;
        while(cInd > 0) {
            int pInd = (cInd % 2 == 0) ? (cInd / 2 - 1) : cInd / 2;
            if(arr.get(pInd) > arr.get(cInd)) {
                int child = arr.get(cInd);
                arr.set(cInd, arr.get(pInd));
                arr.set(pInd, child);
                cInd = pInd;
            } else {
                break;
            }
        }
    }

    public int top() {
        if(size == 0) {
            System.out.println("MinHeap is Empty!");
            return -1;
        }
        return arr.getFirst();
    }

    public int pop() {
        if(size == 0) {
            System.out.println("MinHeap is Empty! Cannot remove elements");
            return -1;
        }
        int deleted = arr.getFirst();
        arr.set(0,arr.get(size - 1));
        arr.removeLast();
        size--;
        int p = 0;
        int left = 1, right = 2;
        while(left < size || right < size) {
            if(left < size && right < size) {
                if(Math.min(arr.get(left),arr.get(right)) >= arr.get(p)) break;
                else if(arr.get(left) <= arr.get(right)) {
                    int c = arr.get(left);
                    arr.set(left,arr.get(p));
                    arr.set(p,c);
                    p = left;
                } else {
                    int c = arr.get(right);
                    arr.set(right,arr.get(p));
                    arr.set(p,c);
                    p = right;
                }
                left = 2*p + 1;
                right = 2*p + 2;
            } else {
                if(arr.get(left) < arr.get(p)) {
                    int c = arr.get(left);
                    arr.set(left,arr.get(p));
                    arr.set(p,c);
                }
                break;
            }
        }
        return deleted;
    }

    public void display() {
        display(arr, 0, 0);
    }

    private void display(ArrayList<Integer> arr, int ind, int level) {
        if(ind >= size) return;
        display(arr, 2 * ind + 2, level + 1);
        if(level > 0) {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|-----> " + arr.get(ind));
        } else {
            System.out.println(arr.get(ind));
        }
        display(arr, 2 * ind + 1, level + 1);
    }

}
