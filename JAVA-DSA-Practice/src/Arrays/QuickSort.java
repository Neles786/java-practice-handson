package Arrays;

import java.util.Arrays;

// pivot -> choose any element p
// after first pass, all the elements < p will be on the LHS of p and > p elements will be on the RHS
// this the chosen element will be at its correct place
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,3,2,9,0,6,7,8,10,4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
    }
    static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            int pi = partition(arr, l, r);
            quickSort(arr, l, pi - 1);
            quickSort(arr, pi + 1, r);
        }
    }
    // partition the array around the pivot which is the last element of the array
    static int partition(int[] arr, int l, int r) {
        // pick always the last element
//        int pivot = arr[r];
        int i = l;
        for(int j = l; j <= r; j++) {
            if (arr[j] < arr[r]) {
                int c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
            }
        }
        int c = arr[i];
        arr[i] = arr[r];
        arr[r] = c;
        return i;
    }
}
