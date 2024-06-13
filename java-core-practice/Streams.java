import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,7,9,76,653,9,10,68,964);
        // nums.forEach(n->System.out.println(n));
        // stream can be executed only once
        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n%2==0);
        // Stream<Integer> s3 = s2.map(n -> n * 2);
        // System.out.println(s3.reduce(0,(i,j)->i+j));
        System.out.println(nums.stream().filter(n -> n%2==0).map(n -> n * 2).reduce(0,(i,j) -> i + j));
        // s3.forEach(n->System.out.println(n));
        // s1.forEach(n->System.out.println(n)); // will throw runtime exception IllegalStateException : stream has already been operated upon or closed

    }
    
}
