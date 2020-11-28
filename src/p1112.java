import java.util.*;

public class p1112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, e, t, m, tc, u, v, w, i, index, length, count;
        String line;
        String[] lineSplit;
        tc = Integer.parseInt(sc.nextLine());

        while (tc-- > 0){
            sc.nextLine();
            n = Integer.parseInt(sc.nextLine());
            e = Integer.parseInt(sc.nextLine());
            t = Integer.parseInt(sc.nextLine());
            m = Integer.parseInt(sc.nextLine());

            n = n+1;
            int[][] graph = new int[n][n];
            int[] node_distance = new int[n];
            for(i=0; i<n; i++){
                node_distance[i] = Integer.MAX_VALUE;
            }

            while (m-- > 0){
                line = sc.nextLine();
                lineSplit = line.split(" ");
                u = Integer.parseInt(lineSplit[0]);
                v = Integer.parseInt(lineSplit[1]);
                w = Integer.parseInt(lineSplit[2]);
                graph[v][u] = w;
            }

            node_distance[e] = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            for(i=0; i<n; i++){
                queue.add(i);
            }

            while(!queue.isEmpty()){
                index = queue.getFirst();
                length = node_distance[index];

                for(int q : queue){
                    if(node_distance[q] < length){
                        index = q;
                        length = node_distance[q];
                    }
                }
                queue.remove((Integer) index);
                if(length != Integer.MAX_VALUE){
                    for(i=0; i<n; i++){
                        if(queue.contains(i) && graph[index][i] > 0){
                            if(length + graph[index][i] < node_distance[i]) {
                                node_distance[i] = length + graph[index][i];
                            }
                        }
                    }
                }
            }
            count=0;
            for(i=0; i<n; i++){
                if(node_distance[i] <= t) count++;
            }
            System.out.println(count);
            if(tc > 0) System.out.println();
        }
    }
}
