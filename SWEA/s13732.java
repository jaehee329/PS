/*
 * 1. BFS로 근처 격자를 모두 탐색하는 경우가 하나인지 확인
 * 2. 정사각형 판별: 탐색 도중 처음 격자부터 격자인 X혹은 Y의 최대거리를 저장한 뒤 해당 범위가 모두 격자만 존재하는지 확인
 * 리팩토링까지 하진 않아 정사각형 판별이 한 메서드로 지저분함. 한다면 정사각형 판별 부분, q를 사용한 bfs부분은 따로 분리가 쉬움.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class s13732 {
    private static StringBuilder sb = new StringBuilder();
    private static final int MOVES = 2;
    private static final int[] YMOVE = {1, 0};
    private static final int[] XMOVE = {0, 1};

    private static class gridN {
        boolean[][] grid;
        int N;
        public gridN(boolean[][] grid, int N) {
            this.grid = grid;
            this.N = N;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i=1; i<=T; i++) {
            gridN gridn = getGrid(br);
            boolean answer = isSqaure(gridn);
            appendSb(i, answer);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static gridN getGrid(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        boolean[][] grid = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                if (line.charAt(j)=='#') {
                    grid[i][j] = true;
                }
            }
        }
        gridN gridn = new gridN(grid, N);
        return gridn;
    }

    private static boolean isSqaure(gridN gridn) {
        boolean foundFirst = false;
        int N = gridn.N;
        boolean[][] grid = gridn.grid;

        boolean[][] visit = new boolean[N][N];

        int firstY = 0;
        int firstX = 0;
        int yDiffMax = 0;
        int xDiffMax = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    if (grid[i][j]) {
                        if (!foundFirst) {
                            foundFirst = true;
                            firstY = i;
                            firstX = j;
                            Integer[] coord = {i, j};
                            Queue<Integer[]> q = new LinkedList<>();
                            q.add(coord);
                            // bfs
                            while(!q.isEmpty()) {
                                // System.out.println("qsize = " + q.size());
                                Integer[] c = q.poll();
                                int originY = c[0];
                                int originX = c[1];
                                for (int k=0; k<MOVES; k++) {
                                    int Y = originY + YMOVE[k];
                                    int X = originX + XMOVE[k];
                                    if(Y>=0 && Y<N && X>=0 && X<N) {
                                        // System.out.println("origin Y = "+ originY + " X = " + originX +" checking Y = "+ Y + " X = " + X + " visit[Y][X] = " + visit[Y][X]);
                                        if(!visit[Y][X]) {
                                            visit[Y][X] = true;
                                            if(grid[Y][X]) {
                                                yDiffMax = (yDiffMax<(Y-firstY)) ? Y-firstY : yDiffMax;
                                                xDiffMax = (xDiffMax<(X-firstX)) ? X-firstX : xDiffMax;
                                                Integer[] near = {Y, X};
                                                q.add(near);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        int maxDiff = (yDiffMax>=xDiffMax) ? yDiffMax : xDiffMax;
        for (int i=firstY; i<=firstY+maxDiff; i++) {
            for (int j=firstX; j<=firstX+maxDiff; j++) {
                if(!grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void appendSb(int idx, boolean answer) {
        String s = "";
        if(answer) {
            s = "yes";
        } else {
            s = "no";
        }
        sb.append("#" + idx + " " + s + "\n");
    }
}
