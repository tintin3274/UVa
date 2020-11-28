import java.util.Scanner;

public class p11933 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, i, t;

        while ((n=sc.nextInt()) != 0){
            a = 0;
            b = 0;
            i = 1;
            while (n > 0){
                t = n & (-n);
                if(i % 2 == 1) a = a | t;
                else b = b | t;
                i++;
                n = n ^ t;
            }
            System.out.println(a+" "+b);
        }
    }
}
