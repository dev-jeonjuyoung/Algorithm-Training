import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append(name).append("??!");
        System.out.print(sb);
    }
}