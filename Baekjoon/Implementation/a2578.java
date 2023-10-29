import java.io.*;
import java.util.*;

public class a2578 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numberByPos = new int[25];
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken()) - 1;
                numberByPos[number] = 5 * i + j;
            }
        }

        int[] orders = new int[25];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int order = Integer.parseInt(st.nextToken()) - 1;
                orders[5 * i + j] = order;
            }
        }

        boolean[][] visit = new boolean[5][5];
        for (int i = 0; i < 11; i++) {
            int number = numberByPos[orders[i]];
            visit[number / 5][number % 5] = true;
        }

        for (int i = 11; i < 25; i++) {
            int number = numberByPos[orders[i]];
            visit[number / 5][number % 5] = true;
            if (checkThreeBingo(visit)) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    private static boolean checkThreeBingo(boolean[][] visit) {
        int bingo = 0;
        // horizontal
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visit[i][j]) {
                    break;
                }
                if (j == 4) {
                    bingo++;
                    if (bingo == 3) {
                        return true;
                    }
                }
            }
        }
        // vertical
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visit[j][i]) {
                    break;
                }
                if (j == 4) {
                    bingo++;
                    if (bingo == 3) {
                        return true;
                    }
                }
            }
        }
        // diagonal
        for (int i = 0; i < 5; i++) {
            if (!visit[i][i]) {
                break;
            }
            if (i == 4) {
                bingo++;
                if (bingo == 3) {
                    return true;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!visit[i][4 - i]) {
                break;
            }
            if (i == 4) {
                bingo++;
                if (bingo == 3) {
                    return true;
                }
            }
        }
        return false;
    }
}
