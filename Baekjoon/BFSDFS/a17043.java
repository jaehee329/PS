import java.io.*;
import java.util.*;

public class a17043 {

    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean isCycle = false;
    static boolean notMoved = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int wizardCount = Integer.parseInt(st.nextToken());
        int duelCount = Integer.parseInt(st.nextToken());

        graph = new ArrayList[wizardCount + 1];
        visited = new boolean[wizardCount + 1];

        for (int i = 1; i <= wizardCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < duelCount; i++) {
            st = new StringTokenizer(br.readLine());
            int winner = Integer.parseInt(st.nextToken());
            int loser = Integer.parseInt(st.nextToken());
            graph[loser].add(winner);
        }

        dfs(1);

        StringBuilder result = new StringBuilder();
        result.append(isCycle || notMoved ? '1' : '0');

        for (int i = 2; i <= wizardCount; i++) {
            result.append(visited[i] ? '1' : '0');
        }

        System.out.println(result.toString());
    }

    static void dfs(int current) {
        if (current == 1 && visited[1]) {
            isCycle = true;
        }

        if (visited[current]) {
            return;
        }

        visited[current] = true;

        for (int nextWizard : graph[current]) {
            notMoved = false;
            dfs(nextWizard);
        }
    }
}
