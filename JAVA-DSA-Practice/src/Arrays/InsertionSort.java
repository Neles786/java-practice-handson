package Arrays;

// Array sorted in the parts, like for kth pass first k elements will be sorted and we will put (k + 1) th element at its right place

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,5,4,3,2,1};
        insertionSort(arr);
    }
    static void insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j + 1] < arr[j]) {
                    int c = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = c;
                } else {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
