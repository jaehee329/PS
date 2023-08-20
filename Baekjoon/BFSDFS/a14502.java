import java.io.*;
import java.util.*;

public class a14502 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int total = height * width;

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int maxSecure = 0;
        for (int i = 0; i < total; i++) {
            int fHeight = i / width;
            int fWidth = i % width;
            if (map[fHeight][fWidth] == 0) {
                map[fHeight][fWidth] = 1;
                for (int j = i; j < total; j++) {
                    int sHeight = j / width;
                    int sWidth = j % width;
                    if (map[sHeight][sWidth] == 0) {
                        map[sHeight][sWidth] = 1;
                        for (int k = j; k < total; k++) {
                            int tHeight = k / width;
                            int tWidth = k % width;
                            if (map[tHeight][tWidth] == 0) {
                                map[tHeight][tWidth] = 1;
                                int secure = bfs(map);
                                if (secure > maxSecure) {
                                    maxSecure = secure;
                                }
                                map[tHeight][tWidth] = 0;
                            }
                        }
                        map[sHeight][sWidth] = 0;
                    }
                }
                map[fHeight][fWidth] = 0;
            }
        }
        System.out.println(maxSecure);
    }

    private static int bfs(int[][] map) {
        int[] yMoves = {-1, 1, 0, 0};
        int[] xMoves = {0, 0, -1, 1};
        int height = map.length;
        int width = map[0].length;

        int[][] polluted = new int[height][width];

        boolean[][] visit = new boolean[height][width];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == 1) {
                    polluted[i][j] = 1;
                } else if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    polluted[i][j] = 2;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pollution = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = pollution[0] + yMoves[i];
                int nextX = pollution[1] + xMoves[i];
                if (nextY >= 0 && nextY < height && nextX >= 0 && nextX < width && !visit[nextY][nextX] && polluted[nextY][nextX] == 0) {
                    visit[nextY][nextX] = true;
                    polluted[nextY][nextX] = 2;
                    q.add(new int[]{nextY, nextX});
                }
            }
        }

        int secure = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (polluted[i][j] == 0) {
                    secure++;
                }
            }
        }
        return secure;
    }
}
