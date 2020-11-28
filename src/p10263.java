import java.util.Scanner;

public class p10263 {
    static final double eps = 1e-6;

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

    static double distance(Point p, Point q) {
        return Math.sqrt((p.x-q.x)*(p.x-q.x) + (p.y-q.y)*(p.y-q.y));
    }

    static Point foot_point(Point m, Point p, Point q) {
        double A1 = p.x-q.x, B1 = p.y-q.y, C1 = (q.y-p.y)*m.y+(q.x-p.x)*m.x;
        double A2 = q.y-p.y, B2 = p.x-q.x, C2 = (q.x-p.x)*p.y+(p.y-q.y)*p.x;
        double x = (C2*B1-C1*B2)/(A1*B2-A2*B1);
        double y = (C2*A1-C1*A2)/(A2*B1-A1*B2);
        return new Point(x, y);
    }


    static boolean on_line(Point m, Point p, Point q) {
        return (p.x-m.x)*(q.x-m.x) <= eps && (p.y-m.y)*(q.y-m.y) <= eps;
    }

    static Point closest_point_on_segment(Point m, Point p, Point q) {
        Point ans = foot_point(m, p, q);
        if(!on_line(ans, p, q)) {
            if(distance(m, p) - distance(m, q) > eps) return q;
            else return p;
        }
        else return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Point M, P1, P2;
        int n;
        while (sc.hasNext()) {
            M = new Point(sc.nextDouble(), sc.nextDouble());
            n = sc.nextInt();
            P1 = new Point(sc.nextDouble(), sc.nextDouble());
            Point ans = P1;
            double min_dist = distance(M, P1);
            while (n-- > 0) {
                P2 = new Point(sc.nextDouble(), sc.nextDouble());
                Point Q = closest_point_on_segment(M, P1, P2);
                if(distance(M, ans) - distance(M, Q) > eps) ans = Q;
                P1 = P2;
            }
            System.out.printf("%.4f\n%.4f\n", ans.x, ans.y);
        }
    }
}
