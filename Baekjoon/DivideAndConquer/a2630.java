import java.io.*;
import java.util.*;

public class a2630 {
    private static int white = 0;
    private static int blue = 0;
    private static int N;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculateColors(0, N, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void calculateColors(int startY, int endY, int startX, int endX) {
        boolean isSame = true;
        int first = map[startY][startX];
        for (int i = startY; i < endY && isSame; i++) {
            for (int j = startX; j < endX; j++) {
                if (map[i][j] != first) {
                    isSame = false;
                    break;
                }
            }
        }
        if (!isSame) {
            int half = (endY - startY) / 2;
            calculateColors(startY, startY + half, startX, startX + half);
            calculateColors(startY, startY + half, startX + half, endX);
            calculateColors(startY + half, endY, startX, startX + half);
            calculateColors(startY + half, endY, startX + half, endX);
            return;
        }
        if (first == 1) {
            blue++;
        } else {
            white++;
        }
    }
}
