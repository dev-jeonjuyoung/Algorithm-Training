import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Reservation> reservationList = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            reservationList.add(new Reservation(start, end));
        }
        Collections.sort(reservationList);

        int cnt = 0;
        int prevEndTime = 0;

        for (Reservation reservation : reservationList) {
            if (prevEndTime <= reservation.start) {
                prevEndTime = reservation.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static class Reservation implements Comparable<Reservation>{
        int start;
        int end;

        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Reservation o) {
            if (this.end != o.end)
                return Integer.compare(this.end, o.end);
            return Integer.compare(this.start, o.start);
        }
    }
}