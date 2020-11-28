import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p417 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Index = 1;

        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        for (char c = 'a'; c <= 'z'; c++){
            map.put(Character.toString(c), Index++);
            que.add(Character.toString(c));
        }
        while (!que.isEmpty()) {
            String s = que.poll();
            char last = s.charAt(s.length() - 1);
            if (s.length() == 5 || last == 'z')
                continue;
            for (char next = ++last; next <= 'z'; next++){
                que.add(s + next);
                map.put(s + next, Index++);
            }
        }

        while (sc.hasNext()){
            Integer answer = map.get(sc.next());
            System.out.println(answer == null ? 0 : answer);
        }
    }
}
