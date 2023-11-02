import java.io.*;
import java.util.*;

public class a1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }
        
        boolean[][] visit = new boolean[height][width];
        int maxSize = 0;
        int parts = 0;
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();
        int[] nearY = {-1, 1, 0, 0};
        int[] nearX = {0, 0, -1, 1};
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!visit[i][j] && map[i][j]) {
                    parts++;
                    int currentSize = 1;
                    visit[i][j] = true;
                    stack.addLast(new Integer[]{i, j});
                    while (!stack.isEmpty()) {
                        Integer[] current = stack.pollLast();
                        int fromY = current[0];
                        int fromX = current[1];
                        for (int k = 0; k < 4; k++) {
                            int toY = fromY + nearY[k];
                            int toX = fromX + nearX[k];
                            if (toY >= 0 && toY < height && toX >=0 && toX < width) {
                                if (!visit[toY][toX] && map[toY][toX]) {
                                    currentSize++;
                                    visit[toY][toX] = true;
                                    stack.addLast(new Integer[]{toY, toX});
                                }
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, currentSize);
                }
            }
        }
        System.out.println(parts);
        System.out.println(maxSize);
    }
}
