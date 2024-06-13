package BinaryTree;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BinaryTree bt = new BinaryTree();
//        bt.populate(sc);
//        bt.display();
//        BinarySearchTree bst = new BinarySearchTree();
//        int[] nums = {4,5,9,8,7,10,15,11,1,3,2};
//        for (int num : nums) bst.insert(num);
//        int[] nums2 = {1,2,3,4,5,6,7,8,9,10};
//        bst.populateSorted(nums2);
//        bst.display();
//        System.out.println();
//        bst.inOrder();
//        bst.preOrder();
//        bst.postOrder();
//        AVL balancedBST = new AVL();
//        int[] nums3 = {7,5,6,3,10,2,1,4,11,12,13,14,15,16,17,19,20,120,124,126,160,170,78,80,90};
//        for (int num : nums3) balancedBST.insert(num);
        // height ceil(log(n + 1)) - 1 if n is the total number of elements
//        IntStream.range(1,1024).forEach(balancedBST::insert);
//        balancedBST.display();
//        System.out.println();
//        System.out.println(balancedBST.balanced());
//        System.out.println(balancedBST.getHeight());

        // Segment tree example - evaluate sum of elements in a sub-array with updating the values of the array elements

        Random rand = new Random();
        int len = 15;
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++) arr[i] = rand.nextInt(2000);

        SegmentTree sg = new SegmentTree(arr);

        ArrayList<Integer> res =  new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            int c = rand.nextInt(2);
            if(c == 1) {
                int index = rand.nextInt(len);
                int value = rand.nextInt(2000);
                arr[index] = value;
                sg.update(index, value);
            } else {
                int left = rand.nextInt(len);
                int right = rand.nextInt(len);
                if(left > right) {
                    int p = left;
                    left = right;
                    right = p;
                }
                res.add(sg.query(left,right));
            }
        }

        System.out.println(res);
    }
}
