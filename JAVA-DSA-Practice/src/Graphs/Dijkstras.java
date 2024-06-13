package Graphs;

import java.util.*;

// Don't work for negative graph cycles
// time - O((E+V)*logV) / worst case -> O(V^2logV)
// space - O(V+E)

public class Dijkstras {
    private static class Entity{
        int dist, node;
        Entity(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }
    public static int[] shortestPaths(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S, int[] parent) {
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Entity> pq = new PriorityQueue<>((e1,e2)->(e1.dist-e2.dist));
        pq.add(new Entity(0,S));
        dist[S]=0;
        while(!pq.isEmpty()) {
            Entity e = pq.poll();
            for (ArrayList<Integer> a : adj.get(e.node)) {
                if (dist[a.get(0)] == Integer.MAX_VALUE || dist[a.get(0)] > dist[e.node] + a.get(1)) {
                    dist[a.get(0)] = dist[e.node] + a.get(1);
                    parent[a.get(0)] = e.node;
                    pq.add(new Entity(dist[a.get(0)], a.get(0)));
                }
            }
        }
        return dist;
    }
    public static List<Integer> printPathFromSourceToDestination(int S, int D, int[] parent){
        int node=D;
        List<Integer> path = new ArrayList<>();
        while(node != parent[node]) {
            path.add(node);
            node=parent[node];
        }
        path.add(node);

        return path.reversed();
    }
    public static void main(String[] args) {

        /*
        2 1 0 1
        0 1 9

        5 6 0 4
        0 3 1
        0 1 2
        3 2 3
        1 2 4
        1 4 5
        2 4 1
         */

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt();
        int D = sc.nextInt();
        int[] parent = new int[V];
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            parent[i]=i;
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v= sc.nextInt();
            int w= sc.nextInt();
            if(u==v) continue;
            ArrayList<Integer> e1 = new ArrayList<>();
            ArrayList<Integer> e2 = new ArrayList<>();
            e1.add(u);
            e1.add(w);
            e2.add(v);
            e2.add(w);
            adj.get(u).add(e2);
            adj.get(v).add(e1);
        }
        int[] shortestDist = shortestPaths(V, adj, S, parent);
        List<Integer> shortestPath = printPathFromSourceToDestination(S, D, parent);
        System.out.println(Arrays.toString(shortestDist));
        System.out.println(shortestPath);
//        System.out.println(new ArrayList<>(List.of(-1)));
    }
}
