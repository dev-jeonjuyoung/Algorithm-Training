import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        Tomato[][] box = new Tomato[Y][X];

        Queue<Tomato> queue = new LinkedList<>();

        for (int y = 0; y < Y; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < X; x++) {
                String state = st.nextToken();
                if (state.equals("1")) {
                    box[y][x] = new Tomato(y, x,  true);
                    queue.add(box[y][x]);
                }
                else if (state.equals("0"))
                    box[y][x] = new Tomato(y, x, false);
            }
        }

        final int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int day = 0;
        while (!queue.isEmpty()) {
            Queue<Tomato> newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Tomato now = queue.poll();

                for (int[] nd : dr) {
                    int ny = now.y + nd[0];
                    int nx = now.x + nd[1];

                    if (ny < 0 || Y <= ny || nx < 0 || X <= nx)
                        continue;
                    if (box[ny][nx] == null)
                        continue;
                    if (box[ny][nx].state)
                        continue;

                    box[ny][nx].state = true;
                    newQueue.add(box[ny][nx]);
                }
            }
            day++;
            queue = newQueue;
        }

        for (Tomato[] tomatoes : box) {
            for (Tomato tomato : tomatoes) {
                if (tomato == null)
                    continue;
                if (tomato.state)
                    continue;
                System.out.println(-1);
                return;
            }
        }

        System.out.println(day-1);
    }

    private static class Tomato {
        int y;
        int x;
        boolean state;

        public Tomato(int y, int x, boolean state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }

        public Tomato(boolean state) {
            this.state = state;
        }
    }
}