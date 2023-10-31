import java.io.*;
import java.util.*;

public class a17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] fromLeft = new int[n + 1][n + 1];
        int[][] fromDiagonal = new int[n + 1][n + 1];
        int[][] fromUp = new int[n + 1][n + 1];
        fromLeft[1][2] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                if (map[i][j] == 1) {
                    continue;
                }
                fromLeft[i][j] = fromLeft[i][j - 1] + fromDiagonal[i][j - 1];
                fromUp[i][j] = fromDiagonal[i - 1][j] + fromUp[i - 1][j];
                if (isDiagonalMovementUnsafe(i, j, map)) {
                    continue;
                }
                fromDiagonal[i][j] = fromDiagonal[i - 1][j - 1] + fromLeft[i - 1][j - 1] + fromUp[i - 1][j - 1];
            }
        }
        System.out.println(fromLeft[n][n] + fromDiagonal[n][n] + fromUp[n][n]);
    }
    private static boolean isDiagonalMovementUnsafe(int toY, int toX, int[][] map) {
        return map[toY - 1][toX] == 1 || map[toY][toX - 1] == 1;
    }
}