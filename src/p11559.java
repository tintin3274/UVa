import java.util.Scanner;

public class p11559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, b, h, w, p, a, i, j, price;

        while (sc.hasNext()){
            price=Integer.MAX_VALUE;
            n = sc.nextInt();
            b = sc.nextInt();
            h = sc.nextInt();
            w = sc.nextInt();
            for(i=0; i<h; i++){
                p = sc.nextInt();
                for(j=0; j<w; j++){
                    a = sc.nextInt();
                    if(a>=n && (n*p) <= b){
                        if(n*p < price) price = n*p;
                    }
                }
            }
            if(price <= b) System.out.println(price);
            else System.out.println("stay home");
        }
    }
}
