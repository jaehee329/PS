import java.io.*;
import java.util.*;

public class a1503 {

    private static final Map<Integer, List<Node>> graph = new HashMap<>();
    private static int vertexCount;
    private static int edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertexCount = Integer.parseInt(st.nextToken());
        edgeCount = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= vertexCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(src).add(new Node(dest, weight));
            graph.get(dest).add(new Node(src, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        
        int[] costs1 = dijkstra(v1);
        int[] costs2 = dijkstra(v2);

        int midCost = costs1[v2];
        if (midCost == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        int minCost1 = costs1[1] + midCost + costs2[vertexCount];
        int minCost2 = costs2[1] + midCost + costs1[vertexCount];

        if (costs1[1] == Integer.MAX_VALUE || costs2[vertexCount] == Integer.MAX_VALUE) {
            minCost1 = Integer.MAX_VALUE;
        }
        if (costs2[1] == Integer.MAX_VALUE || costs1[vertexCount] == Integer.MAX_VALUE) {
            minCost2 = Integer.MAX_VALUE;
        }
        if (minCost1 == Integer.MAX_VALUE && minCost2 == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.min(minCost1, minCost2));
    }

    private static int[] dijkstra(int src) {
        boolean[] visit = new boolean[vertexCount + 1];
        int[] minCost = new int[vertexCount + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node destNode = pq.poll();
            int next = destNode.getDest();
            if (!visit[next]) {
                visit[next] = true;

                for (Node node : graph.get(next)) {
                    int dst = node.getDest();
                    int weight = node.getWeight();
                    if (minCost[dst] > minCost[next] + weight && !visit[dst]) {
                        minCost[dst] = minCost[next] + weight;
                        pq.add(new Node(dst, minCost[dst]));
                    }
                }
            }
        }
        return minCost;
    }
    
    private static class Node implements Comparable<Node> {

        private final int dest;
        private final int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
