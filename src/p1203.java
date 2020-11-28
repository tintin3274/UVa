import java.util.PriorityQueue;
import java.util.Scanner;

public class p1203 {
    static class Query implements Comparable<Query> {
        int qNum, period, value;

        public Query(int qNum, int period, int value) {
            this.qNum = qNum;
            this.period = period;
            this.value = value;
        }

        @Override
        public int compareTo(Query o) {
            if(value == o.value) return qNum-o.qNum;
            else return value-o.value;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lineSplit;
        String line;
        int n, qNum, period;

        PriorityQueue<Query> pq1 = new PriorityQueue<>();
        PriorityQueue<Query> pq2 = new PriorityQueue<>();
        while(true){
            line = sc.nextLine();
            if(line.equals("#")) break;
            lineSplit = line.split("\\s+");
            qNum = Integer.parseInt(lineSplit[1].trim());
            period = Integer.parseInt(lineSplit[2].trim());
            Query query = new Query(qNum, period, period);
            pq1.add(query);
        }

        n = sc.nextInt();
        while(n > pq2.size()){
            Query q = pq1.poll();
            pq2.add(new Query(q.qNum, q.period, q.value));
            q.value += q.period;
            pq1.add(q);
        }

        while(n-- > 0){
            System.out.println(pq2.poll().qNum);
        }
    }
}
