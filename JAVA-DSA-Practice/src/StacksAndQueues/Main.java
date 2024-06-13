package StacksAndQueues;

import javax.swing.tree.TreeNode;
import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;

//class Job {
//    int id, profit, deadline;
//    Job(int x, int y, int z){
//        this.id = x;
//        this.deadline = y;
//        this.profit = z;
//    }
//}

public class Main {
    public static void main(String[] args) {
        // stack is a class
//        Stack<Integer> s = new Stack<>();
//        s.push(34);
//        s.push(45);
//        s.push(2);
//        s.push(9);
//        s.push(18);
//
//        System.out.println("Deleted from top of stack : " + s.pop());
//        System.out.println("Deleted from top of stack : " + s.pop());
//        System.out.println("Deleted from top of stack : " + s.pop());
//        System.out.println("Deleted from top of stack : " + s.pop());
//        System.out.println("Deleted from top of stack : " + s.pop());

        // Queue is an interface
//        Queue<Integer> q = new LinkedList<>();
//
//        q.add(34);
//        q.add(45);
//        q.add(2);
//        q.add(9);
//        q.add(18);
//
//        System.out.println("Deleted from queue : " + q.remove());
//        System.out.println("Deleted from queue : " + q.remove());
//        System.out.println("Deleted from queue : " + q.remove());
//        System.out.println("Deleted from queue : " + q.remove());
//        System.out.println("Deleted from queue : " + q.remove());

        // Deque
//        Deque<Integer> dq = new ArrayDeque<>();
//        dq.add(36);
//        dq.addFirst(67);
//        dq.addLast(18);
//
//        System.out.println(dq.remove());
//        System.out.println(dq.removeFirst());
//        System.out.println(dq.removeLast());

        // Custom Stack with fixed array size

//        CustomStack st = new CustomStack(7);
//        try {
//            st.push(34);
//            st.push(45);
//            st.push(2);
//            st.push(9);
//            st.push(18);
//            st.push(19);
//            st.push(98);
//
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//            System.out.println("Deleted from top of stack : " + st.pop());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        // dynamic sized stack
//        DynamicStack dst = new DynamicStack(5);
//        try{
//            dst.push(34);
//            dst.push(45);
//            dst.push(2);
//            dst.push(9);
//            dst.push(18);
//            dst.push(19);
//            dst.push(98);
//
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//            System.out.println("Deleted from top of stack : " + dst.pop());
//        } catch (Exception e) {
//            System.out.println(e);
//        }

        // Custom queue

//        CustomQueue q = new CustomQueue();
//
//        try{
//            q.insert(45);
//            q.insert(78);
//            q.insert(12);
//            q.insert(13);
//            q.insert(56);
//
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            q.insert(50);
//            q.display();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        // Circular Queue

//        DynamicQueue q = new DynamicQueue(6);
//
//        try{
//            q.insert(45);
//            q.insert(78);
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            q.insert(16);
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            q.insert(56);
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//            q.insert(12);
//            q.insert(13);
//
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            System.out.println("Removed from queue : " + q.remove());
//            q.display();
//            q.insert(50);
//            q.display();
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }

//        if(root == null) return new ArrayList<>();
//        int left = 0, right = 0;
//        TreeNode curr = root;
//        while(curr != null && curr.left != null) {
//            curr = curr.left;
//            left--;
//        }
//        curr = root;
//        while(curr != null && curr.right != null) {
//            curr = curr.right;
//            right++;
//        }
//        Map<Integer,Map<Integer,List<Integer>>> mp = new TreeMap<>();
//        Queue<Entity> q = new LinkedList<>();
//        int level = 0;
//        if(root != null) q.add(new Entity(root, 0));
//        while(!q.isEmpty()) {
//            int sz = q.size();
//            while(sz-- > 0) {
//                Entity e = q.poll();
//                if(!mp.containsKey(level)) {
//                    mp.put(level, new TreeMap<Integer,List<Integer>>());
//                }
//                mp.get(level).putIfAbsent(e.index, new ArrayList<>());
//                mp.get(level).get(e.index).add(e.node.val);
//                if(e.node.left != null) q.add(new Entity(e.node.left, e.index - 1));
//                if(e.node.right != null) q.add(new Entity(e.node.right, e.index + 1));
//            }
//            level++;
//        }
//        mp.forEach((i, m) -> m.forEach((k, v) -> Collections.sort(v)));
//        List<List<Integer>> res = new ArrayList<>();
//        for(int i = 0; i <= right - left; i++) res.add(new ArrayList<>());
//        for(Integer k: mp.keySet()) {
//            for(Map.Entry<Integer,List<Integer>> m : mp.get(k).entrySet()) {
//
//                for(int v : m.getValue())
//                // for(Integer v : m.getValue)
//            }
//        }
//        return res;
//        String s = "vhvjhhbgv";
//        StringBuilder builder = new StringBuilder();
//        builder.append("jj");
//        String s2 = Integer.toString(90);
//        Stack<Integer> st = new Stack<>();
//
//        st.push(9);
//        st.pop();
//        st.isEmpty();
//        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
//        System.out.println(a);
//        Map<Integer, Integer> mp = new HashMap<>();
//        System.out.println();
//        Stack<Character> s = new Stack<>();
//        Deque<Integer> d = new ArrayDeque<>();
//        d.getFirst();
//        System.out.println();
//        d.forEach(System.out::println);
//        d.getLast();
//        d.removeLast();
//        d.removeFirst();
//        d.addFirst(2);
//        StringBuilder sb = new StringBuilder();
//        sb.length();
//        sb.toString();
//        String s = new String();
//        s.substring();
//        Set<List<Integer>> s = new HashSet<>();
//        s.add(new ArrayList<>(Arrays.asList(1,2)));
//        s.add(new ArrayList<>(Arrays.asList(2,3)));
//        s.add(new ArrayList<>(Arrays.asList(3,2)));
//        s.add(new ArrayList<>(Arrays.asList(2,3)));
//        Set<Integer> s2 = new TreeSet<>();
//        s2.add(12);
//        s2.add(13);
//        s2.add(14);
//        s2.add(19);
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
//        s2.remove(12);
//        Iterator<Integer> it = s2.iterator();
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }
//        int[] a = {1,2,3};
//        List<Integer> ar = Arrays.stream(a).boxed().toList();
//        System.out.println(ar);
//
//        for(List<Integer> l : s) {
////            System.out.println(l);
//            List<Integer> a = new ArrayList<>(l);
//            a.add(1);
//            System.out.println(a);
//        }
//        List<Integer> arr = new ArrayList<>();
//        System.out.println();
//        ArrayList<Integer> arr2 = new ArrayList<>();
//        arr.isEmpty();
//        arr.addAll(arr2);
//        int row = 0, column = 0, n = 4;
//        for(int i = row + 1, j = column + 1; i < n && j < n; i++, j++) {
//            System.out.println(i + " " + j);
//        }
//
//        String s = "s";
//        s = s.repeat(8);
//        System.out.println(s);
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(0);
//        a.add(-1);
//        a.sort((o1, o2) -> (o1 - o2));
//        System.out.println(a);
//        Comparator<Integer> comp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -1;
//            }
//        };
//        PriorityQueue<Job> pq = new PriorityQueue<Job>((j1,j2)->(j1.profit==j2.profit)?(j2.deadline-j1.deadline):(j2.profit-j1.profit));
//        int[] prerequisites = new int[2];
//        List<List<Integer>> adj = new ArrayList<>(Collections.nCopies(prerequisites.length, new ArrayList<>())); // Don't use absurd behaviour
//        List<Integer> l = new ArrayList<>();
//        l.add(2);
//        Object[] p = l.toArray();
//        Integer[] p2 = l.toArray(new Integer[0]);
//        System.out.println(p[0]);
//        System.out.println(p2[0]);
//        List<Integer> a=new ArrayList<>();
//        a.add(-2);
//        a.add(2);
//        a.add(1);
//        Collections.sort(a);
//        System.out.println(a);
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(1,mp.getOrDefault(1,0));

    }
}
