import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        char[] lineSplit;
        boolean[] wakeup;
        boolean allWake;
        int n, m, i, j, count, year, connect;

        while (sc.hasNext()){
            line = sc.nextLine();
            if(line.equals("")) continue;

            n = Integer.parseInt(line);
            m = Integer.parseInt(sc.nextLine());
            line = sc.nextLine();
            lineSplit = line.toCharArray();

            ArrayList<Integer>[] adjList = new ArrayList[26];
            for(i=0; i<26; i++){
                adjList[i] = new ArrayList<>();
            }
            wakeup = new boolean[26];

            for(char c : lineSplit){
                i = c - 'A';
                wakeup[i] = true;
            }
            while(m-- > 0){
                line = sc.nextLine();
                lineSplit = line.toCharArray();
                i = lineSplit[0] - 'A';
                j = lineSplit[1] - 'A';
                adjList[i].add(j);
                adjList[j].add(i);
            }

            allWake = true;
            count = 3;
            year = 0;
            Queue<Integer> queue = new LinkedList<>();
            while(count < n){
                for(i=0; i<26; i++){
                    if(!wakeup[i]){
                        connect = 0;
                        for(int a : adjList[i]){
                            if(wakeup[a]) connect++;
                        }
                        if(connect >= 3){
                            queue.add(i);
                            count++;
                        }
                    }
                }
                if(queue.size() > 0){
                    while(!queue.isEmpty()){
                        wakeup[queue.remove()] = true;
                    }
                    year++;
                }
                else{
                    allWake = false;
                    break;
                }
            }
            if(allWake) System.out.println("WAKE UP IN, "+year+", YEARS");
            else System.out.println("THIS BRAIN NEVER WAKES UP");
        }
    }
}
