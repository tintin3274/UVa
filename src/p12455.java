import java.util.ArrayList;
import java.util.Scanner;

public class p12455 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, expected, sum, n, i, j;
        t = sc.nextInt();

        while(t-- > 0){
            expected = sc.nextInt();
            n = sc.nextInt();
            ArrayList<Integer> set = new ArrayList<>();
            for(i=0; i<n; i++){
                set.add(sc.nextInt());
            }
            boolean yes = false;
            for(i=0; i < (1<<n); i++){
                sum = 0;
                for(j=0; j<n; j++){
                    if(((i>>j) & 1) == 1){
                        sum += set.get(j);
                    }
                }
                if(sum == expected){
                    yes = true;
                    break;
                }
            }
            System.out.println((yes ? "YES" : "NO"));
        }
    }
}
