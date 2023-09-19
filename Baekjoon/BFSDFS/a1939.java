import java.io.*;
import java.util.*;

public class a1939 {

    private static ArrayList<ArrayList<Node>> map;
    private static int n;
    private static int from;
    private static int to;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            map.get(src).add(new Node(dst, weight));
            map.get(dst).add(new Node(src, weight));
            lo = Math.min(lo, weight);
            hi = Math.max(hi, weight);
        }

        st = new StringTokenizer(br.readLine());
        from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        int maxWeight = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (bfs(mid)) {
                lo = mid + 1;
                maxWeight = mid;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(maxWeight);
    }

    public static boolean bfs(int weight) {
        boolean[] visit = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(from, 0));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.to == to) {
                return true;
            }
            for (Node node : map.get(curr.to)) {
                if (!visit[node.to] && weight <= node.weight) {
                    q.add(node);
                    visit[node.to] = true;
                }
            }
        }
        return false;
    }

    private static class Node {
        public int to;
        public int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
