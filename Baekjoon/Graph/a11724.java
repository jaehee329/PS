import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class a11724 {
    static int N;
    static boolean[] visit;
    static boolean[][] graph;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        Arrays.fill(visit, true);
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true; graph[end][start] = true;
        }
        int component = 0;
        for(int i=1; i<=N; i++){
            if(visit[i]){
                component++;
                dfs(i);
            }
        }
        System.out.println(component);
    }
	public static void dfs(int start) {
		visit[start] = false;
		for(int i = 0 ; i <= N ; i++) {
			if(graph[start][i] && visit[i])
				dfs(i);
		}
	}
}