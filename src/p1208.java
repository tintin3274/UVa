import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p1208 {
    static class Edge implements Comparable<Edge>{
        int v, w, weight;

        public Edge(int v, int w, int weight) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    static class UnionFind {
        static int[] p, rank;

        public UnionFind(int n) {
            rank = new int[n + 1];
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }

        static int findSet(int i) {
            return (p[i] == i) ? i : (p[i] = findSet(p[i]));
        }

        static boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        static void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int x = findSet(i);
                int y = findSet(j);
                if (rank[x] > rank[y]) p[y] = x;
                else {
                    p[x] = y;
                    if (rank[x] == rank[y]) rank[y]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, tc, n, i, j, w, a, b;
        String line;
        String[] lineSplit;

        tc = Integer.parseInt(sc.nextLine());
        for (c=1; c<=tc; c++){
            n = Integer.parseInt(sc.nextLine());
            int[][] map = new int[n][n];
            for(i=0; i<n; i++){
                line = sc.nextLine();
                lineSplit = line.split(", ");
                for(j=0; j<n; j++){
                    map[i][j] = Integer.parseInt(lineSplit[j].trim());
                }
            }

            ArrayList<Edge> edges = new ArrayList<>();
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(map[i][j] > 0){
                        w = map[i][j];
                        map[i][j] = 0;
                        map[j][i] = 0;
                        if(i < j){
                            a = i;
                            b = j;
                        }
                        else {
                            a = j;
                            b = i;
                        }
                        edges.add(new Edge(a, b, w));
                    }
                }
            }
            UnionFind UF = new UnionFind(n);
            Collections.sort(edges);
            System.out.println("Case "+c+":");
            for(Edge e: edges){
                if(!UF.isSameSet(e.v+1, e.w+1)){
                    UF.unionSet(e.v+1, e.w+1);
                    System.out.println((char)('A'+e.v)+"-"+(char)('A'+e.w)+" "+e.weight);
                }
            }
        }
    }
}
