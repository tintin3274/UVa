import java.util.Scanner;

public class p10341 {
    static double EPS = 0.0000000001;
    static int p, q, r, s, t, u;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double lo, hi, mid;
        while(sc.hasNext()){
            p = sc.nextInt();
            q = sc.nextInt();
            r = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            u = sc.nextInt();
            if(f(1)*f(0) > 0) System.out.println("No solution");
            else{
                lo = 0; hi = 1;
                if(f(1) < f(0)){
                    lo = 1;
                    hi = 0;
                }
                while(Math.abs(hi-lo) > EPS){
                    mid = (lo+hi) / 2.0;
                    if(f(mid) < 0) lo = mid;
                    else hi = mid;
                }
                System.out.printf("%.4f\n", (lo+hi) / 2.0);
            }
        }
    }
    static double f(double x){
        return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * Math.pow(x, 2) + u;
    }
}
