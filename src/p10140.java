import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p10140 {
    static int N = 1000000;
    static boolean[] primesTable;
    static ArrayList<Integer> primes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l, u;
        long i, c1, c2, d1, d2;
        String line;
        SieveOfEratosthenes();
        while ((line = br.readLine()) != null && line.length() > 0 && !line.equals("")){
            String[] input = line.split(" ");
            l = Integer.parseInt(input[0].trim());
            u = Integer.parseInt(input[1].trim());

            c1 = c2 = d1 = d2 = 0;
            long close_dist = -1, distant_dist = -1;
            long prev_prime = -1;
            for (i = l; i <= u; i++){
                if (isPrime(i)) {
                    if (prev_prime != -1) {
                        if (close_dist == -1 || i - prev_prime < close_dist) {
                            c1 = prev_prime;
                            c2 = i;
                            close_dist = (i - prev_prime);
                        }
                        if (distant_dist == -1 || i - prev_prime > distant_dist) {
                            d1 = prev_prime;
                            d2 = i;
                            distant_dist = (i - prev_prime);
                        }
                    }
                    prev_prime = i;
                }
            }
            if (close_dist != -1) System.out.println(c1+","+c2+" are closest, "+d1+","+d2+" are most distant.");
            else System.out.println("There are no adjacent primes.");
        }
    }

    static void SieveOfEratosthenes(){
        primesTable = new boolean[N+1];
        Arrays.fill(primesTable, true);
        primesTable[0] = primesTable[1] = false;
        primes = new ArrayList<>();

        for(int i=2; i<=N; i++){
            if(primesTable[i]){
                for(int j=i*i; j<=N; j += i){
                    if(j<0) break;
                    primesTable[j] = false;
                }
                primes.add(i);
            }
        }
    }
    static boolean isPrime(long n){
        if(n <= N){
            return primesTable[(int) n];
        }
        for(Integer prime: primes){
            if(prime > Math.sqrt(n)){
                return true;
            }
            if(n % prime == 0){
                return false;
            }
        }
        return true;
    }
}
