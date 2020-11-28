import java.util.Scanner;

public class p11764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, n, i, j, up, down, previous, current;
        t = sc.nextInt();
        for(i=0; i<t; i++){
            n = sc.nextInt();
            up = 0;
            down = 0;
            previous = sc.nextInt();
            for(j=1; j<n; j++){
                current = sc.nextInt();
                if(previous < current) up++;
                else if(previous > current) down++;
                previous = current;
            }
            System.out.println("Case "+(i+1)+": "+up+" "+down);
        }
    }
}
