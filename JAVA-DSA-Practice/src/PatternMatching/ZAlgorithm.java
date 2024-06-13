package PatternMatching;

import java.util.ArrayList;
import java.util.List;
// TC - O(n+m)
// SC - O(n+m)
public class ZAlgorithm {
    private static int[] calculateZArray(char[] a) {
        // Z[i] denotes length of longest prefix match i.e if Z[i]=l then s[0..l-1]==s[i..i+l-1] where l is the max length
        int[] Z=new int[a.length];
        int L=0, R=0;
        for(int i=1;i<a.length;i++) {
            // Two cases either i will be inside the box [L,R] which is the interval where s[0..R-L]==s[L..R]
            // if it is inside the box we know that, Z[i] >= min(Z[i-L],R-i+1)
            // Logic -> (i-L) lies in (0,R-L) now if Z[i-L]<R-i+1 then the substring starting from (i-L) will be inside the box [0,R-L]
            // so Z[i]=Z[i-L] always (as it will not go beyond the boundary)
            // else if Z[i-L] >= (R-i+1) i.e. substring from i-L extends or lies on the boundary of [0,R-L], Z[i] may extend beyond [i,R]
            // We will then reevaluate the [L,R] interval
            if(i>R) {
                // Outside of [L,R] case
                L=R=i;
                while(R<a.length && a[R]==a[R-L]) R++;
                Z[i]=R-L;
                R--;
            } else {
                // I is in the [L,R]
                // check already computed Z value of (i-L) in [0,R-L] interval
                if(Z[i-L]<(R-i+1)) {
                    Z[i]=Z[i-L];
                } else {
                    L=i;
                    // since already matched up to R-i we will check beyond that
                    while(R<a.length && a[R]==a[R-L]) R++;
                    Z[i]=R-L;
                    R--;
                }
            }
        }
        return Z;
    }
    public static List<Integer> patternMatch(String text, String pattern) {
        List<Integer> indices = new ArrayList<>();
        String zString=pattern+'$'+text;
        char[] charArr = zString.toCharArray();
        int[] zArray = calculateZArray(charArr);
        for(int i=pattern.length()+1;i<charArr.length;i++) {
            if(zArray[i]==pattern.length()) {
                indices.add(i-pattern.length()-1);
            }
        }
        return indices;
    }
    public static void main(String[] args) {
        String txt="abababaaaaaaaaaabababababaaaaaaabbabaabaaa";
        String pat="aaa";
        System.out.println(patternMatch(txt,pat));
    }
}
