import java.util.HashMap;
import java.util.Scanner;

public class p10295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n, value;
        StringBuilder description;
        String job, input;
        String[] words;
        HashMap<String, Integer> jobs = new HashMap<>();
        m = sc.nextInt();
        n = sc.nextInt();
        while (m-- > 0){
            job = sc.next();
            value = sc.nextInt();
            jobs.put(job, value);
        }
        while (n > 0){
            description = new StringBuilder();
            while (!(input = sc.nextLine()).equals(".")){
                description.append(input).append(" ");
            }
            n--;
            value = 0;
            words = description.toString().split(" ");
            for (String word : words) {
                if (jobs.containsKey(word))
                    value += jobs.get(word);
            }
            System.out.println(value);
        }
    }
}
