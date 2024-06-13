package Arrays;


import java.util.Arrays;

// when given numbers is a permutation of n numbers, use cyclic sort
// swap the numbers until the correct value is at the current index and send the current numbers to their correct indices

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {6,8,7,5,4,3,2,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicSort(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i] != i + 1) {
                int c = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = c;
                count++;
            }
        }
        System.out.println(count);
    }

}
