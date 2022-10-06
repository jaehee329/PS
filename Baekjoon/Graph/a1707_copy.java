import java.io.*;
import java.util.*;

public class a1707_copy {
	static int v, e;
	static ArrayList<Integer>[] graph;
	static int visit[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			visit = new int[v+1];
		    graph = new ArrayList[v+1];
			for(int i = 0; i <= v; i++)
			    graph[i] = new ArrayList<Integer>();
			for(int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
			 graph[p1].add(p2);
			 graph[p2].add(p1);
			}
			dfs();
		}
	}

	public static void dfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= v; i++) {
			if(visit[i] == 0) {
				q.add(i);
				visit[i] = 1;
			}
			while(!q.isEmpty()) {
				int target = q.poll();
				for(int j = 0; j < graph[target].size(); j++) {
					if(visit[graph[target].get(j)] == 0) {
						q.add(graph[target].get(j));
					}
					if(visit[graph[target].get(j)] == visit[target]) {
						System.out.println("NO");
						return;
                    }
					if(visit[target] == 1 && visit[graph[target].get(j)] == 0)
						visit[graph[target].get(j)] = 2;
					else if(visit[target] == 2 && visit[graph[target].get(j)] == 0)
						visit[graph[target].get(j)] = 1;
				}
			}
		}
		System.out.println("YES");
	}
}