import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

// using seperate comparator
// class Student{
//     int age;
//     String name;
//     public Student(int age, String name) {
//         this.age = age;
//         this.name = name;
//     }
//     @Override
//     public String toString() {
//         return "Student [age=" + age + ", name=" + name + "]";
//     }
// }

// use comparable interface
class Student implements Comparable<Student>{
    int age;
    String name;
    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }
    @Override
    public int compareTo(Student s) {
        if (this.age < s.age) return 1;
        return -1;
    }
}



public class Collection_demo {
    public static void main(String[] args) {

        // Arrays List and Collection
        // we cant index the array here
        // Collection<Integer> nums = new ArrayList<Integer>();
        // for(int i = 1; i <= 10; i++) nums.add(i);
        // // System.out.println(nums);
        // for(int i : nums) System.out.println(i);

        // List<Integer> nums = new ArrayList<Integer>();
        // for(int i = 1; i <= 10; i++) nums.add(i);
        // // System.out.println(nums);
        // for(int i = 0; i < nums.size(); i++) System.out.println(nums.get(i));

        // Set
        // values are not always sorted, for sorted use TreeSet
        // No repeated values

        // Set<Integer> nums = new HashSet<Integer>();
        // nums.add(81);
        // nums.add(54);
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // System.out.println(nums);

        // Collection<Integer> nums = new TreeSet<Integer>();
        // nums.add(81);
        // nums.add(54);
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // nums.add(1);
        // nums.add(2);
        // nums.add(3);
        // // System.out.println(nums);
        // Iterator<Integer> values = nums.iterator();
        // while(values.hasNext()) 
        //     System.out.println(values.next());

        // Map
        // Map<String,Integer> mp = new HashMap<String,Integer>();
        // Hashtable => synchronised, HashMap => asynchronised
        // Map<String,Integer> mp = new Hashtable<>();
        // mp.put("n1",23);
        // mp.put("n2",98);
        // mp.put("n3",66);
        // mp.put("n4",89);
        // mp.put("n5",54);
        // mp.put("n2",99);
        // System.out.println(mp);
        // System.out.println(mp.get("n2"));
        // // System.out.println(mp.keySet());

        // for(String key : mp.keySet()) {
        //     System.out.println(key + " : " + mp.get(key));
        // }

        // Comparator vs Comparable
        
        // Comparator<Integer> comp = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         if (o1 < o2) return 1;
        //         return -1;
        //     }
        // };

        // List<Integer> nums = new ArrayList<>();
        // for(int i = 0; i < 10; i++) {
        //     nums.add((int)(Math.random() * 10));
        // }
        // Collections.sort(nums, comp);
        // System.out.println(nums);


        // Comparator<Student> comp2 = new Comparator<Student>() {
        //     @Override
        //     public int compare(Student s1, Student s2) {
        //         if (s1.age < s2.age) return 1;
        //         return -1;
        //     }
        // };

        // List<Student> students = new ArrayList<>();

        // students.add(new Student(22,"Suresh"));
        // students.add(new Student(21,"Ramesh"));
        // students.add(new Student(20,"Raju"));
        // students.add(new Student(24,"Kamal"));
        // students.add(new Student(19,"Aditya"));

        // // Collections.sort(students,comp2);
        // Collections.sort(students);
        // for(Student s : students)
        //     System.out.println(s);

    }
}
