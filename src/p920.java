import java.util.Arrays;
import java.util.Scanner;

public class p920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C, n, i, Y;
        int[] x = new int[105], y = new int[105];
        Point[] p;
        double ans;

        C = sc.nextInt();
        while (C-- > 0) {
            n = sc.nextInt();
            p = new Point[n];
            for(i=0; i<n; i++) {
                p[i] = new Point(sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(p);
            for(i=0; i<n; i++) {
                x[i] = p[i].x;
                y[i] = p[i].y;
            }
            Y = 0;
            ans = 0.0;
            for(i=n-1; i>=0; i--) {
                if(y[i] > Y) {
                    ans += dist(y[i] - Y, x_value(x[i], y[i], x[i+1], y[i+1], Y) - x[i]);
                    Y = y[i];
                }
            }
            System.out.printf("%.2f\n", ans);
        }
    }

    static double dist( double dy, double dx ){
        return Math.sqrt( dx*dx + dy*dy );
    }
    static double x_value(double x1, double y1, double x2, double y2, int y){
        double m = (y2-y1)/(x2-x1);
        double b = y1 - m*x1;
        return (y-b)/m;
    }
}

class Point implements Comparable<Point> {
    public int x, y;
    public Point(){ this.x = 0; this.y = 0; }
    public Point(int X, int Y){ this.x = X; this.y = Y; }
    public int compareTo(Point p){
        if(x==p.x) return y - p.y;
        return x - p.x;
    }
}
