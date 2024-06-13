package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {5,3,4,6,7,8,9,9,100,1,1,1,2,2000,2000,407};
        countSortUsingFreqArray(arr);
//        countSortUsingFreqArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void countSortUsingFreqArray(int[] arr) {
        int mx = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(mx < arr[i]) mx = arr[i];
        }
        int[] count = new int[mx + 1];
        for (int j : arr) count[j]++;
        int i = arr.length - 1;
        for(int j = mx; j >= 0; j--) {
            while(count[j] > 0) {
                arr[i--] = j;
                count[j]--;
            }
        }
    }
    static void countSortUsingHashmap(int[] arr) {
        int mn = Arrays.stream(arr).min().getAsInt();
        int mx = Arrays.stream(arr).max().getAsInt();
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int n : arr) freqMap.put(n, freqMap.getOrDefault(n,0) + 1);
        int j = arr.length - 1;
        for(int i = mx; i >= mn; i--) {
            if(freqMap.containsKey(i)) {
                int count = freqMap.get(i);
                while(count > 0) {
                    arr[j--] = i;
                    count--;
                }
            }
        }
    }
}
