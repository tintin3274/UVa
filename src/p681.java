import java.io.IOException;
import java.util.*;

public class p681 {
    public static Point firstPoint;

    public static class Point implements Comparable<Point>
    {
        public int y;
        public int x;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public double angle()
        {
            return Math.atan2((double) (y - firstPoint.y), (double) (x - firstPoint.x));
        }

        public double size()
        {
            return Math.sqrt((long) (x - firstPoint.x) * (long) (x - firstPoint.x) + (long) (y - firstPoint.y) * (long) (y - firstPoint.y));
        }

        @Override
        public int compareTo(Point p2)
        {
            if (Math.abs(this.angle() - p2.angle()) < 1e-5)
                if (this.size() < p2.size())
                    return -1;
                else if (this.size() > p2.size())
                    return 1;
                else
                    return 0;
            if (this.angle() < p2.angle())
                return -1;
            return 1;
        }
    }

    public static void main(String... as) throws IOException
    {
        Scanner sc;
        sc = new Scanner(System.in);

        int numberOfPoints;
        List<Point> pointList = new ArrayList<Point>();
        int x, y;
        Point pWithLowestY = null;
        Point tempPoint = null;
        int testcases = sc.nextInt();

        System.out.println(testcases);

        for (; testcases > 0; testcases--)
        {
            // prepare new testcase
            pointList.clear();
            pWithLowestY = null;

            // start testcase

            numberOfPoints = sc.nextInt();
            if (numberOfPoints == -1)
            {
                System.out.println(-1);
                numberOfPoints = sc.nextInt();
            }

            // to number of points "-1" cause we dont need the last point since its equal to the first one
            for (int p = 0; p < numberOfPoints - 1; p++)
            {
                x = sc.nextInt();
                y = sc.nextInt();
                tempPoint = new Point(x, y);

                if (pWithLowestY == null)
                    pWithLowestY = tempPoint;
                else if (pWithLowestY.y > tempPoint.y || (pWithLowestY.y == tempPoint.y && pWithLowestY.x > tempPoint.x))
                    pWithLowestY = tempPoint;

                pointList.add(tempPoint);
            }

            //read last point not added to the pointlist (same as first)
            x = sc.nextInt();
            y = sc.nextInt();

            // move the point with lowest y  coordinate to index 0
            Collections.swap(pointList, 0, pointList.indexOf(pWithLowestY));

            // save the first point
            firstPoint = pWithLowestY;

            // sort points by polar coordinate angle
            Collections.sort(pointList);

            // add the first point at the end to close the polygon
            pointList.add(new Point(pWithLowestY.x, pWithLowestY.y));

            // start with graham scan, always take the most right point from the current point.
            int i = 2;
            while (i < pointList.size())
            {
                // if the points are in one line, remove the middle point
                if (ccw(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i)) == 0)
                {
                    pointList.remove(i - 1);
                }
                else
                {
                    // if the points are directed to the left, its ok
                    if (ccw(pointList.get(i - 2), pointList.get(i - 1), pointList.get(i)) > 0)
                    {
                        i++;
                    }
                    // if they are directed "concave", remove the middle one and go back
                    else
                    {
                        pointList.remove(i - 1);
                        i--;
                    }
                }
            }

            System.out.println(pointList.size());

            for (Point p : pointList)
            {
                System.out.println(String.format("%d %d", p.x, p.y));
            }
        }
    }

    /**
     * Calculates the cross product between the three given points.
     *
     * @return sth. < 0 if the direction p0->p1->p2 is "concave"
     */
    public static int ccw(Point p0, Point p1, Point p2)
    {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p1.y - p0.y) * (p2.x - p0.x);
    }
}
