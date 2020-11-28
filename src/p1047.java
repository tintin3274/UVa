import java.util.ArrayList;
import java.util.Scanner;

public class p1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k, n, c, a, t, toBuild, max, actualArea, best, caseNumber=1;
        while(true){
            n = sc.nextInt();
            toBuild = sc.nextInt();
            if(n == 0 && toBuild == 0) break;
            int[] pole = new int[n];
            ArrayList<Integer> commonAreas = new ArrayList<>();
            ArrayList<Integer> commonAreasValue = new ArrayList<>();

            for(i=0; i<n; i++){
                pole[i] = sc.nextInt();
            }

            c = sc.nextInt();
            for(i=0; i<c; i++){
                a = sc.nextInt();
                t = 0;
                for(j=0; j<a; j++){
                    t |= 1<<(sc.nextInt()-1);
                }
                commonAreas.add(t);
                commonAreasValue.add(sc.nextInt());
            }
            max = 0;
            best = 0;
            for(k=1; k < (1<<n); k++){
                if(countOne(k) != toBuild) continue;
                actualArea = 0;

                for(i=0 ; i<n ; i++){
                    if((k & (1<<i)) > 0){
                        actualArea += pole[i];
                    }
                }

                for(i=0; i<commonAreas.size(); i++){
                    int tmp = commonAreas.get(i)&k;
                    if(tmp > 1)
                    actualArea -= (countOne(tmp)-1)*commonAreasValue.get(i);
                }

                if(actualArea > max){
                    max = actualArea;
                    best = k;
                }
            }
            System.out.println("Case Number  "+caseNumber);
            System.out.println("Number of Customers: "+max);
            System.out.print("Locations recommended:");
            for(i=0; i<n; i++){
                if((best & (1<<i)) > 0) System.out.print(" "+(i+1));
            }
            System.out.println("\n");
            caseNumber++;
        }

    }
    static int countOne(int i){
        int count = 0;
        while(i > 0){
            count++;
            i -= (i&(-i));
        }
        return count;
    }
}
