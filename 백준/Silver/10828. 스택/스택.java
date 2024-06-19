import java.io.*;
import java.util.*;

public class Main {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while (0 < N--) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static void push(int num) {
        stack.push(num);
    }

    private static int pop() {
        return stack.empty() ? -1 : stack.pop();
    }

    private static int size() {
        return stack.size();
    }

    private static int empty() {
        return stack.empty() ? 1 : 0;
    }

    private static int top() {
        return stack.empty() ? -1 : stack.peek();
    }
}