import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p11450 {
    static int T, M, C;
    static int dp[][];
    static int price[][];

    static int shop(int money, int g) {
        if(money < 0) return -1;
        if(g == C) return M - money;
        if(dp[money][g] != -1) return dp[money][g];
        for(int i = 1; i <= price[g][0]; i++) {
            dp[money][g] = Math.max(dp[money][g], shop(money - price[g][i], g+1));
        }
        return dp[money][g];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            s = br.readLine().split(" ");
            M = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            price = new int[25][25];
            dp = new int[205][25];
            for(int i = 0; i < C; i++) {
                s = br.readLine().split(" ");
                price[i][0] = Integer.parseInt(s[0]);
                for(int j = 1; j <= price[i][0]; j++) {
                    price[i][j] = Integer.parseInt(s[j]);
                }
            }
            for (int i=0; i < dp.length; i++){
                Arrays.fill(dp[i], -1);
            }
            int ans = shop(M, 0);
            if(ans < 0) System.out.println("no solution");
            else System.out.println(ans);
        }
    }
}
