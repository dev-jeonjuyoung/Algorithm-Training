import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String label = "WelcomeToSMUPC";
        int N = Integer.parseInt(br.readLine())-1;

        int index = N%label.length();
        System.out.println(label.charAt(index));
    }
}