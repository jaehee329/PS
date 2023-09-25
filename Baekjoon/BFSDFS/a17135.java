import java.io.*;
import java.util.*;

public class a17135 {

    private static final int[] yMoves = new int[]{0, -1, 0};
    private static final int[] xMoves = new int[]{-1, 0, 1};
    private static final Position NO_KILLED = new Position(-1 , -1);

    private static int n;
    private static int m;
    private static int d;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                for (int k = j + 1; k < m; k++) {
                    int tries = 17 * i + 13 * j + 7 * k;
                    int[] xArchers = new int[]{i, j, k};
                    int cnt = 0;
                    for (int turn = 0; turn < n; turn++) {
                        int yArcher = n - turn;
                        Set<Position> killed = new HashSet<>();
                        for (int xArcher : xArchers) {
                            Queue<Position> q = new LinkedList<>();
                            q.add(new Position(yArcher, xArcher));
                            Position enemy = bfs(q, yArcher, tries);
                            if (enemy != NO_KILLED) {
                                killed.add(enemy);
                            }
                        }
                        cnt += killed.size();
                        for (Position killedPos : killed) {
                            map[killedPos.y][killedPos.x] = tries;
                        }
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        System.out.println(max);
    }

    private static Position bfs(Queue<Position> q, int yArcher, int tries) {
        boolean[][] visit = new boolean[n][m];
        for (int i = 1; i <= d; i++) {
            Queue<Position> nextQ = new LinkedList<>();
            while (!q.isEmpty()) {
                Position position = q.poll();
                for (int j = 0; j < 3; j++) {
                    int y = yMoves[j] + position.y;
                    int x = xMoves[j] + position.x;
                    if (y < yArcher && y >= 0 && x < m && x >= 0 && !visit[y][x]) {
                        visit[y][x] = true;
                        if (map[y][x] == 0 || map[y][x] == tries) {
                            nextQ.add(new Position(y, x));
                        } else {
                            return new Position(y, x);
                        }
                    }
                }
            }
            q = nextQ;
        }
        return NO_KILLED;
    }

    private static class Position {
        public int y;
        public int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return y == position.y && x == position.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
