import java.util.Scanner;

public class p108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k, l, n, sum, max;
        while (sc.hasNext()){
            n = sc.nextInt();
            int[][] a = new int[n][n];
            int[][] b = new int[n][n];
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    b[i][j] = a[i][j];
                    if(i>0) b[i][j] += b[i-1][j];
                    if(j>0) b[i][j] += b[i][j-1];
                    if(i>0 && j>0) b[i][j] -= b[i-1][j-1];
                }
            }
            max = Integer.MIN_VALUE;
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    for(k=i; k<n; k++){
                        for(l=j; l<n; l++){
                            sum = b[k][l];
                            if(i>0) sum -= b[i-1][l];
                            if(j>0) sum -= b[k][j-1];
                            if(i>0 && j>0) sum += b[i-1][j-1];
                            max = Integer.max(max, sum);
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
