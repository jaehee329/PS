import java.io.*;
import java.util.*;

public class a11404 {
    // INF를 간선 최대 * (정점 개수 - 1) + 1 로 잡는다. INT MAX로 하면 overflow
    private static final int INF = 100_000 * 99 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        int cnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from][to] = cost < graph[from][to] ? cost : graph[from][to];
        }
        


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] + graph[i][k] < graph[j][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(graph[i][j] + " ");    
                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
