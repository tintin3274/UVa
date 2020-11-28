import java.util.Scanner;

public class p11831 {
    static int NORTH = 0;
    static int EAST = 1;
    static int SOUTH = 2;
    static int WEST = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, s, i, ry, rx, direction, count;
        String line;
        String[] lineSplit;

        while (true){
            line = sc.nextLine();
            lineSplit = line.split(" ");
            n = Integer.parseInt(lineSplit[0]);
            m = Integer.parseInt(lineSplit[1]);
            s = Integer.parseInt(lineSplit[2]);
            if(n==0 && m==0 && s==0) break;

            direction = NORTH;
            ry=0; rx=0;
            char[][] map = new char[n][m];
            for(i=0; i<n; i++){
                line = sc.nextLine();
                if(line.contains("N")){
                    direction = NORTH;
                    ry = i;
                    rx = line.indexOf("N");
                    line = line.replace("N", ".");
                }
                else if(line.contains("L")){
                    direction = EAST;
                    ry = i;
                    rx = line.indexOf("L");
                    line = line.replace("L", ".");
                }
                else if(line.contains("S")){
                    direction = SOUTH;
                    ry = i;
                    rx = line.indexOf("S");
                    line = line.replace("S", ".");
                }
                else if(line.contains("O")){
                    direction = WEST;
                    ry = i;
                    rx = line.indexOf("O");
                    line = line.replace("O", ".");
                }
                map[i] = line.toCharArray();
            }

            count = 0;
            line = sc.nextLine();
            for(char c : line.toCharArray()){
                if(c == 'F'){
                    if(direction == NORTH && ry-1 >= 0 && map[ry-1][rx] != '#') ry--;
                    else if(direction == EAST && rx+1 < m && map[ry][rx+1] != '#') rx++;
                    else if(direction == SOUTH && ry+1 < n && map[ry+1][rx] != '#') ry++;
                    else if(direction == WEST && rx-1 >= 0 && map[ry][rx-1] != '#') rx--;

                    if(map[ry][rx] == '*'){
                        count++;
                        map[ry][rx] = '.';
                    }
                }
                else if(c == 'D'){
                    direction++;
                    if(direction > WEST) direction = NORTH;
                }
                else if(c == 'E'){
                    direction--;
                    if(direction < NORTH) direction = WEST;
                }
            }
            System.out.println(count);
        }
    }
}
