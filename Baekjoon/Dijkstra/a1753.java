import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a1753 {

    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    private static int vertex, edge;
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] dist;
    private static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        int src = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        dist = new int[vertex + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[vertex + 1];
        for (int i = 0; i <= vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }

        dijkstra(src);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= vertex; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int target = pq.poll().end;
            if (!visit[target]) {
                visit[target] = true;
                for (Node node : graph.get(target)) {
                    if (dist[node.end] > dist[target] + node.weight && !visit[node.end]) {
                        dist[node.end] = dist[target] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }
}
