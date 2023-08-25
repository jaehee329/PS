import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        char[][] map = new char[height][width];
        int[] start = new int[2];
        int[] exit = new int[2];
        int[] lever = new int[2];
        for (int i = 0; i < height; i++) {
            String line = maps[i];
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                if (c == 'S') {
                    start = new int[]{i, j};
                } else if (c == 'E') {
                    exit = new int[]{i, j};
                } else if (c == 'L') {
                    lever = new int[]{i, j};
                }
                if (c == 'X') {
                    map[i][j] = 'X';
                } else {
                    map[i][j] = 'O';
                }
            }
        }

        int startToLever = bfs(map, start, lever);
        if (startToLever == -1) {
            return -1;
        }
        int leverToExit = bfs(map, lever, exit);
        if (leverToExit == -1) {
            return -1;
        }
        return startToLever + leverToExit;
    }

    private int bfs(char[][] map, int[] start, int[] dest) {
        int[] yMove = {-1, 1, 0, 0};
        int[] xMove = {0, 0, -1, 1};
        int height = map.length;
        int width = map[0].length;

        int[][] visit = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(visit[i], 10_000);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visit[start[0]][start[1]] = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cost = visit[cur[0]][cur[1]];
            for (int i = 0; i < 4; i++) {
                int yNext = cur[0] + yMove[i];
                int xNext = cur[1] + xMove[i];
                if (yNext >= 0 && yNext < height && xNext >= 0 && xNext < width) {
                    if (map[yNext][xNext] == 'O' && visit[yNext][xNext] > cost + 1) {
                        visit[yNext][xNext] = cost + 1;
                        q.add(new int[]{yNext, xNext});
                    }
                }
            }
        }
        return visit[dest[0]][dest[1]] != 10_000 ? visit[dest[0]][dest[1]] : -1;
    }
}
