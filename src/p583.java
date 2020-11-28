import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p583 {
    static int N = (int) Math.sqrt(Integer.MAX_VALUE)+1;
    static boolean[] primesTable;
    static ArrayList<Integer> primes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer;
        int n, c, p;
        SieveOfEratosthenes();
        while(true){
            n = sc.nextInt();
            if(n == 0) break;
            answer = "";

            c = Math.abs(n);
            while(c > 1){
                p = findPrime(c);
                answer += p;
                c /= p;
                if(c > 1) answer += " x ";
            }
            if(n < 0) answer = "-1 x "+ answer;
            answer = n+" = "+answer;
            System.out.println(answer);
        }
    }

    static void SieveOfEratosthenes(){
        primesTable = new boolean[N];
        Arrays.fill(primesTable, true);
        primesTable[0] = primesTable[1] = false;
        primes = new ArrayList<>();

        for(int i=2; i<N; i++){
            if(primesTable[i]){
                for(int j=i*i; j<N; j += i){
                    primesTable[j] = false;
                }
                primes.add(i);
            }
        }
    }

    static int findPrime(int n){
        if(n <= N){
            if(primesTable[n]) return n;
        }
        for(Integer prime: primes){
            if(prime > Math.sqrt(n)){
                return n;
            }
            if(n % prime == 0){
                return prime;
            }
        }
        return n;
    }
}
