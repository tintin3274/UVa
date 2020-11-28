import java.util.Scanner;

public class p10189 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, i, j, c=1;

        while (true){
            n = sc.nextInt();
            m = sc.nextInt();
            if(n == 0 && m == 0) break;
            if(c>1) System.out.println();

            int[][] map = new int[n][m];
            for(i=0; i<n; i++){
                char[] line = sc.next().toCharArray();
                for(j=0; j<m; j++){
                    if(line[j] == '*'){
                        map[i][j] = -1;

                        if(i-1 >= 0 && j-1 >= 0 && map[i-1][j-1] >= 0) map[i-1][j-1]++;
                        if(i-1 >= 0 && map[i-1][j] >= 0) map[i-1][j]++;
                        if(i-1 >= 0 && j+1 < m && map[i-1][j+1] >= 0) map[i-1][j+1]++;

                        if(j-1 >= 0 && map[i][j-1] >= 0) map[i][j-1]++;
                        if(j+1 < m && map[i][j+1] >= 0) map[i][j+1]++;

                        if(i+1 < n && j-1 >= 0 && map[i+1][j-1] >= 0) map[i+1][j-1]++;
                        if(i+1 < n && map[i+1][j] >= 0) map[i+1][j]++;
                        if(i+1 < n && j+1 < m && map[i+1][j+1] >= 0) map[i+1][j+1]++;
                    }
                }
            }
            System.out.println("Field #"+ c++ +":");
            for(i=0; i<n; i++){
                for(j=0; j<m; j++){
                    if(map[i][j] == -1) System.out.print("*");
                    else System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
