import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class p11503 {
    static class UnionFind{
        static ArrayList<Integer> p;
        static ArrayList<Integer> rank;
        static HashMap<String, Integer> name;
        static ArrayList<Integer> ps;
        static int order;

        public UnionFind(){
            p = new ArrayList<>();
            rank = new ArrayList<>();
            name = new HashMap<>();
            ps = new ArrayList<>();
            order = 0;
        }

        static int findSet(int i){
            if(p.get(i) == i) return i;
            else{
                p.set(i, findSet(p.get(i)));
                return p.get(i);
            }
        }
        static boolean isSameSet(int i, int j){
            return findSet(i) == findSet(j);
        }
        static void unionSet(int i, int j){
            if(!isSameSet(i, j)){
                int x = findSet(i);
                int y = findSet(j);
                if(rank.get(x) > rank.get(y)){
                    ps.set(x, ps.get(x)+ps.get(y));
                    p.set(y, x);
                }
                else{
                    ps.set(y, ps.get(x)+ps.get(y));
                    p.set(x, y);
                    if(rank.get(x) == rank.get(y)){
                        rank.set(y, rank.get(y)+1);
                    }
                }
            }
        }
        static void createFriend(String a){
            p.add(order);
            rank.add(0);
            name.put(a, order);
            ps.add(1);
            order++;
        }
        static int makeFriend(String a, String b){
            if(!name.containsKey(a)) createFriend(a);
            if(!name.containsKey(b)) createFriend(b);
            unionSet(name.get(a), name.get(b));
            return ps.get(findSet(name.get(a)));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a, b;
        int n, c;
        c = sc.nextInt();
        while(c-- > 0){
            n = sc.nextInt();
            UnionFind UF = new UnionFind();
            while(n-- > 0){
                a = sc.next();
                b = sc.next();
                System.out.println(UF.makeFriend(a, b));
            }
        }
    }
}
