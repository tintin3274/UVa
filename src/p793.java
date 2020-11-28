import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p793 {
    static class UnionFind{
        static int[] p, rank;

        public UnionFind(int n){
            rank = new int[n+1];
            p = new int[n+1];
            for(int i=1; i<=n; i++) p[i] = i;
        }

        static int findSet(int i){
            return (p[i] == i) ? i : (p[i] = findSet(p[i]));
        }
        static boolean isSameSet(int i, int j){
            return findSet(i) == findSet(j);
        }
        static void unionSet(int i, int j){
            if(!isSameSet(i, j)){
                int x = findSet(i);
                int y = findSet(j);
                if(rank[x] > rank[y]) p[y] = x;
                else{
                    p[x] = y;
                    if(rank[x] == rank[y]) rank[y]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, a, b, c, successfully, unsuccessfully;
        String line, answer="";
        String[] lineSplit;
        c = Integer.parseInt(br.readLine().trim());
        while(c > 0){
            line = br.readLine();
            if(line.equals("")) continue;
            c--;
            n = Integer.parseInt(line.trim());
            UnionFind UF = new UnionFind(n);
            successfully = 0;
            unsuccessfully = 0;
            while((line = br.readLine()) != null && line.length() > 0 && !line.equals("")){
                lineSplit = line.trim().split(" ");
                line = lineSplit[0];
                a = Integer.parseInt(lineSplit[1].trim());
                b = Integer.parseInt(lineSplit[2].trim());
                if(line.equals("c")){
                    UF.unionSet(a, b);
                }
                else if(line.equals("q")){
                    if(UF.isSameSet(a, b)) successfully++;
                    else unsuccessfully++;
                }
            }
            answer += successfully+","+unsuccessfully+"\n\n";
        }
        System.out.print(answer.substring(0, answer.length()-1));
    }
}

