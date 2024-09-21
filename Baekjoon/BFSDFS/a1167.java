import java.io.*;
import java.util.*;

public class a1167 {

    private static List<Node>[] graph;
    private static int maxDistance;
    private static int maxDistanceSrc;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int verticeCount = Integer.parseInt(br.readLine());
        graph = new List[verticeCount + 1];
        for (int i = 0; i <= verticeCount; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < verticeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = 0;
            while ((dst = Integer.parseInt(st.nextToken())) != -1) {
                int distance = Integer.parseInt(st.nextToken());
                graph[src].add(new Node(dst, distance));
            }   
        }

        // dfs
        visit = new boolean[verticeCount + 1];
        visit[1] = true;
        dfs(0, 1);

        // dfs 2
        visit = new boolean[verticeCount + 1];
        visit[maxDistanceSrc] = true;
        dfs(0, maxDistanceSrc);
        System.out.println(maxDistance);
    }

    private static void dfs(int distance, int src) {
        if (distance > maxDistance) {
            maxDistance = distance;
            maxDistanceSrc = src;
        }
        List<Node> neighbors = graph[src];
        for (Node neighbor : neighbors) {
            if (!visit[neighbor.vertex]) {
                visit[neighbor.vertex] = true;
                dfs(distance + neighbor.distance, neighbor.vertex);
                visit[neighbor.vertex] = false;
            }
        }
    }

    private static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}
