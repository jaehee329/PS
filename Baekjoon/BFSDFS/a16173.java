package Baekjoon.BFSDFS;

import java.io.*;
import java.util.*;

public class a16173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] currentYX = queue.poll();
            int y = currentYX[0];
            int x = currentYX[1];

            int mobility = board[y][x];
            if (mobility == -1) {
                System.out.println("HaruHaru");
                return;
            }

            int[] rightYX = new int[]{0, mobility};
            int[] downYX = new int[]{mobility, 0};
            addToQueueIfMovable(N, currentYX, rightYX, queue, visit);
            addToQueueIfMovable(N, currentYX, downYX, queue, visit);
        }
        System.out.println("Hing");
    }

    private static void addToQueueIfMovable(int N, int[] currentYX, int[] movingYX, Queue<int[]> queue, boolean[][] visit) {
        int targetY = currentYX[0] + movingYX[0];
        int targetX = currentYX[1] + movingYX[1];
        if (targetY >= 0 && targetY < N && targetX >= 0 && targetX < N && !visit[targetY][targetX]) {
            visit[targetY][targetX] = true;
            queue.add(new int[]{targetY, targetX});
        }
    }
}
