import java.util.Scanner;

public class p1388 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        double pos, ans;
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            ans = 0;
            for (int i = 1; i < n; i++) {
                pos = (i * 1.0 / n) * (n + m);
                ans += Math.abs(pos - Math.floor(pos + 0.5)) / (n + m);
            }
            System.out.printf("%.4f\n", ans * 10000);
        }

    }
}

