import java.util.*;

public class p10172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int set, N, S, Q, Qi, numOfCargoes;

        set = sc.nextInt();
        while(set-- > 0){
            N = sc.nextInt();
            S = sc.nextInt();
            Q = sc.nextInt();

            numOfCargoes = 0;
            ArrayList<Queue<Integer>> ring = new ArrayList<>();
            for(int i=0; i<N; i++){
                Qi = sc.nextInt();
                numOfCargoes += Qi;
                Queue<Integer> platformB = new LinkedList<Integer>();
                for(int j=0; j<Qi; j++){
                    platformB.add(sc.nextInt());
                }
                ring.add(platformB);
            }
            System.out.println(simulateCargos(ring, S, Q, numOfCargoes));
        }
    }

    public static int simulateCargos(List<Queue<Integer>> ring, int cargoSize, int maximumBSize, int numberOfCargos){
        int minutes= 0, i = 0;
        int ringSize = ring.size();
        int currentStation = 1;
        Queue<Integer> platformB = null;
        Stack<Integer> cargo = new Stack<Integer>();

        while(numberOfCargos > 0){
            currentStation = i++ % ringSize;
            platformB = ring.get(currentStation);

            while(cargo.size() > 0){
                if(cargo.peek() == currentStation+1){
                    cargo.pop();
                    minutes++;
                    numberOfCargos--;
                    continue;
                }
                if(platformB.size() < maximumBSize){
                    platformB.add(cargo.pop());
                    minutes++;
                }
                else break;
            }

            while(platformB.size() > 0){
                if(cargo.size() < cargoSize){
                    cargo.push(platformB.poll());
                    minutes++;
                }
                else break;
            }
            if(numberOfCargos > 0) minutes += 2;
        }
        return minutes;
    }
}











