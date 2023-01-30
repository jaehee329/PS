import java.io.*;
import java.util.*;

public class a1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		int index = N;
		int n = 0;
        int[] visited = new int[100001];
		visited[index] = 1;
		while (!q.isEmpty()) {
			n = q.poll();
			if (n == K) {
				return visited[n]-1;
			}
			if (n-1>=0 && visited[n-1] == 0) {
				visited[n-1] = visited[n]+1;
				q.add(n-1);
			}
			if (n+1<=100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n]+1;
				q.add(n+1);
			}
			if (2*n<=100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n]+1;
				q.add(2*n);
			}
		}
		return 0;
	}
}