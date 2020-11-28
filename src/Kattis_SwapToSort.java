import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Kattis_SwapToSort {
    static int root(int[] arr, int x) {
        if(arr[x] < 0) return x;
        arr[x] = root(arr, arr[x]);
        return arr[x];
    }

    static void connect(int[] arr, int a, int b) {
        int ra = root(arr, a);
        int rb = root(arr, b);
        if(ra != rb) {
            if(arr[ra] > arr[rb]) ra ^= rb ^= ra ^= rb;
            arr[ra] += arr[rb];
            arr[rb] = ra;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        int n, k;
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        int[] uf = new int[1000000];
        Arrays.fill(uf, -1);
        for(int i=0; i<k; i++) {
            int a, b;
            s = br.readLine().split(" ");
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            connect(uf, a-1, b-1);
        }

        int cap = n>>1;
        boolean valid = true;
        for(int i=0; i<cap; i++) {
            if(root(uf, i) != root(uf, n-1-i)) {
                valid = false;
                break;
            }
        }
        System.out.println(valid ? "Yes" : "No");
    }
}
