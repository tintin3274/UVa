import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p10937 {
    static int xx[] = { 0, 0, 1, -1, 1, -1, 1, -1 };
    static int yy[] = { 1, -1, 0, 0, 1, -1, -1, 1 };
    static int h, w;
    static char map[][];
    static int end;
    static int top;
    static int dp[][];
    static int matrix[][];

    public static int tsp(int i, int mask) {
        // System.out.println(i+" "+mask);
        if (mask == end)
            return matrix[i][0];
        if (i >= top)
            return 1 << 25;
        if (dp[i][mask] != -1)
            return dp[i][mask];
        int min = 1 << 25;
        for (int j = 0; j < top; j++)
            if ((mask & (1 << j)) == 0 && matrix[i][j] != 0) {

                min = Math.min(min, matrix[i][j] + tsp(j, (mask | (1 << j))));

            }
        return dp[i][mask] = min;
    }

    public static boolean valid(int i, int j, char map[][]) {
        if (i > -1 && i < h && j > -1 && j < w)
            return true;
        return false;
    }

    public static void bfs(int in, int sy, int sx) {
        boolean v[][] = new boolean[h][w];

        // char ma[][] = new char[map.length][];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(sy);
        q.add(sx);

        q.add(0);
        q.add(in);
        // q.add(0);
        // q.add(0);
        // System.out.println(in[l][1]);

        v[sy][sx] = true;
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            int t = q.poll();
            int from = q.poll();

            int curr = (int) (map[i][j] - '0');

            if (curr > -1 && curr < top) {
                matrix[from][curr] = t;
                matrix[curr][from] = t;
            }

            for (int k = 0; k < 4; k++) {
                int ny = i + yy[k];
                int nx = j + xx[k];

                if (valid(ny, nx, map) && !v[ny][nx] && map[ny][nx] != '#') {
                    // System.out.println(ny+" "+nx);
                    q.add(ny);
                    q.add(nx);
                    q.add(t + 1);
                    q.add(from);
                    v[ny][nx] = true;
                }

            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s[] = reader.readLine().split(" ");
        h = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);
        int in[][] = new int[12][2];
        map = new char[55][55];
        while (h != 0 || w != 0) {
            top=0;
            for (int i = 0; i < h; i++)
                map[i] = reader.readLine().toCharArray();

            int count = 1;
            boolean tt = false;
            boolean found = false;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(map[i][j]=='!')
                        top++;
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        for (int k = 0; k < 8; k++) {
                            int nx = j + xx[k];
                            int ny = i + yy[k];
                            if (valid(ny, nx, map) && map[ny][nx] != '*') {
                                map[ny][nx] = '#';
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '~') {
                        map[i][j] = '#';
                    } else if (map[i][j] == '*')
                        map[i][j] = '#';
                    else if (map[i][j] == '!') {
                        in[count][0] = i;
                        in[count][1] = j;
                        map[i][j] = (char) (count + '0');
                        count++;
                    } else if (map[i][j] == '@') {
                        in[0][0] = i;
                        in[0][1] = j;
                        map[i][j] = '0';
                        found = true;
                    } else if (map[i][j] != '.')
                        map[i][j] = '#';
                }
            }
            top++;
            matrix = new int[top][top];

            end = (int) (Math.pow(2, top) - 1);

            dp = new int[top][end + 1];

            for (int i = 0; i < top; i++)
                Arrays.fill(dp[i], -1);

            // System.out.println("tt");
            //  System.out.println(top+" "+count);
            if (!found) {

                System.out.println(-1);

            }else if(top!=count){

                System.out.println(-1);
            }
            else {
                // System.out.println(map.length);
                // for (int i = 0; i < h; i++){
                // for(int j=0;j<w;j++){
                // System.out.print(map[i][j]+" ");
                // }
                // System.out.println();
                // }
                //

                for (int i = 0; i < top; i++)
                    bfs(i, in[i][0], in[i][1]);
                tt=false;
                for (int i = 1; i < count && !found; i++)
                    if (matrix[0][i] == 0) {
                        tt = true;
                    }
                // for (int i = 0; i < matrix.length; i++)
                // System.out.println(Arrays.toString(matrix[i]));
                // System.out
                // .println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

                if (tt) {
                    // System.out.println("lo");
                    System.out.println(-1);
                } else {
                    int k = tsp(0, 1);
                    if (k < (1 << 25))
                        System.out.println(k);
                    else
                        System.out.println(-1);
                }
            }
            s = reader.readLine().split(" ");
            h = Integer.parseInt(s[0]);
            w = Integer.parseInt(s[1]);
        }
    }
}