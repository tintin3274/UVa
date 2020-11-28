import java.util.Scanner;

public class p594 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, c, t;

        while(sc.hasNext()){
            n = sc.nextInt();
            b = 0;
            c = 4;
            t = 24;
            a = n;
            while (c-- > 0){
                b = b | ((a & 255) << t);
                a >>= 8;
                t -= 8;
            }
            System.out.println(n+" converts to "+b);
        }
    }
}
