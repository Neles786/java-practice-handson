package Arrays;

import java.util.*;

// sort the array using count sort digit by digit, starting from unit place to high bases
public class RadixSort {

    public static void main(String[] args) {
        int[] nums = {1,2,45,6758,99,78,878,3430,0,20,100,899,79,2025,65,11,22};
        radixSort(nums);
    }
    static void radixSort(int[] nums) {
        int mxdigits = 0;
        for(int i : nums) mxdigits = Math.max(mxdigits, (int)Math.log10(i) + 1);
        for(int i = 1; i <= mxdigits; i++) {
            countSort(nums, i - 1);
            System.out.println(Arrays.toString(nums));
        }
    }
    static void countSort(int[] nums, int d) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int mx = 0, mn = 9;
        for(int i : nums) {
            int div = (int)Math.pow(10,d);
            int dig = i / div;
            if (div == 1) dig = i % 10;
            mx = Math.max(mx, dig);
            mn = Math.min(mn, dig);
            mp.computeIfAbsent(dig,v -> new ArrayList<>()).add(i);
        }
//        mp.entrySet().forEach(System.out::println);
        int j = nums.length - 1;
        for(int i = mx; i >= mn; i--) {
            if(mp.containsKey(i)) {
                while(!mp.get(i).isEmpty()) {
                    nums[j--] = mp.get(i).removeLast();
                }
            }
        }
    }
}
