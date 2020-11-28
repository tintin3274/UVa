import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p12086 {
    static class FenwickTree{
        static int[] ft;
        static int rsq(int b){
            int sum = 0;
            for(; b > 0; b -= b&(-b)){
                sum += ft[b];
            }
            return sum;
        }
        static int rsq(int a, int b){
            return rsq(b) - (a == 1 ? 0 : rsq(a-1));
        }
        static void adjust(int k, int v){
            for(; k < ft.length; k += k&(-k)){
                ft[k] += v;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] lineSplit;
        int i, j, n, a, b, count = 1;
        int[] f;
        while(true){
            n = Integer.parseInt(br.readLine().trim());
            if(n == 0) break;
            if(count > 1) System.out.println();
            FenwickTree FT = new FenwickTree();
            f = new int[n+1];
            FT.ft = new int[n+1];
            for(i=1; i<=n; i++){
                j = Integer.parseInt(br.readLine().trim());
                f[i] = j;
                FT.adjust(i, j);
            }
            System.out.println("Case "+count+":");
            while(true){
                line = br.readLine();
                if(line.trim().equals("END")) break;
                lineSplit = line.trim().split(" ");
                a = Integer.parseInt(lineSplit[1].trim());
                b = Integer.parseInt(lineSplit[2].trim());
                if(lineSplit[0].equals("S")){
                    FT.adjust(a, -(f[a]-b));
                    f[a] = b;
                }
                else if(lineSplit[0].equals("M")){
                    System.out.println(FT.rsq(a, b));
                }
            }
            count++;
        }
    }
}