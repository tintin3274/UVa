import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, B, SG, SB, i, count, a, b;

        n = sc.nextInt();
        while (n-- > 0){
            B = sc.nextInt();
            SG = sc.nextInt();
            SB = sc.nextInt();
            PriorityQueue<Integer> QG = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> QB = new PriorityQueue<>(Collections.reverseOrder());
            for(i=0; i<SG; i++){
                QG.add(sc.nextInt());
            }
            for(i=0; i<SB; i++){
                QB.add(sc.nextInt());
            }
            while(true){
                if(QG.isEmpty() && QB.isEmpty()){
                    System.out.println("green and blue died");
                    break;
                }
                else if(QG.isEmpty()){
                    System.out.println("blue wins");
                    while(!QB.isEmpty()){
                        System.out.println(QB.poll());
                    }
                    break;
                }
                else if(QB.isEmpty()){
                    System.out.println("green wins");
                    while(!QG.isEmpty()){
                        System.out.println(QG.poll());
                    }
                    break;
                }
                else{
                    count = 0;
                    ArrayList<Integer> LG = new ArrayList<>();
                    ArrayList<Integer> LB = new ArrayList<>();
                    while(!QG.isEmpty() && !QB.isEmpty() && count < B){
                        a = QG.poll();
                        b = QB.poll();
                        if (a > b) {
                            LG.add(a - b);
                        } else if (b > a) {
                            LB.add(b - a);
                        }
                        count++;
                    }
                    QG.addAll(LG);
                    QB.addAll(LB);
                }
            }
        if(n > 0) System.out.println();
        }
    }
}
