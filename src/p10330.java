import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p10330 {
    static final int V = 202;
    static final int INF = Integer.MAX_VALUE;

    static int[][] res;
    static int mf, f, s, t, n, m;
    static ArrayList<Integer>[] g;
    static int[] p;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] lineSplit;
        int i, j, k, c, b, d;
        while ((line = br.readLine()) != null && line.length() > 0) {
            n = Integer.parseInt(line.trim());
            res = new int[V][V];
            g = new ArrayList[V];
            for (i=0; i<g.length; i++) {
                g[i] = new ArrayList<>();
            }

            // Here source is 0 as Barisal
            // Sink is 201 as Dhaka
            // now creating the graph with vertex spilting technique
            // 1 vertex is spilting with 101 // 2 as 102 and so on

            line = br.readLine();
            lineSplit = line.split(" ");
            for(i=1; i<=n; i++) {
                c = Integer.parseInt(lineSplit[i-1].trim());
                g[i].add(100+i);
                g[100+i].add(i);
                res[i][100+i] = c;
            }

            m = Integer.parseInt(br.readLine().trim());
            for(k=0; k<m; k++) {
                line = br.readLine();
                lineSplit = line.split(" ");
                i = Integer.parseInt(lineSplit[0].trim());
                j = Integer.parseInt(lineSplit[1].trim());
                c = Integer.parseInt(lineSplit[2].trim());

                g[100+i].add(j);
                g[j].add(100+i);
                res[100+i][j] = c;
            }

            // the source 0 as barisal and the sink is 201 as dhaka
            //connecting the source and sink

            // connect direct with 1, 2, 3 real node to Barisal as 0
            // connect direct with spilting edge to dhaka as 201

            s=0; t=201;

            line = br.readLine();
            lineSplit = line.split(" ");
            b = Integer.parseInt(lineSplit[0].trim());
            d = Integer.parseInt(lineSplit[1].trim());
            line = br.readLine();
            lineSplit = line.split(" ");
            for(k=0; k<b+d; k++) {
                i = Integer.parseInt(lineSplit[k].trim());
                if(k<b) {
                    g[s].add(i);
                    g[i].add(s);
                    res[s][i] = INF;
                }
                else {
                    g[100+i].add(t);
                    g[t].add(100+i);
                    res[100+i][t] = INF;
                }
            }
            int ans = EdmondsKarp();
            System.out.println(ans);
        }
    }

    static void augment(int v, int minEdge) {
        if(v==s){
            f=minEdge;
            return;
        }
        else if(p[v]!=-1){
            augment(p[v], Math.min(minEdge, res[p[v]][v]));
            res[p[v]][v]-=f;
            res[v][p[v]]+=f;
        }
    }

    static int EdmondsKarp() {
        mf=0;
        while(true){
            f=0;
            boolean[] visited = new boolean[V];
            visited[s] = true;
            p = new int[V];
            Arrays.fill(p, -1);
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            while(!q.isEmpty()){
                int u=q.poll();
                for(Integer v : g[u]) {
                    if(res[u][v]>0 && !visited[v]){
                        q.add(v);
                        p[v]=u;
                        visited[v]=true;
                    }
                }
            }
            augment(t, INF);
            if(f==0)
                break;
            mf+=f;
        }
        return mf;
    }
}
