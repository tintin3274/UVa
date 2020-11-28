import java.util.Arrays;
import java.util.Scanner;

public class p714 {
    static long m, k, lo, hi, ans;
    static long[] ar, check;

    static long partition(long num) {
        check = new long[505];
        Arrays.fill(check, 0);
        int posN = (int) (m-1);
        long count = 0;
        while (posN >= 0) {
            long s = 0;
            boolean flag = true;
            while (posN >= 0 && s+ar[posN] <= num) {
                flag = false;
                s += ar[posN];
                posN--;
            }
            if(flag) return k+1;
            if(posN >= 0) check[posN] = 1;
            count++;
        }
        return count;
    }

    static long binary_search() {
        long left, right, mid;
        left = lo;
        right = hi;
        while (left < right) {
            mid=(left+right) >> 1;
            if(partition(mid) <= k) right = mid;
            else left = mid+1;
        }
        return right;
    }

    static void print_ans(){
        int g = (int) partition(ans);
        for(int i=0; i < m-1 && g < k; i++){
            if (check[i] != 1) {
                check[i] = 1;
                g++;
            }
        }
        for(int i=0; i<m; i++) {
            long flag = check[i];
            if(i > 0) System.out.print(" "+ar[i]);
            else System.out.print(ar[i]);
            if(flag == 1) System.out.print(" /");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t;
        t = sc.nextLong();
        while (t-- > 0) {
            hi = 0;
            lo = 0;
            m = sc.nextLong();
            k = sc.nextLong();
            ar = new long[505];
            for(int i=0; i<m; i++) {
                ar[i] = sc.nextLong();
                hi += ar[i];
                if(lo < ar[i]) lo = ar[i];
            }
            ans=binary_search();
            print_ans();
        }
    }
}
