import java.util.Scanner;

public class p573 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        float h, u, d, f, l, uf;
        while (true){
            h = sc.nextInt();
            if(h==0) break;
            uf = sc.nextInt();
            d = sc.nextInt();
            f = sc.nextInt();
            count=1;
            l=0;
            u = uf;
            while (true){
                l += u;
                if(l>h){
                    System.out.println("success on day "+count);
                    break;
                }
                l -= d;
                if(l<0){
                    System.out.println("failure on day "+count);
                    break;
                }
                if(count*f <= 100) u = uf * (1 - (count * (f/(float)100.0)));
                else u = 0;
                count++;
            }
        }
    }
}