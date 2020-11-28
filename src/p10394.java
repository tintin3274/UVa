import java.util.Arrays;
import java.util.Scanner;

public class p10394 {
    static int N = 20000000;
    static int[] tprime;
    static boolean[] primesTable;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s;
        Sieve();
        twin_prime();
        while (sc.hasNext()){
            s = sc.nextInt();
            System.out.println("("+tprime[s]+", "+((tprime[s])+2)+")");
        }
    }

    static void Sieve(){
        primesTable = new boolean[N+10];
        Arrays.fill(primesTable, true);

        int i,j;
        for(i=4;i<=20000000;i+=2)
        {
            primesTable[i]=false;
        }
        for(i=3;i*i<=20000000;i+=2)
        {
            if(primesTable[i])
            {
                for(j=i*i;j<=20000000;j+=i+i)
                {
                    primesTable[j]=false;
                }
            }
        }
    }

    static void twin_prime()
    {
        tprime = new int[N+10];
        int j=1;
        for(int i = 3;i<=N;i++){
            if(primesTable[i] && primesTable[i+2])
            {
                tprime[j++] = i;
            }
        }
    }
}
