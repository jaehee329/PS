// BFS
import java.io.*;
import java.util.*;

public class a10026 {
    private static int MOVES = 4;
    private static int[] YMOVES = {1, -1, 0, 0};
    private static int[] XMOVES = {0, 0, -1, 1};
    private static int N;
    private static char[][] grid;

    public static void main(String[] args) throws IOException {
        setNAndGrid();

        boolean isColorBlind = false;
        int regionsNotBlind = getNumOfRegionsFromGrid(isColorBlind);
        isColorBlind = true;
        int regionsBlind = getNumOfRegionsFromGrid(isColorBlind);

        System.out.println(regionsNotBlind + " " + regionsBlind);
    }

    private static void setNAndGrid() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        grid = new char[N][N];
        for (int i=0; i<N; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
    }

    private static int getNumOfRegionsFromGrid(boolean isColorBlind) {
        boolean[][] visit = new boolean[N][N];
        int regions = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(!visit[i][j]) {
                    visit[i][j] = true;
                    regions++;
                    bfs(new int[]{i, j}, visit, isColorBlind);
                }
            }
        }
        return regions;
    }

    private static void bfs(int[] pos, boolean[][] visit, boolean isColorBlind) {
        Queue<int[]> q = new LinkedList<>();
        q.add(pos);
        int origin = getRegionalIdxOfPos(pos, isColorBlind);
        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int srcY = curPos[0];
            int srcX = curPos[1];
            for (int i=0; i<MOVES; i++) {
                int dstY = srcY + YMOVES[i];
                int dstX = srcX + XMOVES[i];
                int[] dst = new int[]{dstY, dstX};
                // TODO: can encapsulate the statements
                if (dstY>=0 && dstY<N && dstX>=0 && dstX<N) {
                    if (!visit[dstY][dstX] && origin == getRegionalIdxOfPos(dst, isColorBlind)) {
                        visit[dstY][dstX] = true;
                        q.add(dst);
                    }
                }
            }
        }
    }

    private static int getRegionalIdxOfPos(int[] pos, boolean isColorBlind) {
        int y = pos[0];
        int x = pos[1];
        if(grid[y][x] == 'B') {
            return 1;
        } else if(grid[y][x] == 'R') {
            return 2;
        } else if(grid[y][x] == 'G' && isColorBlind) {
            return 2;
        } else {
            return 3;
        }
    }
}
