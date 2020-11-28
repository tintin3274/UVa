import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class p787 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, n;
        while (sc.hasNext()){
            ArrayList<Integer> a = new ArrayList<>();
            while ((n = sc.nextInt()) != -999999){
                a.add(n);
            }
            BigInteger max = BigInteger.valueOf(-999999);
            BigInteger prod;
            for(i=0; i<a.size(); i++){
                prod = BigInteger.valueOf(1);
                for(j=i; j<a.size(); j++){
                    prod = prod.multiply(BigInteger.valueOf(a.get(j)));
                    if(prod.compareTo(max) == 1)
                        max = prod;
                }
            }
            System.out.println(max);
        }
    }
}
