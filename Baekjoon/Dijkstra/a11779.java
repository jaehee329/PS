// 문제에는 나와있지 않지만 정답이 여러가지일 경우 모두 인정됨.
import java.io.*;
import java.util.*;

public class a11779 {

    private static int cityCount;
    private static int busCount;
    private static Map<Integer, List<Node>> graph = new HashMap<>();
    private static int[] cost;
    private static int[] from;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cityCount = Integer.parseInt(br.readLine());
        busCount = Integer.parseInt(br.readLine());
        
        cost = new int[cityCount + 1];
        from = new int[cityCount + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        for (int i = 1; i <= cityCount; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(src).add(new Node(dest, weight));
        }
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dijkstra(src);

        System.out.println(cost[dest]);
        List<Integer> reversedRoute = getRoute(dest, src);
        System.out.println(reversedRoute.size());
        StringJoiner sj  = new StringJoiner(" ");
        for (int i = reversedRoute.size() - 1; i >= 0; i--) {
            sj.add(Integer.toString(reversedRoute.get(i)));
        }
        System.out.println(sj.toString());
    }

    private static void dijkstra(int src) {
        boolean[] visit = new boolean[cityCount + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(src, 0));
        cost[src] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (!visit[node.dest]) {
                visit[node.dest] = true;

                List<Node> neighbors = graph.get(node.dest);
                for (Node neighbor : neighbors) {
                    if (!visit[neighbor.dest] && cost[neighbor.dest] > cost[node.dest] + neighbor.weight) {
                        cost[neighbor.dest] = cost[node.dest] + neighbor.weight;
                        from[neighbor.dest] = node.dest;
                        pq.add(new Node(neighbor.dest, cost[neighbor.dest]));
                    }
                }
            }
        }
    }

    private static List<Integer> getRoute(int src, int dest) {
        List<Integer> route = new ArrayList<>();
        route.add(src);

        int currentSrc = src;
        while (currentSrc != dest) {
            int prev = from[currentSrc];
            route.add(prev);
            currentSrc = prev;
        }
        return route;
    }

    private static class Node implements Comparable<Node> {
        private final int dest;
        private final int weight;
        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
