import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        set = new HashSet<>();
        for (int i = 1; i <= 10000; i++) {
            set.add(calc(i));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10000; i++) {
            if (set.contains(i))
                continue;
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static int calc(int i) {
        int sum = i;

        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }
}