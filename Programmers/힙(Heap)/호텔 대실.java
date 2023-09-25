import java.util.*;

class Solution {
    public static class Reservation {
        public int start;
        public int end;

        public Reservation(String start, String end) {
            this.start = toMin(start);
            this.end = toMin(end) + 10;
        }

        private int toMin(String time) {
            String[] hourAndMin = time.split(":");
            return Integer.parseInt(hourAndMin[0]) * 60 + Integer.parseInt(hourAndMin[1]);
        }
    }

    public int solution(String[][] book_time) {
        int count = book_time.length;
        List<Reservation> reservations= new ArrayList<>();
        for (int i = 0; i < count; i++) {
            reservations.add(new Reservation(book_time[i][0], book_time[i][1]));
        }
        reservations.sort((r1, r2) -> r1.start - r2.start);

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (Reservation reservation : reservations) {
            if (!rooms.isEmpty() && rooms.peek() <= reservation.start) {
                rooms.poll();
                rooms.add(reservation.end);
                continue;
            }
            rooms.add(reservation.end);
        }

        return rooms.size();
    }
}
