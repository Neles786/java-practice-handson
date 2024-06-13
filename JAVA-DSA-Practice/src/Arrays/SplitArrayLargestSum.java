package Arrays;

// https://leetcode.com/problems/split-array-largest-sum/description/

public class SplitArrayLargestSum {
    static int[] pref = new int[1002];
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 2;
        int mn = Integer.MIN_VALUE, mx = 0;
        for (int num : nums) {
            mn = Math.max(num, mn);
            mx += num;
        }
        System.out.println(binarySearch(nums, mn, mx, k));
    }
    static int binarySearch(int[] nums, int start, int end, int k) {
        int ans = end;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(calculateSubArray(nums,mid) <= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    static int calculateSubArray(int[] nums, int sum) {
        int count = 1, s = 0;
        for (int num : nums) {
            if (s + num <= sum) s += num;
            else {
                s = num;
                count++;
            }
        }
        return count;
    }

}
