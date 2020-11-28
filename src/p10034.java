import java.util.Scanner;

public class p10034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        String[] lineSplit;
        int c, n, i, j, count, ds=0;
        double[] x, y;
        double d, sum, dMin;
        boolean[] connect;

        c = Integer.parseInt(sc.nextLine());
        while(c > 0){
            line = sc.nextLine();
            if(line.equals("")) continue;
            c--;
            n = Integer.parseInt(line);
            x = new double[n];
            y = new double[n];
            connect = new boolean[n];
            for(i=0; i<n; i++){
                line = sc.nextLine();
                lineSplit = line.split(" ");
                x[i] = Double.parseDouble(lineSplit[0]);
                y[i] = Double.parseDouble(lineSplit[1]);
            }

            sum = 0;
            count = 1;
            connect[0] = true;
            while(count < n){
                dMin = Double.MAX_VALUE;
                for(i=0; i<n; i++){
                    if(connect[i]){
                        for(j=0; j<n; j++){
                            if(!connect[j]){
                                d = Math.sqrt((Math.pow((x[i] - x[j]), 2)) + (Math.pow((y[i] - y[j]), 2)));
                                if(d < dMin){
                                    dMin = d;
                                    ds = j;
                                }
                            }
                        }
                    }
                }
                if(dMin != Double.MAX_VALUE){
                    count++;
                    connect[ds] = true;
                    sum += dMin;
                }
            }
            System.out.format("%.2f\n", sum);
            if(c > 0) System.out.println();
        }
    }
}
