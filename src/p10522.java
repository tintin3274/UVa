import java.util.Scanner;

public class p10522 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double a, b, c, s;

        n = sc.nextInt();
        while (n > 0) {
            a = sc.nextDouble();
            b = sc.nextDouble();
            c = sc.nextDouble();

            a = 1.0/a;
            b = 1.0/b;
            c = 1.0/c;
            s = (a+b+c) * (a+b-c) * (a+c-b) * (b+c-a);
            if(s >= 0 && 1.0/Math.sqrt(s) != Double.POSITIVE_INFINITY) System.out.printf("%.3f\n", 1.0/Math.sqrt(s));
            else {
                System.out.println("These are invalid inputs!");
                n--;
            }
        }
    }
}
