import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p572 {
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

    public static class BreadFirstPath{
        boolean[] marked;
        //int[] edgeTo;
        //int[] distTo;
        Graph G;

        public BreadFirstPath(Graph G) {
            this.G = G;
            marked = new boolean[G.V];
            //edgeTo = new int[G.V];
            //distTo = new int[G.V];
        }

        public void BFS(int s){
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            marked[s] = true;
            //distTo[s] = 0;

            while (!q.isEmpty()){
                int v = q.poll();
                for(int w : G.adj(v)){
                    if(!marked[w]){
                        q.add(w);
                        marked[w] = true;
                        //edgeTo[w] = v;
                        //distTo[w] = distTo[v] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n, i, j, count;
        String line;
        String[] lineSplit;

        while (true){
            line = sc.nextLine();
            lineSplit = line.split(" ");
            m = Integer.parseInt(lineSplit[0]);
            n = Integer.parseInt(lineSplit[1]);
            if(m==0 && n==0) break;

            char[][] map = new char[m][n];
            for(i=0; i<m; i++){
                line = sc.nextLine();
                map[i] = line.toCharArray();
            }

            Graph G = new Graph(m*n);
            for(i=0; i<m; i++){
                for(j=0; j<n; j++){
                    if(map[i][j] == '@' && (i-1 >= 0) && (j-1 >= 0) && map[i-1][j-1] == '@') G.addEdge((i*n)+j, ((i-1)*n)+(j-1));
                    if(map[i][j] == '@' && (i-1 >= 0) && map[i-1][j] == '@') G.addEdge((i*n)+j, ((i-1)*n)+(j));
                    if(map[i][j] == '@' && (i-1 >= 0) && (j+1 < n) && map[i-1][j+1] == '@') G.addEdge((i*n)+j, ((i-1)*n)+(j+1));

                    if(map[i][j] == '@' && (j-1 >= 0) && map[i][j-1] == '@') G.addEdge((i*n)+j, (i*n)+(j-1));
                    if(map[i][j] == '@' && (j+1 < n) && map[i][j+1] == '@') G.addEdge((i*n)+j, (i*n)+(j+1));

                    if(map[i][j] == '@' && (i+1 < m) && (j-1 >= 0) && map[i+1][j-1] == '@') G.addEdge((i*n)+j, ((i+1)*n)+(j-1));
                    if(map[i][j] == '@' && (i+1 < m) && map[i+1][j] == '@') G.addEdge((i*n)+j, ((i+1)*n)+(j));
                    if(map[i][j] == '@' && (i+1 < m) && (j+1 < n) && map[i+1][j+1] == '@') G.addEdge((i*n)+j, ((i+1)*n)+(j+1));
                }
            }

            BreadFirstPath B = new BreadFirstPath(G);
            count = 0;
            for(i=0; i<m; i++){
                for(j=0; j<n; j++){
                    if(!B.marked[(i*n)+j] && map[i][j] == '@'){
                        B.BFS((i*n)+j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
