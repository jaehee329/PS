import java.util.*;

public class Solution {

    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int height;
    private static int width;
    private static char[][] map;

    public int solution(String[] board) {
        height = board.length;
        width = board[0].length();
        map = new char[height][width];
        int[] robot = new int[2];
        int[] goal = new int[2];
        for (int i = 0; i < height; i++) {
            String line = board[i];
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'R') {
                    robot = new int[]{i, j};
                    map[i][j] = '.';
                } else if (c == 'G') {
                    goal = new int[]{i, j};
                    map[i][j] = '.';
                }
            }
        }

        int[][] costs = new int[height][width];
        for (int i = 0; i < height; i++) {
            int[] line = costs[i];
            Arrays.fill(line, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(robot);
        costs[robot[0]][robot[1]] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCost = costs[current[0]][current[1]];
            for (int[] direction : DIRECTIONS) {
                int[] destination = reaches(current, direction);
                int destinationCost = costs[destination[0]][destination[1]];
                if (destinationCost > currentCost + 1) {
                    queue.add(destination);
                    costs[destination[0]][destination[1]] = currentCost + 1;
                }
            }
        }

        if (costs[goal[0]][goal[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return costs[goal[0]][goal[1]];
    }

    private int[] reaches(int[] origin, int[] direction) {
        int y = origin[0];
        int x = origin[1];
        while (true) {
            int nextY = y + direction[0];
            int nextX = x + direction[1];
            if (nextY >= 0 && nextY < height && nextX >= 0 && nextX < width
                    && map[nextY][nextX] == '.') {
                y += direction[0];
                x += direction[1];
            } else {
                return new int[]{y, x};
            }
        }
    }
}
