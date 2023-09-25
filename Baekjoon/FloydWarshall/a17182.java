import java.io.*;
import java.util.*;

public class a17182 {

    private static int n;
    private static int origin;
    private static int[][] map;
    private static int minCost = Integer.MAX_VALUE;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        origin = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        
        visit = new boolean[n];
        visit[origin] = true;
        dfs(origin, 0, 0);

        System.out.println(minCost);
    }

    private static void dfs(int from, int depth, int cost) {
        if (cost > minCost) {
            return;
        } else if (depth == n - 1) {
            minCost = Math.min(minCost, cost);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i, depth + 1, cost + map[from][i]);
                visit[i] = false;
            }
        }
    }
}
