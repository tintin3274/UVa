import java.util.*;

public class p820 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c, n, i, u, v, w, s, t , cc = 1;
        int[] parent, cost;
        int[][] network;

        while(true){
            n = sc.nextInt();
            if(n == 0) break;
            s = sc.nextInt();
            t = sc.nextInt();
            c = sc.nextInt();
            network = new int[n+1][n+1];
            parent = new int[n+1];
            cost = new int[n+1];
            for(i=1; i<=c; i++){
                u = sc.nextInt();
                v = sc.nextInt();
                w = sc.nextInt();
                network[u][v] += w;
                network[v][u] += w;
            }

            cost[s] = Integer.MAX_VALUE;
            parent[s] = s;
            int maxflow = 0;
            boolean done = false;
            while (!done) {
                done = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(s);
                boolean[] vis = new boolean[network.length];
                vis[s] = true;
                while (!q.isEmpty()) {
                    n = q.poll();
                    if (n == t) {
                        done = false;
                        break;
                    }
                    for (i = 0; i < network.length; i++)
                        if (network[n][i] > 0 && !vis[i]) {
                            parent[i] = n;
                            cost[i] = Math.min(cost[n], network[n][i]);
                            vis[i] = true;
                            q.add(i);
                        }
                }
                if (!done) {
                    maxflow += cost[t];
                    n = t;
                    while (parent[n] != n) {
                        network[parent[n]][n] -= cost[t];
                        network[n][parent[n]] += cost[t];
                        n = parent[n];
                    }
                }
            }
            System.out.printf("Network %d\n", cc++);
            System.out.printf("The bandwidth is %d.\n\n", maxflow);
        }
    }
}
