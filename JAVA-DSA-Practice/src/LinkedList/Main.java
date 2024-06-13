package LinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        LL ll = new LL();
//        DLL ll = new DLL();
        ll.insertFirst(3);
        ll.insertFirst(4);
        ll.insertFirst(5);
        ll.insertFirst(6);
        ll.insertFirst(8);
        ll.insertFirst(17);
        ll.insertEnd(1);
        ll.insertEnd(2);
        ll.insertEnd(6);
        ll.insertAt(0,1);
        ll.insertAt(8, 200);
        ll.display();
        System.out.println(ll.getIndex(6));
        System.out.println(ll.getIndex(16));
        ll.display();
        ll.deleteFirst();
        ll.display();
        ll.deleteAt(7);
        ll.display();
        ll.deleteEnd();
        System.out.println(ll.size());
        ll.display();
        // Using Recursion
        ll.insertRec(4,10);
        ll.insertRec(8,30);
        ll.display();
//        ll.mergeSort();
        ll.bubbleSort();
        System.out.println(ll.size());
        ll.display();


//        CLL ll = new CLL();
//        ll.insert(3);
//        ll.insert(4);
//        ll.insert(5);
//        ll.insert(6);
//        ll.insert(8);
//        ll.insert(17);
//        ll.insert(1);
//        ll.insert(2);
//        ll.insert(6);
//        ll.insertAt(0,1);
//        ll.insertAt(8, 200);
//        ll.display();
//        System.out.println(ll.getIndex(6));
//        System.out.println(ll.getIndex(16));
//        ll.display();
//        ll.deleteHead();
//        ll.display();
//        ll.deleteAt(7);
//        ll.display();
//        ll.deleteTail();
//        System.out.println(ll.size());
//        ll.display();


    }
}
