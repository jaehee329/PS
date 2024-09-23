import java.io.*;
import java.util.*;

public class a7562 {

    private static final int[] YMOVES = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] XMOVES = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCount = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < testCaseCount; i++) {
            int length = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            boolean[][] visit = new boolean[length][length];
            visit[startY][startX] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startY, startX});

            int round = -1;
            boolean doesReachedEnd = false;
            while (!doesReachedEnd) {
                round++;
                Queue<int[]> nextQueue = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int[] currentPosition = queue.poll();
                    int currentY = currentPosition[0];
                    int currentX = currentPosition[1];
                    if (currentY == endY && currentX == endX) {
                        doesReachedEnd = true;
                        break;
                    }

                    for (int j = 0; j < 8; j++) {
                        int nextY = currentY + YMOVES[j];
                        int nextX = currentX + XMOVES[j];
                        if (nextY >= 0 && nextY < length && nextX >= 0 && nextX < length) {
                            if (!visit[nextY][nextX]) {
                                visit[nextY][nextX] = true;
                                nextQueue.add(new int[]{nextY, nextX});
                            }
                        }
                    }
                }
                queue = nextQueue;
            }
            bw.write(Integer.toString(round) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
