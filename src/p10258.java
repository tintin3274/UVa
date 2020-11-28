import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p10258 {
    static class Team{
        int name, correct, score;
        int[] problems = new int[9];

        public Team(int name){
            this.name = name;
            correct = 0;
            score = 0;
        }

        public void check(int problem, int time, boolean check){
            if(problems[problem-1] >= 0 && check){
                correct++;
                score += (time + (problems[problem-1] * 20));
                problems[problem-1] = -1;
            }
            else if(problems[problem-1] >= 0 && !check) problems[problem-1]++;
        }

        @Override
        public String toString() {
            return name+" "+correct+" "+score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        int b, n, i, p, t;
        boolean unlock = false;
        String r, line;
        String answer = "";
        b = Integer.parseInt(br.readLine());

        i=0;
        while(i<b){
            HashMap<Integer, Team> names = new HashMap<>();
            ArrayList<Team> contestants = new ArrayList<>();
            while ((line = br.readLine()) != null && line.length() > 0 && !line.equals("")){
                unlock = true;
                String[] input = line.split(" ");
                n = Integer.parseInt(input[0]);
                p = Integer.parseInt(input[1]);
                t = Integer.parseInt(input[2]);
                r = input[3];

                if(!names.containsKey(n)){
                    Team contestant = new Team(n);
                    names.put(n, contestant);
                    contestants.add(contestant);
                }

                if(r.equals("C")) names.get(n).check(p, t, true);
                else if(r.equals("I")) names.get(n).check(p, 20, false);
            }
            if(unlock){
                contestants.sort(new Comparator<Team>() {
                    @Override
                    public int compare(Team o1, Team o2) {
                        if(o1.correct != o2.correct) return o2.correct - o1.correct;
                        if(o1.score != o2.score) return o1.score - o2.score;
                        if(o1.name != o2.name) return o1.name - o2.name;
                        return 0;
                    }
                });
                for(Team c : contestants){
                    answer += c.toString()+"\n";
                }
                unlock = false;
                i++;
                answer += "\n";
            }
        }
        System.out.print(answer.substring(0, answer.length()-1));
    }
}
