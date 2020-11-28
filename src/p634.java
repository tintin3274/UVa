import java.util.Scanner;

public class p634 {
    static class Point {
        double x, y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, cnt;
        Point[] p = new Point[1005];
        Point q;

        while (true) {
            n = sc.nextInt();
            if(n == 0) break;
            for(i=0; i<n; i++) {
                p[i] = new Point(sc.nextDouble(), sc.nextDouble());
            }
            q = new Point(sc.nextDouble(), sc.nextDouble());
            cnt = 0;
            for(i=0, j=n-1; i<n; j=i++) {
                if(p[i].y > q.y != p[j].y > q.y && q.x < (p[j].x-p[i].x)*(q.y-p[i].y)/(p[j].y-p[i].y)+p[i].x) cnt++;
            }
            if((cnt&1) == 1) System.out.println("T");
            else System.out.println("F");
        }
    }
}
