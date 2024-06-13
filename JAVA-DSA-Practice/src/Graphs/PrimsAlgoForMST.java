package Graphs;

import java.util.*;

// For undirected graphs we generate MST (Minimum Spanning Tree) a spanning tree which has the least sum of weights
// MST - A tree which has n nodes and n-1 edges and all nodes are reachable from one another
// Prim's Algorithm to find MST
// Initialize a min heap with (weight,node,parent) and push the first parent as (0,0,-1)
// take the first entry in heap, if the node is visited then ignore otherwise mark the node as visited, add it to the MST edges if parent is present,
// go through all the unvisited neighbours of the node and push it to heap
// eventually we will get our MST edges

// time - O((E+V)*logV) || O(E*logV) (if E>V) (dense graphs)
// space - O(E+V) || adjacency list and visited array and priority queue

public class PrimsAlgoForMST {
    private static class Node{
        int val;
        int parent;
        int weight;
        Node(int weight, int val, int parent) {
            this.weight=weight;
            this.val=val;
            this.parent=parent;
        }
    }
    static int minimumSpanningTreeUsingPrimsAlgo(int V, int E, List<List<int[]>> adj, List<int[]> mstEdges) {
        // Code Here.
        int sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->(n1.weight-n2.weight));
        pq.add(new Node(0,0,-1));
        boolean[] vis = new boolean[V];
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(vis[n.val]) continue;
            vis[n.val]=true;
            sum += n.weight;
            if(n.parent != -1) mstEdges.add(new int[]{n.parent,n.val,n.weight});
            for(int[] e : adj.get(n.val)) {
                if(!vis[e[0]]) {
                    pq.add(new Node(e[1],e[0],n.val));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        3 3
//        0 1 5
//        1 2 3
//        0 2 1

//        2 1
//        0 1 5
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<E;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        List<int[]> mstEdgeList = new ArrayList<>();
        System.out.println(minimumSpanningTreeUsingPrimsAlgo(V,E,adj,mstEdgeList));
        for (int[] e: mstEdgeList) System.out.println(Arrays.toString(e));
    }
}
