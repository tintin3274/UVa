import java.util.*;

public class p558 {
    static class Edge{
        int v, w, weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, n, m, i;
        int[] distTo, edgeTo;

        c = sc.nextInt();
        while (c-- > 0){
            n = sc.nextInt();
            m = sc.nextInt();
            distTo = new int[n];
            edgeTo = new int[n];

            ArrayList<Edge> edges = new ArrayList<>();
            for(i=0; i<m; i++){
                edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }

            Arrays.fill(distTo, Integer.MAX_VALUE);
            distTo[0] = 0;

            for(i=0; i<n-1; i++){
                for(Edge e: edges){
                    if(distTo[e.v] != Integer.MAX_VALUE){
                        if(distTo[e.v] + e.weight < distTo[e.w]){
                            distTo[e.w] = distTo[e.v] + e.weight;
                            edgeTo[e.w] = e.v;
                        }
                    }
                }
            }

            //negative cycle check
            boolean negativeCycle = false;
            for(Edge e: edges){
                if(distTo[e.v] + e.weight < distTo[e.w]){
                    negativeCycle = true;
                }
            }
            if(negativeCycle) System.out.println("possible");
            else System.out.println("not possible");
        }
    }
}
