import java.util.HashMap;
import java.util.Scanner;

public class p11235 {
    static class SegmentTree{
        static int[] st, cnt;

        public SegmentTree(int[] count){
            st = new int[3*100005];
            cnt = count;
        }

        static int left(int p){
            return p << 1;
        }
        static int right(int p){
            return (p << 1)+1;
        }
        static void build(int p, int L, int R){
            if(L==R)
                st[p] = cnt[L];
            else{
                build(left(p), L, (L+R)/2);
                build(right(p), (L+R)/2+1, R);
                int p1 = st[left(p)];
                int p2 = st[right(p)];
                st[p] = Integer.max(p1, p2);
            }
        }
        static int query(int p, int L, int R, int i, int j){
            if(i > R || j < L) return -1;
            if(L >= i && R <= j) return st[p];

            int p1 = query(left(p), L, (L+R)/2, i, j);
            int p2 = query(right(p), (L+R)/2+1, R, i, j);

            return Integer.max(p1, p2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, k, n, tc, f, qlow, qhigh, cnt1, cnt2, cnt3;

        while(true){
            n = sc.nextInt();
            if(n==0) break;
            tc = sc.nextInt();
            int[] input = new int[n+1];
            int[] count = new int[n+1];
            int[] start = new int[n+1];
            HashMap<Integer, Integer> countHashMap = new HashMap<>();

            f=1;
            for(i=1; i<=n; i++){
                input[i] = sc.nextInt();
                if(!countHashMap.containsKey(input[i])){
                    countHashMap.put(input[i], 1);
                }
                else{
                    countHashMap.replace(input[i], countHashMap.get(input[i])+1);
                }
                if(i>1 && input[i-1] != input[i]) f = i;
                start[i] = f;
            }
            for(i=1; i<=n; i++){
                count[i] = countHashMap.get(input[i]);
            }

            SegmentTree ST = new SegmentTree(count);
            ST.build(1, 1, n);

            while(tc-- > 0){
                qlow = sc.nextInt();
                qhigh = sc.nextInt();
                if(input[qlow] == input[qhigh]) System.out.println(qhigh-qlow+1);
                else{
                    k = start[qlow]+count[qlow];
                    cnt1 = k-qlow;
                    cnt2 = qhigh-start[qhigh]+1;
                    cnt3 = ST.query(1, 1, n, k, start[qhigh]-1);
                    System.out.println(Integer.max(Integer.max(cnt1, cnt2), cnt3));
                }
            }
        }
    }
}
