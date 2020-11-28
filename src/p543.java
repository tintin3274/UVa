import java.util.Arrays;
import java.util.Scanner;

public class p543 {
    static int N = 1000000;
    static boolean[] primesTable;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b;
        boolean found;
        SieveOfEratosthenes();
        while (true){
            n = sc.nextInt();
            if(n == 0) break;

            found = false;
            for(a=3; a<n; a++){
                if(primesTable[a]){
                    b = n-a;
                    if(primesTable[b]){
                        System.out.println(n + " = " + a + " + " + b);
                        found = true;
                        break;
                    }
                }
            }
            if(!found) System.out.println("Goldbach's conjecture is wrong.");
        }
    }

    static void SieveOfEratosthenes(){
        primesTable = new boolean[N];
        Arrays.fill(primesTable, true);
        primesTable[0] = primesTable[1] = false;

        int len = (int) Math.sqrt(N);
        for(int i=2; i<len; i++){
            if(primesTable[i]){
                for(int j=i*i; j<N; j += i){
                    primesTable[j] = false;
                }
            }
        }

        primesTable[2] = false;
    }
}