import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String question = br.readLine();

            if (question.charAt(0) == 'P')
                sb.append("skipped");
            else {
                String[] plus = question.split("\\+");
                sb.append(Integer.parseInt(plus[0]) + Integer.parseInt(plus[1]));
            }
            
            sb.append("\n");
        }

        System.out.print(sb);
    }
}