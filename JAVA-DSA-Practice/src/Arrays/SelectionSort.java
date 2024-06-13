package Arrays;

import java.util.Arrays;


// select the max of first (n - k) elements in the kth pass and then put it in its place
// max n - 1 passes are required
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
    }
    static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j <= n - i; j++) {
                if(arr[max] < arr[j]) max = j;
            }
            int c = arr[max];
            arr[max] = arr[n - i];
            arr[n - i] = c;
            System.out.println(Arrays.toString(arr));
        }
    }
}
