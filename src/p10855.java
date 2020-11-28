import java.util.Scanner;

public class p10855 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, n, i, d0, d90, d180, d270;

        while (true){
            N = sc.nextInt();
            n = sc.nextInt();
            if(N == 0 && n == 0) break;

            char[][] map_N = new char[N][N];
            char[][] map_n = new char[n][n];
            for(i=0; i<N; i++){
                map_N[i] = sc.next().toCharArray();
            }
            for(i=0; i<n; i++){
                map_n[i] = sc.next().toCharArray();
            }

            d0 = count(map_N, map_n, N, n);
            map_n = rotated(map_n, n);
            d90 = count(map_N, map_n, N, n);
            map_n = rotated(map_n, n);
            d180 = count(map_N, map_n, N, n);
            map_n = rotated(map_n, n);
            d270 = count(map_N, map_n, N, n);

            System.out.println(d0+" "+d90+" "+d180+" "+d270);
        }
    }

    public static char[][] rotated(char[][] map, int n){
        int i, j, p;
        char[][] new_map = new char[n][n];
        for(j=0; j<n; j++){
            p=n-1;
            for(i=0; i<n; i++){
                new_map[j][p--] = map[i][j];
            }
        }
        return new_map;
    }

    public static int count(char[][] map_N, char[][] map_n, int N, int n){
        int i, j, k, m, c = 0;
        boolean check;
        for(i=0; i<N; i++){
            for(j=0; j<N; j++){
                if(i+n-1<N && j+n-1<N){
                    check = true;
                    for(k=0; k<n; k++){
                        for(m=0; m<n; m++){
                            if(map_n[k][m] != map_N[i+k][j+m]){
                                check = false;
                                break;
                            }
                        }
                        if(!check) break;
                    }
                    if(check) c++;
                }
            }
        }
        return c;
    }
}
