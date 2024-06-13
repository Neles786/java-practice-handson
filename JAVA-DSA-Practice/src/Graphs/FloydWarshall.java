package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Multi source Shortest path algorithm
// To detect negative cycles check dist[i][i] < 0 for any of the nodes
// time -> O(V^3)
// space -> O(V^2)
public class FloydWarshall {

    public static void floydWarshallAlgo(int[][] dist) {
        int V = dist.length;
        for(int k=0;k<V;k++) {
            for(int i=0;i<V;i++) {
                for(int j=0;j<V;j++) {
                    if(dist[i][k] != -1 && dist[k][j] != -1) {
                        if(dist[i][j] == -1) dist[i][j]=dist[i][k]+dist[k][j];
                        else if (dist[i][k]+dist[k][j]<dist[i][j]) {
                            dist[i][j]=dist[i][k]+dist[k][j];
                        }
                    }
                }
            }
        }
    }

    public static int[][] floydWarshallAlgo(int V, ArrayList<ArrayList<Integer>> edges) {
        int[][] dist = new int[V][V];
        for(int[] row: dist) Arrays.fill(row, Integer.MAX_VALUE);
        for(int i=0;i<V;i++) dist[i][i] = 0;
        for (ArrayList<Integer> edge : edges) dist[edge.get(0)][edge.get(1)] = edge.get(2);
        for(int k=0;k<V;k++) {
            for(int i=0;i<V;i++) {
                for(int j=0;j<V;j++) {
                    if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j]) {
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        for(int i=0;i<V;i++) {
            for(int j=0;j<V;j++) {
                if(dist[i][j]==Integer.MAX_VALUE) dist[i][j]=-1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
//        5 6
//        0 3 1
//        0 1 2
//        3 2 3
//        1 2 4
//        1 4 5
//        2 4 1
//        Distance Array
//        12
//        0 4 2 1 2 9 4 8 -1 4 -1 -1
//        9 0 3 6 2 6 2 3 6 -1 -1 3
//        7 1 0 10 8 9 1 3 -1 7 -1 10
//        5 1 9 0 3 -1 1 10 7 1 -1 7
//        -1 5 1 4 0 2 10 4 10 6 4 5
//        7 8 3 7 5 0 5 1 3 5 7 2
//        6 -1 6 1 10 7 0 10 -1 -1 7 7
//        -1 3 2 7 4 -1 4 0 10 5 6 10
//        10 6 1 10 4 4 7 10 0 4 7 4
//        1 1 6 8 8 9 2 10 6 0 -1 3
//        5 9 3 -1 4 3 -1 -1 -1 3 0 1
//        2 2 8 6 2 4 4 3 -1 3 4 0
        Scanner sc = new Scanner(System.in);
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
//        for(int i = 0; i < E; i++) {
//            ArrayList<Integer> edge = new ArrayList<>();
//            edge.add(sc.nextInt());
//            edge.add(sc.nextInt());
//            edge.add(sc.nextInt());
//            edges.add(edge);
//        }
//        int[][] dist = floydWarshallAlgo(V, edges);
        int V = sc.nextInt();
        int[][] dist = new int[V][V];
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        floydWarshallAlgo(dist);
        for(int[] d : dist) System.out.println("Distance Matrix for row: " + Arrays.toString(d));
    }
}
