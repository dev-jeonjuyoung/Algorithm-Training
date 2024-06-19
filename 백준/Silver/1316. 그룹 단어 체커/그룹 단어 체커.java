import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            char[] word = br.readLine().toCharArray();

            Set<Character> set = new HashSet<>();
            char prevChar = word[0];
            set.add(prevChar);

            for (int j = 1; j < word.length; j++) {
                if (prevChar == word[j])
                    continue;
                if (set.contains(word[j])) {
                    cnt++;
                    break;
                }
                prevChar = word[j];
                set.add(prevChar);
            }
        }
        System.out.println(N-cnt);
    }
}