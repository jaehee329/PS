// https://velog.io/@jini_eun/%EB%B0%B1%EC%A4%80-1167%EB%B2%88-%ED%8A%B8%EB%A6%AC%EC%9D%98-%EC%A7%80%EB%A6%84-Java-Python
import java.util.*;
import java.io.*;

public class a1167_copy {
	static class Node {
		int node, dist;
		public Node(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	static ArrayList<Node>[] list;
	static boolean[] visit;
	static int max = 0;
	static int node, V;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		V = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			String str;
			while (!(str = st.nextToken()).equals("-1")) {
				int node = Integer.parseInt(str);
				int dist = Integer.parseInt(st.nextToken());
				list[idx].add(new Node(node, dist));
			}
		}

		visit = new boolean[V + 1];
		dfs(1, 0);

		visit = new boolean[V + 1];
		dfs(node, 0);

		System.out.println(max);
	}

	public static void dfs(int v, int len) {
		if (len > max) {
			max = len;
			node = v;
		}
		visit[v] = true;
		for (Node n : list[v]) {
			if (!visit[n.node]) {
				dfs(n.node, n.dist + len);
				visit[n.node] = true;
			}
		}
	}
}