package PatternMatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMPAlgorithm {
    // LPS Array -> Array storing the longest proper prefix (prefix not equal to whole string) which is also a suffix
    // lps[i] -> denotes longest proper prefix of pattern[0...i] which is also a suffix of pattern[0...i]
    public static int[] computeLPSArray(String pattern){
        int[] lps = new int[pattern.length()]; // lps -> longest prefix suffix array
        // lps[0]=0; - for one character it will be always zero
        int len=0,i=1; // maintains the length of longest proper prefix for each prefix of pattern(pat[0...i])
        while(i<pattern.length()) {
            if(pattern.charAt(i)==pattern.charAt(len)) {
                lps[i++]=++len;
            } else {
                if(len>0) len=lps[len-1];
                else {
                    lps[i++]=len;
                }
            }
        }
//        Alternative of above loop
//        for (int i = 1; i < n; i++) {
//            int len = lps[i - 1];
//            while (len > 0 && pattern.charAt(i)!=pattern.charAt(len)) {
//                len = lps[len - 1];
//            }
//            if (pattern.charAt(i)==pattern.charAt(len)) {
//                len++;
//            }
//            lps[i] = len;
//        }
        return lps;
    }
    public static List<Integer> KMPSearch(String text, String pattern) {
        List<Integer> indices=new ArrayList<>();
        int[] lps = computeLPSArray(pattern);
        int i=0,j=0;
        while(i<text.length() && j < pattern.length() && (text.length()-i) >= (pattern.length()-j)) {
            if(text.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j==pattern.length()) {
                indices.add(i-pattern.length());
                j=lps[j-1];
            } else if(i<text.length() && text.charAt(i)!=pattern.charAt(j)) {
                if(j>0) j=lps[j-1];
                else {
                    i++;
                }
            }
        }
        return indices;
    }
    public static void main(String[] args) {
//        String txt="abababaaaaaaaaaabababababaaaaaaabbabaabaaa";
//        String pat="aaa";
//        [6, 7, 8, 9, 10, 11, 12, 13, 25, 26, 27, 28, 29, 39]
//        String txt="abababaaaaaaaaaabababababaaaaaaabbabaabaaa";
//        String pat="aaa";
//        System.out.println(Arrays.toString(computeLPSArray(txt)));
//        System.out.println(KMPSearch(txt,pat));
    }
}
