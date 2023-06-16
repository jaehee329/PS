import java.io.*;
import java.util.*;

public class a2146 {
    
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static boolean[][] map;
    private static boolean[][] visit;
    private static int minLength = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] && !visit[i][j]) {
                    findMinLength(i, j);
                }
            }
        }
        System.out.println(minLength);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(BR.readLine());
        map = new boolean[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = BR.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j].equals("1");
            }
        }
    }

    private static void findMinLength(int startY, int startX) {
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, -1, 1};

        Queue<int[]> island = new LinkedList<>();
        Queue<int[]> border = new LinkedList<>();
        island.add(new int[]{startY, startX});
        visit[startY][startX] = true;

        int[][] distances = new int[N][N];

        findInitialBorder(island, border, distances);
        findNearestIslandDistance(border, distances);
    }

    private static void findInitialBorder(Queue<int[]> island, Queue<int[]> border, int[][] distances) {
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, -1, 1};

        while (!island.isEmpty()) {
            int[] curYX = island.poll();
            for (int i = 0; i < 4; i++) {
                int tarY = curYX[0] + y[i];
                int tarX = curYX[1] + x[i];

                if (tarY >= 0 && tarY < N && tarX >= 0 && tarX < N) {
                    if (map[tarY][tarX] && !visit[tarY][tarX]) {
                        visit[tarY][tarX] = true;
                        island.add(new int[]{tarY, tarX});
                    }
                    if (!map[tarY][tarX]) {
                        distances[tarY][tarX] = 0;
                        border.add(new int[]{tarY, tarX});
                    }
                }
            }
        }
    }

    private static void findNearestIslandDistance(Queue<int[]> border, int[][] distances) {
        int[] y = {1, -1, 0, 0};
        int[] x = {0, 0, -1, 1};

        int bridgeLength = 0;
        while (bridgeLength < minLength) {
            bridgeLength++;
            Queue<int[]> nextBorder = new LinkedList<>();
            while (!border.isEmpty()) {
                int[] curYX = border.poll();
                for (int i = 0; i < 4; i++) {
                    int tarY = curYX[0] + y[i];
                    int tarX = curYX[1] + x[i];

                    if (tarY >= 0 && tarY < N && tarX >= 0 && tarX < N) {
                        if (!visit[tarY][tarX]) {
                            if (map[tarY][tarX]) {
                                minLength = bridgeLength;
                                return;
                            }
                            if (distances[tarY][tarX] < bridgeLength) {
                                distances[tarY][tarX] = bridgeLength;
                                nextBorder.add(new int[]{tarY, tarX});
                            }
                        }
                    }
                }
            }
            border = nextBorder;
        }
    }
}
