package Heaps;

public class Main {
    public static void main(String[] args) {
        double[] arr = {1.1,2.3,3.7,5.9,3.8,4.6,6,10.112,12.90,8.9,0.1};
        Heap<Double> pq = new Heap<>();
        for(Double i : arr) {
            pq.insert(i);
        }
        pq.display();
        try {
            System.out.println();
            Double x = pq.remove();
            System.out.println("Deleted : " + x);
            System.out.println();
            pq.display();
            System.out.println();
            x = pq.remove();
            System.out.println("Deleted : " + x);
            System.out.println();
            pq.display();
            System.out.println();
            x = pq.remove();
            System.out.println("Deleted : " + x);
            System.out.println();
            pq.display();
            System.out.println();
            System.out.println(pq.heapSort());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
