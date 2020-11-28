import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String... doYourBest) {
        int[] a = new int[3];
        test(a);
        System.out.println(Arrays.toString(a));

    }

    static void test(int[] b) {
        b[0] = 99;
    }

}


