import java.io.*;
import java.util.*;

public class a14938 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int regionCount = Integer.parseInt(st.nextToken());
        int maxCost = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] itemCounts = new int[regionCount + 1];
        for (int i = 1; i <= regionCount; i++) {
            itemCounts[i] = Integer.parseInt(st.nextToken());
        }
        
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 1; i <= regionCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(src).add(new Node(dst, weight));
            graph.get(dst).add(new Node(src, weight));
        }

        int maxItems = 0;
        for (int i = 1; i <= regionCount; i++) {
            int items = 0;
            int[] distances = dijkstra(graph, i);
            for (int j = 1; j <= regionCount; j++) {
                if (distances[j] <= maxCost) {
                    items += itemCounts[j];
                }
            }
            maxItems = Math.max(items, maxItems);
        }

        System.out.println(maxItems);
    }

    private static int[] dijkstra(Map<Integer, List<Node>> graph, int src) {
        int[] costs = new int[graph.size() + 1];
        boolean[] visit = new boolean[graph.size() + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int to = pq.poll().dst;
            if (!visit[to]) {
                visit[to] = true;
                List<Node> neighbors = graph.get(to);
                for (Node neighbor : neighbors) {
                    if (costs[neighbor.dst] > costs[to] + neighbor.weight) {
                        costs[neighbor.dst] = costs[to] + neighbor.weight;
                        pq.add(new Node(neighbor.dst, costs[neighbor.dst]));
                    }
                }
            }
        }
        return costs;
    }

    private static class Node implements Comparable<Node>{

        private final int dst;
        private final int weight;

        public Node(int dst, int weight) {
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
