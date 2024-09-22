import java.io.*;
import java.util.*;

public class a4179 {
    private static final int[] YMOVES = {1, -1, 0, 0};
    private static final int[] XMOVES = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] map = new char[height][width];
        boolean[][] jihoonVisit = new boolean[height][width];
        boolean[][] fireVisit = new boolean[height][width];

        Queue<int[]> jihoonQueue = new LinkedList<>();
        Queue<int[]> fireQueue = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                if (c == 'J') {
                    jihoonVisit[i][j] = true;
                    jihoonQueue.add(new int[]{i, j});
                } else if (c == 'F') {
                    fireVisit[i][j] = true;
                    fireQueue.add(new int[]{i, j});
                }
                map[i][j] = c;
            }
        }

        int minute = 0;
        while (!jihoonQueue.isEmpty()) {
            minute++;
            Queue<int[]> nextJihoonQueue = new LinkedList<>();
            Queue<int[]> nextFireQueue = new LinkedList<>();
            while (!fireQueue.isEmpty()) {
                int[] firePos = fireQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nextFireY = firePos[0] + YMOVES[i];
                    int nextFireX = firePos[1] + XMOVES[i];
                    if (nextFireY >= 0 && nextFireY < height && nextFireX >= 0 && nextFireX < width) {
                        if (!fireVisit[nextFireY][nextFireX] && map[nextFireY][nextFireX] != '#') {
                            map[nextFireY][nextFireX] = 'F';
                            nextFireQueue.add(new int[]{nextFireY, nextFireX});
                            fireVisit[nextFireY][nextFireX] = true;
                        }
                    }
                }
            }
            
            while (!jihoonQueue.isEmpty()) {
                int[] jihoonPos = jihoonQueue.poll();
                if (jihoonPos[0] == 0 || jihoonPos[0] == height - 1 || jihoonPos[1] == 0 || jihoonPos[1] == width - 1) {
                    System.out.println(minute);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int nextJihoonY = jihoonPos[0] + YMOVES[i];
                    int nextJihoonX = jihoonPos[1] + XMOVES[i];
                    if (nextJihoonY >= 0 && nextJihoonY < height && nextJihoonX >= 0 && nextJihoonY < width) {
                        if (!jihoonVisit[nextJihoonY][nextJihoonX] && map[nextJihoonY][nextJihoonX] == '.') {
                            nextJihoonQueue.add(new int[]{nextJihoonY, nextJihoonX});
                            jihoonVisit[nextJihoonY][nextJihoonX] = true;
                        }
                    }
                }
            }
            fireQueue = nextFireQueue;
            jihoonQueue = nextJihoonQueue;
        }
        System.out.println("IMPOSSIBLE");
    }
}
