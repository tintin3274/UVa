import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p10305 {
    public static class Graph{
        int V;
        ArrayList<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for(int v=0; v<V; v++){
                adj[v] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w){
            adj[v].add(w);
            //adj[w].add(v);
        }

        public ArrayList<Integer> adj(int v){
            return adj[v];
        }
    }

    public static class DepthFirstPath{
        boolean[] marked;
        ArrayList<Integer> reversePostOrder;

        public DepthFirstPath(Graph G){
            marked = new boolean[G.V];
            reversePostOrder = new ArrayList<>();
            for(int v=1; v<G.V; v++){
                if(!marked[v]) DFS(G, v);
            }
            Collections.reverse(reversePostOrder);
        }

        public void DFS(Graph G, int v){
            marked[v] = true;
            for(int w: G.adj(v)){
                if(!marked[w]) DFS(G, w);
            }
            reversePostOrder.add(v);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, i, j, k;
        while (true) {
            n = sc.nextInt();
            m = sc.nextInt();
            if(n==0 && m==0) break;

            Graph graph = new Graph(n+1);
            for(k=0; k<m; k++){
                i = sc.nextInt();
                j = sc.nextInt();
                graph.addEdge(i, j);
            }
            DepthFirstPath depthFirstPath = new DepthFirstPath(graph);
            String listString = depthFirstPath.reversePostOrder.toString();
            listString = listString.substring(1, listString.length()-1);
            System.out.println(listString.replaceAll(", ", " "));
        }
    }
}
