import java.util.*;

public class Kattis_CaveExploration {
    static class Pair{
        int u, v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return u == pair.u &&
                    v == pair.v;
        }

        @Override
        public int hashCode() {
            return Objects.hash(u, v);
        }
    }

    static int dfsTime = 0;

    static void find(ArrayList<ArrayList<Integer>> adj, ArrayList<Pair> bridges,
                     boolean[] vis, int[] par, int[] hi, int[] lo, int curr) {
        vis[curr] = true;
        hi[curr] = lo[curr] = ++dfsTime;
        for (int next : adj.get(curr)) {
            if(!vis[next]) {
                par[next] = curr;
                find(adj, bridges, vis, par, hi, lo, next);
                lo[curr] = Math.min(lo[curr], lo[next]);
                if(lo[next] > hi[curr]) {
                    bridges.add(new Pair(next, curr));
                }
            }
            else if(next != par[curr]) {
                lo[curr] = Math.min(lo[curr], hi[next]);
            }
        }
    }

    static int dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,
                   Set<Pair> skip, int curr) {
        vis[curr] = true;
        int total = 1;
        for (int next : adj.get(curr)) {
            if(vis[next]) {
                continue;
            }
            if(skip.contains(new Pair(curr, next)) || skip.contains(new Pair(next, curr))) {
                continue;
            }
            total += dfs(adj, vis, skip, next);
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read in graph
        for (int i = 0; i < m; i++) {
            int n1, n2;
            n1 = sc.nextInt();
            n2 = sc.nextInt();
            adj.get(n1).add(n2);
            adj.get(n2).add(n1);
        }

        // Allocate memory
        ArrayList<Pair> bridges = new ArrayList<>();
        boolean[] vis = new boolean[n];
        int[] par = new int[n];
        Arrays.fill(par, -1);
        int[] hi = new int[n];
        Arrays.fill(hi, -1);
        int[] lo = new int[n];
        Arrays.fill(lo, -1);

        // Find bridges
        find(adj, bridges, vis, par, hi, lo, 0);

        // Put bridges in a better data structure
        Set<Pair> skip = new HashSet<>();
        for(Pair i : bridges) {
            skip.add(i);
        }

        // Reset memory
        Arrays.fill(vis, false);

        // See how many nodes can be reached without using bridges
        System.out.println(dfs(adj, vis, skip, 0));
    }
}
