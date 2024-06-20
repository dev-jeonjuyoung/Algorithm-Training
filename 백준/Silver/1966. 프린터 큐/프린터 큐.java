import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (0 < tc--) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Paper> queue = new ArrayDeque<>();
            List<Integer> arr = new ArrayList<>();
            Paper target = null;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                arr.add(priority);
                Paper paper = new Paper(priority);
                queue.add(paper);
                if (i == M)
                    target = paper;
            }

            arr.sort(Collections.reverseOrder());
            int cnt = 1;
            for (int priority : arr) {
                while (queue.peek().priority != priority)
                    queue.add(queue.poll());
                if (priority != target.priority) {
                    queue.poll();
                    cnt++;
                } else {
                    if (target == queue.peek())
                        break;
                    else {
                        queue.poll();
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    private static class Paper {
        int priority;

        public Paper(int priority) {
            this.priority = priority;
        }
    }
}