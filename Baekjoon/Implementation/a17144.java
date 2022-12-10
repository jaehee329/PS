import java.io.*;
import java.util.*;

public class a17144 {
    private static final int[] XMOVE = new int[]{0, 0, -1, 1};
    private static final int[] YMOVE = new int[]{-1, 1, 0, 0};
    private static int cleanerUpper;
    private static int cleanerLower;
    private static int R, C, T;
    public static void main(String[] args) throws IOException {
        int[][] map = getMap();
        for (int i = 0; i < T; i++) {
            int[][] diffuseMap = diffuse(map);
            int[][] cleanMap = clean(diffuseMap);
            map = cleanMap;
        }
        printSum(map);
    }
    private static int[][] getMap() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] map = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                int t = Integer.parseInt(st.nextToken());
                map[i][j] = t;
                if (t == -1) {
                    if (cleanerLower == 0) {
                        cleanerLower = i;
                    } else {
                        cleanerUpper = i;
                    }
                }
            }
        }
        return map;
    }

    private static int[][] diffuse(int[][] map) {
        int[][] diffuseMap = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                int source = map[i][j];
                if (source < 5) {
                    diffuseMap[i][j] += source;
                    continue;
                }
                List<Integer[]> diffusable = getDiffusable(i, j);
                int size = diffusable.size();
                diffuseMap[i][j] += source - (source / 5) * size;
                for (Integer[] coord : diffusable) {
                    diffuseMap[coord[0]][coord[1]] += source / 5;
                }
            }
        }
        return diffuseMap;
    }

    private static List<Integer[]> getDiffusable(int row, int col) {
        List<Integer[]> diffusable = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int c = col + XMOVE[i];
            int r = row + YMOVE[i];
            if (diffusable(r, c)) {
                diffusable.add(new Integer[]{r, c});
            }
        }
        return diffusable; 
    }

    private static boolean diffusable(int row, int col) {
        if (row < 1 || row > R || col < 1 || col > C) {
            return false;
        }
        if (col == 1 && (row == cleanerLower || row == cleanerUpper)) {
            return false;
        }
        return true;
    }
    
    private static int[][] clean(int[][] map) {
        int[][] rotated = rotate(map);
        rotated[cleanerUpper][1] = -1;
        rotated[cleanerLower][1] = -1;
        rotated[cleanerUpper][2] = 0;
        rotated[cleanerLower][2] = 0;
        return rotated;
    }

    private static int[][] rotate(int[][] map) {
        int[][] rotateMap = new int[R+1][C+1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (j == 1) {
                    if (i <= cleanerLower && i > 1) {
                        rotateMap[i][j] = map[i-1][j];
                        continue;
                    }
                    if (i >= cleanerLower && i < R) {
                        rotateMap[i][j] = map[i+1][j];
                        continue;
                    }
                }
                if (i == cleanerLower || i == cleanerUpper) {
                    rotateMap[i][j] = map[i][j-1];
                    continue;
                }
                if (j == C) {
                    if (i <= cleanerLower) {
                        rotateMap[i][j] = map[i+1][j];
                        continue;
                    }
                    if (i >= cleanerUpper) {
                        rotateMap[i][j] = map[i-1][j];
                        continue;
                    }
                }
                if (i == 1 || i == R) {
                    rotateMap[i][j] = map[i][j+1];
                    continue;
                }
                rotateMap[i][j] = map[i][j];
            }
        }
        return rotateMap;
    }


    private static void printSum(int[][] map) {
        int sum = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum+2);
    }
}
