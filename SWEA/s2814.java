import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2814 {
	private static boolean[][] map;
	private static boolean[] visited;
	private static int max;
	private static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for(int i=1; i<=tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			max = Integer.MIN_VALUE;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			n = N;

			map = new boolean[N+1][N+1];
			visited = new boolean[N+1];

			for(int j=0; j<M; j++) {
                st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken());
				int n2 = Integer.parseInt(st.nextToken());
				map[n1][n2] = true;
                map[n2][n1] = true;
			}

			for(int j=1; j<N+1; j++) {
				dfs(1, j);
				visited[j] = false;
			}

			sb.append("#" + i + " " + max + "\n");
		}
        sb.setLength(sb.length()-1);
        System.out.println(sb);
	}

	private static void dfs(int len, int v) {
		visited[v] = true;
		for(int i = 0; i < n+1; i++) {
			if(map[v][i] && !visited[i]) {
				dfs(len+1, i);
				visited[i] = false;
			}
		}	
		max = Math.max(len, max);
	}
}