import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p11849 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, count;

        while (true){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n == 0 && m == 0) break;
            Set<Integer> a = new HashSet<>();
            count = 0;
            while (n-- > 0){
                a.add(sc.nextInt());
            }
            while (m-- > 0){
                if(a.contains(sc.nextInt())) count++;
            }
            System.out.println(count);
        }
    }
}
