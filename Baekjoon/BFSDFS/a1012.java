import java.io.*;
import java.util.*;

public class a1012 {

    private final static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(BR.readLine());
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < tc; i++) {
            sj.add(Integer.toString(calculateMinWorms()));
        }
        System.out.println(sj);
    }

    private static int calculateMinWorms() throws IOException {
        boolean[][] field = initField();
        return minWorms(field);
    }

    private static boolean[][] initField() throws IOException {
        String[] widthHeightCount = BR.readLine().split(" ");
        boolean[][] field = new boolean[Integer.parseInt(widthHeightCount[1])][Integer.parseInt(widthHeightCount[0])];
        int count = Integer.parseInt(widthHeightCount[2]);
        for (int i = 0; i < count; i++) {
            String[] xy = BR.readLine().split(" ");
            field[Integer.parseInt(xy[1])][Integer.parseInt(xy[0])] = true;
        }
        return field;
    }
    
    private static int minWorms(boolean[][] field) {
        int x = field[0].length;
        int y = field.length;
        boolean[][] visit = new boolean[y][x];
        int worms = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (field[i][j] == true && !visit[i][j]) {
                    bfs(field, visit, i, j);
                    worms++;
                }
            }
        }
        return worms;
    }

    private static void bfs(boolean[][] field, boolean[][] visit, int i, int j) {
        int width = field[0].length;
        int height = field.length;
        int[][] nearBy = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int y = i;
        int x = j;
        for (int k = 0; k < 4; k++) {
            y = i + nearBy[k][0];
            x = j + nearBy[k][1];
            if (y >= 0 && y < height && x >=0 && x < width && field[y][x] && !visit[y][x]) {
                visit[y][x] = true;
                bfs(field, visit, y, x);
            }
        }
    }
}