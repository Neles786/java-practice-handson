package Arrays;

public class CeilingOfTarget {
    public static void main(String[] args) {
        // find ceiling of target in a sorted array
        // It means find the smallest element which is greater than or equal to target
        int[] sortedArray = {1,2,3,4,5,7,8,17,19,28,68};
        int target = 23;
        int ind = ceilingOfTarget(sortedArray,target);
        int ind2 = floorOfTarget(sortedArray,target);
        if (ind == -1)
            System.out.println("No Element greater than or equal to " + target + " is present in the array");
        else
            System.out.println("The smallest element greater than or equal to " + target + " is " + sortedArray[ind]);
        if (ind2 == -1)
            System.out.println("No Element smaller than or equal to " + target + " is present in the array");
        else
            System.out.println("The smallest element smaller than or equal to " + target + " is " + sortedArray[ind2]);
    }
    static int ceilingOfTarget(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] >= target) {
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    static int floorOfTarget(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] >= target) {
                end = mid - 1;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
