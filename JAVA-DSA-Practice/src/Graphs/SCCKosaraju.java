package Graphs;

import java.util.*;

// Step 1 - sort all the nodes in the order of finishing time (Use topological sort)
// Step 2 - transpose the graph
// Step 3 - start from the top of the topo-sorted stack and print each of the scc components

// time - O(V+E)
// space - O(V+E)
public class SCCKosaraju {
    private static void topoSortOnGraph(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> s) {
        vis[u]=true;
        for(int v:adj.get(u)) {
            if(!vis[v]) {
                topoSortOnGraph(v,adj,vis,s);
            }
        }
        s.push(u);
    }
    private static void dfsOnTransposedGraph(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> scc) {
        vis[u]=true;
        scc.add(u);
        for(int v:adj.get(u)) {
            if (!vis[v]) {
                dfsOnTransposedGraph(v, adj, vis, scc);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> kosarajuAlgo(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> SCCs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        // stack stores all nodes from the least finishing time to max from top
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]) {
                topoSortOnGraph(i, adj, vis, s);
            }
        }
        // get transposed graph
        ArrayList<ArrayList<Integer>> transposedAdj = new ArrayList<>();
        for(int i=0;i<V;i++) transposedAdj.add(new ArrayList<>());
        for(int i=0;i<V;i++) {
            vis[i]=false;
            for(int j: adj.get(i)) {
                transposedAdj.get(j).add(i);
            }
        }
        // Do dfs on the transposed graph starting from the top of the stack
        while(!s.isEmpty()) {
            int v = s.pop();
            ArrayList<Integer> scc = new ArrayList<>();
            if (!vis[v]) {
                dfsOnTransposedGraph(v, transposedAdj, vis, scc);
                SCCs.add(scc);
            }
        }
        return SCCs;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int V = sc.nextInt();
//        int E = sc.nextInt();
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
//        for(int i=0;i<E;i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            adj.get(u).add(v);
//        }
//        ArrayList<ArrayList<Integer>> allSCCs = kosarajuAlgo(V,adj);
//        System.out.println(allSCCs);
        System.out.println((121&1)^1);
        List<Integer> l = new ArrayList<>();
        l.getFirst();


    }
}
