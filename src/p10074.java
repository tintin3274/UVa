import java.util.Scanner;

public class p10074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, k, l, width, length, sum, max, area;
        while (true){
            width = sc.nextInt();
            length = sc.nextInt();
            if(width == 0 && length == 0) break;
            int[][] a = new int[width][length];
            int[][] b = new int[width][length];
            for(i=0; i<width; i++){
                for(j=0; j<length; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            for(i=0; i<width; i++){
                for(j=0; j<length; j++){
                    b[i][j] = a[i][j];
                    if(i>0) b[i][j] += b[i-1][j];
                    if(j>0) b[i][j] += b[i][j-1];
                    if(i>0 && j>0) b[i][j] -= b[i-1][j-1];
                }
            }
            max = 0;
            for(i=0; i<width; i++){
                for(j=0; j<length; j++){
                    for(k=i; k<width; k++){
                        for(l=j; l<length; l++){
                            sum = b[k][l];
                            if(i>0) sum -= b[i-1][l];
                            if(j>0) sum -= b[k][j-1];
                            if(i>0 && j>0) sum += b[i-1][j-1];
                            if(sum == 0){
                                area = (k-i+1)*(l-j+1);
                                max = Integer.max(max, area);
                            }
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
