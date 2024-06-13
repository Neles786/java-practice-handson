package Arrays;

public class RotatedSortedArray {
//    public static void main(String[] args) {
//        int[] arr = {4,5,6,7,8,1,2,3};
//        int target = 8;
//        int pivotIndex = findPivotIndexWithoutDuplicates(arr);
//        System.out.println(pivotIndex);
//        int ind1 = binarySearch(arr,target,0,pivotIndex);
//        int ind2 = binarySearch(arr,target,pivotIndex + 1, arr.length - 1);
//        if(ind1 != -1) System.out.println("Target found at " + ind1);
//        else if (ind2 != -1) {
//            System.out.println("Target found at " + ind2);
//        }
//        else{
//            System.out.println("Target not found");
//        }
//    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,2,0};
        int target = 2;
        int pivot = findPivotIndexWithDuplicates(nums);
        if(pivot == -1) System.out.println(binarySearch(nums,target,0,nums.length - 1));
        if(target == nums[pivot]) System.out.println(pivot);
        System.out.println(binarySearch(nums,target,0,pivot));
        System.out.println(binarySearch(nums,target,pivot + 1, nums.length - 1));
    }
    static int findPivotIndexWithoutDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if (arr[start] < arr[end]) {
                start = end;
                break;
            }
            else if(arr[mid] <= arr[start]) {
                end = mid - 1;
            }
            else {
                start = mid;
            }
        }
        return start;
    }
    static int findPivotIndexWithDuplicates(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            // check if mid and mid - 1 are pivot indices
            if(mid < end && arr[mid] > arr[mid + 1]) return mid;
            if(mid > start && arr[mid] < arr[mid - 1]) return mid - 1;
            // case for duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]) {
                if(arr[start] > arr[start + 1]) return start;
                start++;
                if(arr[end] < arr[end - 1]) return end - 1;
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[end] < arr[mid])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    // no duplicates allowed
    // use pivotal approach to solve the array with duplicates
    static int searchInRotatedArray(int[] arr, int target, int start, int end) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) return mid;
        // either (start,mid) or (mid + 1,end) will be sorted array and then check whether the target lies within that sorted range or not
        if (arr[mid] >= arr[start]) return (target < arr[mid] && target >= arr[start]) ? searchInRotatedArray(arr,target,start,mid - 1) : searchInRotatedArray(arr,target,mid + 1,end);
        return (target > arr[mid] && target <= arr[end]) ? searchInRotatedArray(arr,target,mid + 1,end) : searchInRotatedArray(arr,target,start,mid - 1);
    }
}
