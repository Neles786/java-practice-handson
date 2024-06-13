package Arrays;

import java.util.Arrays;

// O(n2) time complexity
// In bubble sorting in each pass we swap two adjacent numbers i, j whenever i > j
// total number of passes required (n - 1) in worst case
// in kth pass each kth largest number will be in its place
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        bubbleSort(arr);
    }
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
            }
            Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
            System.out.println();
        }
    }
}
