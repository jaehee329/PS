import java.io.*;
import java.util.*;

public class a1967 {
    static class Node {
        int node, dist;
        public Node (int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    static ArrayList<Node>[] tree;
    static boolean[] visit;
    static int maxLen = 0;
    static int node, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            node = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            tree[src].add(new Node(node, length));
            tree[node].add(new Node(src, length));
        }

        visit = new boolean[N+1];
        dfs(1,0);
        visit = new boolean[N+1];
        dfs(node, 0);
        System.out.println(maxLen);
    }
    public static void dfs(int v, int len){
        if(len>maxLen){
            maxLen = len;
            node = v;
        }
        visit[v] = true;
        for(Node n : tree[v]){
            if (!visit[n.node]) {
                visit[n.node] = true;
				dfs(n.node, n.dist+len);
			}
        }
    }
}
