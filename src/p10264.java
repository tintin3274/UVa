import java.util.Scanner;

public class p10264 {
    static boolean neighbor(int i, int j){
        int n = i ^ j;
        return (n & (-n)) == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, n, x, max;

        while(sc.hasNext()){
            n = sc.nextInt();
            max = 0;
            int[] potency = new int[1<<n];

            for(i=0; i < (1<<n); i++){
                x = sc.nextInt();
                for(j=0; j < (1<<n); j++){
                    if(neighbor(i, j) && i!=j) potency[j]+=x;
                }
            }

            for(i=0; i < (1<<n); i++){
                for(j=0; j < (1<<n); j++){
                    if(neighbor(i, j) && i!=j)
                        max = Integer.max(max, potency[i]+potency[j]);
                }
            }
            System.out.println(max);
        }
    }
}


//boolean b = (n & (-n)) == n;
//System.out.println("i:"+i+" j:"+j+" n:"+n+" "+b);
