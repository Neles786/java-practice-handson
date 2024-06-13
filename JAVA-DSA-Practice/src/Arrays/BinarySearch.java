package Arrays;

import java.util.ArrayList;
import java.util.List;

// testcases

// Ascending

// 3 5 1 5 6
// 4 5 1 5 6 7
// 4 6 1 5 6 7
// 10 11 1 2 3 4 11 14 19 27 35 49
// 5 67 9 37 69 78 87

// Descending

// 11 -89 12 9 7 3 1 -3 -6 -40 -53 -60 -89
// 11 -80 12 9 7 3 1 -3 -6 -40 -53 -60 -89
// 10 9 9 7 3 1 -3 -6 -40 -53 -60 -89
// 10 -39 9 7 3 1 -3 -6 -40 -53 -60 -89

public class BinarySearch {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int element = sc.nextInt();
//        int[] sortedArray = new int[size];
//        for(int i = 0; i < size; i++) sortedArray[i] = sc.nextInt();
        List<Integer> l = new ArrayList<>();
        int[] sortedArray = {12,9,7,3,1,-3,-6,-40,-53,-60,-89};
        int element = 9;
//        int index = searchInAscendingArrayRecursive(sortedArray, 0, size - 1, element);
//        int index2 = searchInAscendingArrayIterative(sortedArray, 0, size - 1, element);
        int index3 = searchInDescendingArrayIterative(sortedArray, 0, sortedArray.length - 1, element);
//        System.out.println(index);
    }
    private static int searchInAscendingArrayRecursive(int[] arr, int start, int end, int target) {
        if(start > end) {
            System.out.println("Element not found in the array");
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) {
            System.out.println("Element found at index : " + mid);
            return mid;
        } else if (arr[mid] > target) {
            return searchInAscendingArrayRecursive(arr, start, mid - 1, target);
        } else {
            return searchInAscendingArrayRecursive(arr, mid + 1, end, target);
        }
    }
    private static int searchInAscendingArrayIterative(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                System.out.println("Element found at index : " + (mid + 1));
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("Element not found in the array");
        return -1;
    }
    private static int searchInDescendingArrayIterative(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == target) {
                System.out.println("Element found at index : " + mid);
                return mid;
            } else if (arr[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println("Element not found in the array");
        return -1;
    }
}
