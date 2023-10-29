import java.io.*;
import java.util.*;

public class a16955 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[10][10];
        boolean[][] visit = new boolean[10][10];
        List<Integer[]> candidate = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'X') {
                    candidate.add(new Integer[]{i, j});
                    visit[i][j] = true;
                } else if (c == 'O') {
                    visit[i][j] = true;
                }
            }
        }

        for (Integer[] source : candidate) {
            if (isBingoNear(source, map, visit)) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    private static boolean isBingoNear(Integer[] source, char[][] map, boolean[][] visit) {
        int[] relY = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] relX = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < 8; i++) {
            int fromY = source[0];
            int fromX = source[1];
            int toY = fromY + relY[i];
            int toX = fromX + relX[i];
            if (toY >= 0 && toY < 10 && toX >= 0 && toX < 10 && !visit[toY][toX]) {
                int cnt = 2;
                int[] dir = new int[]{relY[i], relX[i]};
                int[] oppoDir = new int[]{-1 * relY[i], -1 * relX[i]};
                int[] from = new int[]{toY, toX};

                while (true) {
                    int[] next = move(from, dir);
                    if (isValid(next) && map[next[0]][next[1]] == 'X') {
                        cnt++;
                    } else {
                        break;
                    }
                    from = next;
                }
                from = new int[]{fromY, fromX};
                while (true) {
                    int[] next = move(from, oppoDir);
                    if (isValid(next) && map[next[0]][next[1]] == 'X') {
                        cnt++;
                    } else {
                        break;
                    }
                    from = next;
                }

                if (cnt >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] move(int[] from, int[] dir) {
        return new int[]{from[0] + dir[0], from[1] + dir[1]};
    }

    private static boolean isValid(int[] coord) {
        return coord[0] >= 0 && coord[0] < 10 && coord[1] >= 0 && coord[1] < 10;
    }
}
