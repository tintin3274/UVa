import java.util.Scanner;

public class p732 {
    static void anagram(String s1, String s2, String stack, String instr) {
        if(s2.isEmpty()){
            if(s1.isEmpty() && stack.isEmpty()){
                System.out.println(instr.trim());
            }
            return;
        }
        if(!s1.isEmpty()){
            anagram(s1.substring(1), s2, s1.charAt(0) + stack, instr + "i ");
        }
        if(!stack.isEmpty() && stack.charAt(0) == s2.charAt(0)){
            anagram(s1, s2.substring(1), stack.substring(1), instr + "o ");
        }
    }

    static void anagram(String s1, String s2) {
        System.out.println("[");
        anagram(s1, s2, "", "");
        System.out.println("]");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s, s1="", s2="";
        while (sc.hasNext()){
            s = sc.next();
            if(!s.isEmpty()){
                if(s1.isEmpty()) s1 = s;
                else if(s2.isEmpty()){
                    s2 = s;
                    anagram(s1, s2);
                    s1 = "";
                    s2 = "";
                }
            }
        }
    }
}


//    anagram("madam", "adamm");
//    anagram("bahama", "bahama");
//    anagram("long", "short");
//    anagram("eric", "rice");
//    anagram("ericc", "rice");