import java.io.*;
import java.util.*;

public class a7569 {
    public static void main(String[] args) throws IOException {
        int[] zMoves = {1, -1, 0, 0, 0, 0};
        int[] yMoves = {0, 0, 1, -1, 0, 0};
        int[] xMoves = {0, 0, 0, 0, 1, -1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int depth = Integer.parseInt(st.nextToken());

        int[][][] box = new int[depth][height][width];
        boolean[][][] visit = new boolean[depth][height][width];
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> nextQ = new LinkedList<>();
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < width; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    if (status == 1) {
                        visit[i][j][k] = true;
                        nextQ.add(new int[]{i, j, k});
                    }
                    box[i][j][k] = status;
                }
            }
        }

        int day = 0;
        while (!nextQ.isEmpty()) {
            boolean job = false;
            q = nextQ;
            nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                int[] position = q.poll();
                for (int i = 0; i < 6; i++) {
                    int zNext = position[0] + zMoves[i];
                    int yNext = position[1] + yMoves[i];
                    int xNext = position[2] + xMoves[i];
                    if (zNext >= 0 && zNext < depth && yNext >= 0 && yNext < height && xNext >= 0 && xNext < width) {
                        if (!visit[zNext][yNext][xNext] && box[zNext][yNext][xNext] == 0) {
                            job = true;
                            visit[zNext][yNext][xNext] = true;
                            box[zNext][yNext][xNext] = 1;
                            nextQ.add(new int[]{zNext, yNext, xNext});
                        }
                    }
                }
            }
            if (job) {
                day++;
            }
        }

        boolean isDone = true;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    isDone = box[i][j][k] == 0 ? false : isDone;
                }
            }
        }
        System.out.println(isDone ? day : -1);
    }
}
