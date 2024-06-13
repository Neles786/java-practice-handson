package Arrays;

public class InfiniteSortedArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,8,9,13,56,89,196,200,278};
        int target = 13;
        System.out.println(searchInInfiniteSortedArray(arr,target));
    }
    static int searchInInfiniteSortedArray(int[] arr, int target) {
//        binary search without using array length
        int start = 0, end = 1;
        while(target > arr[end]) {
            int sz = end - start + 1;
            int newStart = end + 1;
            end = start + 2 * sz;
            start = newStart;
        }
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
