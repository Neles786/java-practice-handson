package HashMap;

public class Main{
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp = new MyHashMap<>();
        mp.put("Nilesh", 99);
        mp.put("Kunal", 98);
        mp.put("Rahul", 97);
        mp.put("Suresh", 99);
        mp.put("Suresh", 89);
        mp.put("Rupesh", 99);
        mp.put("Jignesh", 99);
        mp.put("Kamal", 90);
        mp.put("Sundar", 98);
        mp.put("Raju", 95);
        mp.put("Kajal", 95);
        mp.put("Abhishek", 95);

        System.out.println(mp);
    }
}
