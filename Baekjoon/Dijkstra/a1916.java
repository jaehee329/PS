import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a1916 {

    private static class Node implements Comparable<Node> {
        int end;
        int weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
        
    }

    private static int city, bus;
    private static ArrayList<ArrayList<Node>> map;
    private static int[] dist;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        
        dist = new int[city + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[city + 1];
        for (int i = 0; i <= city; i++) {
            map.add(new ArrayList<>());
        }

        // init map
        StringTokenizer st;
        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end, weight));
        }

        // dijkstra
        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());
        System.out.println(dijkstra(src, dst));
    }

    private static int dijkstra(int src, int dst) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            int target = pq.poll().end;
            if (!visit[target]) {
                visit[target] = true;
                for (Node node : map.get(target)) {
                    if (dist[node.end] > dist[target] + node.weight && !visit[node.end]) {
                        dist[node.end] = dist[target] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[dst];
    }
}
