import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s;
        int n, A, B, C, x, y, z, boundary;
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            s = br.readLine().split(" ");
            A = Integer.parseInt(s[0]);
            B = Integer.parseInt(s[1]);
            C = Integer.parseInt(s[2]);

            boolean found = false;
            boundary = (int)Math.sqrt(C);
            for(x = -boundary; x <= boundary; x++) {
                for(y = -boundary; y*y-x*x <= C; y++) {
                    z = A-x-y;
                    if (x == y || y == z || x == z) continue;
                    if (x * y * z != B) continue;
                    if (x*x + y*y + z*z != C) continue;

                    System.out.println(x+" "+y+" "+z);
                    found = true;
                    break;
                }
                if (found) break;
            }
            if(!found) System.out.println("No solution.");
        }
    }
}
