import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class a2583 {

    private static PriorityQueue<Integer> SIZES = new PriorityQueue<>();
    private static int HEIGHT = 0;
    private static int WIDTH = 0;

    public static void main(String[] args) throws IOException {
        boolean[][] square = init();
        findUnfilled(square);
        System.out.println(SIZES.size());
        StringJoiner sj = new StringJoiner(" ");
        
        while (!SIZES.isEmpty()) {
            sj.add(Integer.toString(SIZES.poll()));
        }
        System.out.println(sj.toString());
    }

    private static boolean[][] init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] widthHeightCount = br.readLine().split(" ");
        HEIGHT = Integer.parseInt(widthHeightCount[0]);
        WIDTH = Integer.parseInt(widthHeightCount[1]);
        int count = Integer.parseInt(widthHeightCount[2]);

        boolean[][] square = new boolean[HEIGHT][WIDTH];

        for (int i = 0; i < count; i++) {
            String[] bottomLeftAndTopRight = br.readLine().split(" ");
            fill(square, bottomLeftAndTopRight);
        }
        return square;
    }

    private static void fill(boolean[][] square, String[] bottomLeftAndTopRight) {
        int x1 = Integer.parseInt(bottomLeftAndTopRight[0]);
        int y1 = Integer.parseInt(bottomLeftAndTopRight[1]);
        int x2 = Integer.parseInt(bottomLeftAndTopRight[2]) - 1;
        int y2 = Integer.parseInt(bottomLeftAndTopRight[3]) - 1;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                square[i][j] = true;
            }
        }
    }

    private static void findUnfilled(boolean[][] square) {
        WIDTH = square[0].length;
        HEIGHT = square.length;
        boolean[][] visit = new boolean[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (!square[i][j] && !visit[i][j]) {
                    dfs(square, visit, i, j);
                }
            }
        }
    }

    private static void dfs(boolean[][] square, boolean[][] visit, int i, int j) {
        visit[i][j] = true;
        int[] nearY = {1, -1, 0, 0};
        int[] nearX = {0, 0, -1, 1};
        ArrayDeque<Integer[]> stack = new ArrayDeque<>();
        stack.offerLast(new Integer[]{i, j});
        int size = 1;

        while (!stack.isEmpty()) {
            Integer[] origin = stack.pollLast();
            int originY = origin[0];
            int originX = origin[1];
            for (int k = 0; k < 4; k++) {
                int y = originY + nearY[k];
                int x = originX + nearX[k];

                if (y >= 0 && y < HEIGHT && x >= 0 && x < WIDTH && !square[y][x] && !visit[y][x]) {
                    size++;
                    visit[y][x] = true;
                    stack.offerLast(new Integer[]{y, x});
                }
            }
        }
        SIZES.offer(size);
    }
}
