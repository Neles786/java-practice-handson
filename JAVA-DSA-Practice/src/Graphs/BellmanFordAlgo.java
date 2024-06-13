package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Allows to detect negative weight cycles in the graph
// Relax all the edges N-1 times sequentially
// each relaxation -> if(dist[u]+w<dist[v]) dist[v]=dist[u]+w
// why N-1 iterations?
// in worst case at each iteration only one node can be updated -> take example as
// 0 -> 1 -> 2 -> 3 -> 4
// edge list -> [[3,4,1],[2,3,1],[1,2,2],[0,1,9]]
// in this case for all the vertices takes n-1 iterations to be updated
// in the nth iteration if dist array gets updated then we can say the graph has negative cycles
public class BellmanFordAlgo {

    static final int INT_MAX=10000_0000;
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, INT_MAX);
        dist[S]=0;
        for(int i=0;i<V-1;i++) {
            for (ArrayList<Integer> edge : edges) {
                if (dist[edge.get(0)] != INT_MAX && (dist[edge.get(0)] + edge.get(2)) < dist[edge.get(1)]) {
                    dist[edge.get(1)] = dist[edge.get(0)] + edge.get(2);
                }
            }
        }
        for (ArrayList<Integer> edge : edges) {
            if (dist[edge.get(0)] != INT_MAX && (dist[edge.get(0)] + edge.get(2)) < dist[edge.get(1)]) {
                return new int[]{-1};
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // Inputs
//        5 6 0
//        0 3 1
//        0 1 2
//        3 2 3
//        1 2 4
//        1 4 5
//        2 4 1
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < E; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edge.add(sc.nextInt());
            edges.add(edge);
        }
        int[] dist = bellman_ford(V, edges, S);
        System.out.println("Shortest distance array : " + Arrays.toString(dist));
    }
}
