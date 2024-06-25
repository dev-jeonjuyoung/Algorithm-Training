import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    private static int N;
    private static boolean[][] map;
    private static int[][] dr = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];


        for (int y = 0; y < N; y++) {
            String row = br.readLine();
            for (int x = 0; x < N; x++) {
                map[y][x] = row.charAt(x) == '1';
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!map[y][x])
                    continue;
                int cnt = bfs(x, y);
                list.add(cnt);
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");

        for (Integer i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        int cnt = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[y][x] = false;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int[] nd : dr) {
                int ny = now.y + nd[0];
                int nx = now.x + nd[1];
                if (ny < 0 || N <= ny || nx < 0 || N <= nx)
                    continue;
                if (!map[ny][nx])
                    continue;
                queue.add(new Point(nx, ny));
                map[ny][nx] = false;
                cnt++;
            }
        }

        return cnt;
    }
}