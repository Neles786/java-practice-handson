package Arrays;

public class BitonicArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,8,6,4,2,0};
        int target = 4;
        int peekIndex = findPeekIndex(arr);
        System.out.println(peekIndex);
        int ind1 = binarySearch(arr,target,0,peekIndex,true);
        int ind2 = binarySearch(arr,target,peekIndex + 1, arr.length - 1,false);
        if(ind1 != -1) System.out.println("Target found at " + ind1);
        else if (ind2 != -1) {
            System.out.println("Target found at " + ind2);
        }
        else{
            System.out.println("Target not found");
        }

    }
    static int findPeekIndex(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] <= arr[mid + 1]) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    static int binarySearch(int[] arr, int target, int start, int end, boolean isAscending) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                if (isAscending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (isAscending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

}
