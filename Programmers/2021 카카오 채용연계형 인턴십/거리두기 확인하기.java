import java.util.*;

public class Solution {

    public static void main(String[] args) {
    }

    public int[] solution(String[][] places) {
        int count = places.length;
        int[] answer = new int[count];
        for (int i = 0; i < count; i++) {
            String[] place = places[i];
            char[][] map = new char[5][5];
            List<Integer[]> locations = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String row = place[j];
                for (int k = 0; k < 5; k++) {
                    char c = row.charAt(k);
                    map[j][k] = c;
                    if (c == 'P') {
                        locations.add(new Integer[]{j, k});
                    }
                }
            }

            boolean valid = checkValidity(map, locations);
            if (valid) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    private boolean checkValidity(char[][] map, List<Integer[]> locations) {
        int[] yMoves = {1, -1 , 0, 0};
        int[] xMoves = {0, 0, -1, 1};
        for (Integer[] location : locations) {
            int y = location[0];
            int x = location[1];
            boolean[][] visit = new boolean[5][5];
            visit[y][x] = true;

            Queue<Integer[]> q = new LinkedList<>();
            // dist 1
            for (int i = 0; i < 4; i++) {
                int toY = y + yMoves[i];
                int toX = x + xMoves[i];
                if (toY >= 0 && toY < 5 && toX >= 0 && toX < 5) {
                    if (!visit[toY][toX]) {
                        visit[toY][toX] = true;
                        if (map[toY][toX] == 'P') {
                            return false;
                        }
                        if (map[toY][toX] == 'O') {
                            q.add(new Integer[]{toY, toX});
                        }
                    }
                }
            }

            // dist 2
            while (!q.isEmpty()) {
                Integer[] target = q.poll();
                int nextY = target[0];
                int nextX = target[1];
                for (int i = 0; i < 4; i++) {
                    int toY = nextY + yMoves[i];
                    int toX = nextX + xMoves[i];
                    if (toY >= 0 && toY < 5 && toX >= 0 && toX < 5) {
                        if (!visit[toY][toX]) {
                            visit[toY][toX] = true;
                            if (map[toY][toX] == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
