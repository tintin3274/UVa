import java.util.Scanner;

public class p507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, b, i, n, s, start, final_start, final_end, max, sum;
        b = sc.nextInt();
        for(r=1; r<=b; r++){
            s = sc.nextInt();
            max = 0;
            sum = -1;
            start = 0;
            final_start = -1;
            final_end = -1;

            for(i=1; i<s; i++){
                n = sc.nextInt();
                if(sum >= 0) sum += n;
                else{
                    sum = n;
                    start = i;
                }
                if(sum > max || (sum == max) && (i+1-start > final_end-final_start)){
                    max = sum;
                    final_end = i+1;
                    final_start = start;
                }
            }
            if(max == 0)
                System.out.println("Route "+r+" has no nice parts");
            else
                System.out.println("The nicest part of route "+ r +" is between stops "+final_start+" and "+final_end);
        }
    }
}
