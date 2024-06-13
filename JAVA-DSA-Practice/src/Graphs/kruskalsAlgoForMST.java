package Graphs;

// sort all the edges according to weights
// take first edge and check whether they have the same parent or not
// if both are disjoint connect them via dsu and add the edge into the mst

// TC - O(E*logE) || O(E*logV) for sorting the edge list (Here for the DSU find and union it will be O(E) amortised)
// SC - O(E+V)

import java.util.*;

public class kruskalsAlgoForMST {

    static private int find(int[] p, int v) {
        if(p[v]==v) return v;
        return p[v]=find(p,p[v]);
    }

    static private void union(int[] p, int[] r, int a, int b) {
        int u = find(p,a);
        int v = find(p,b);
        if(u != v) {
            if(r[u]<r[v]) {
                int c=u;
                u=v;
                v=c;
            }
            p[v]=u;
            if(r[u]==r[v]) r[u]++;
        }
    }

    static int minimumSpanningTreeUsingKruskalsAlgo(int V, List<int[]> edges, List<int[]> mstEdges) {
        edges.sort((i, j) -> i[2]-j[2]);
        int[] p = new int[V];
        int[] r = new int[V];
        for(int i = 0; i < V; i++) p[i]=i;
        int i = 0, sum = 0;
        while(i < edges.size()) {
            int[] edge=edges.get(i);
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            i++;
            if(find(p,u)==find(p,v)) continue;
            union(p, r, u, v);
            sum += w;
            mstEdges.add(edge);
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
        List<int[]> edges = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int i=0;i<E;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
            edges.add(new int[]{u,v,w});
        }
        List<int[]> mstEdgeList = new ArrayList<>();
        System.out.println(minimumSpanningTreeUsingKruskalsAlgo(V,edges,mstEdgeList));
        for (int[] e: mstEdgeList) System.out.println(Arrays.toString(e));
    }
}
