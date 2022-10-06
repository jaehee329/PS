// dfs implementation with stack was wrong
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class a1260 {
    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static boolean[] visit;
    static int start;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][N+1];
        visit = new boolean[N+1];
        Arrays.fill(visit,true);
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
            graph[start][end] = true; graph[end][start] = true;
        }
        // dfs
        /*
        Stack<Integer> s = new Stack<>();
        sb.append(start).append(" ");
        s.push(start);
        visit[start] = false;
        int current = start;
        while(!s.isEmpty()){
            for(int i=1; i<=N; i++){
                if(graph[current][i] && visit[i]){
                    visit[i] = false;
                    current = i;
                    sb.append(current).append(" ");
                    s.push(i);
                    continue;
                }
                if(i==N){
                    s.pop();
                    if(!s.isEmpty()){
                        current = s.peek();
                    }
                }
            }
        }
        System.out.println(sb);
        */
        dfs(start);
        System.out.println(sb);
        //bfs
        sb.setLength(0);
        Arrays.fill(visit,true);
        bfs(start);
        System.out.println(sb);
    }
	public static void dfs(int start) {
		
		visit[start] = false;
		sb.append(start + " ");
		
		for(int i = 0 ; i <= N ; i++) {
			if(graph[start][i] && visit[i])
				dfs(i);
		}
		
	}
    /*
    static void bfs(){
        while(!q.isEmpty()){
            int current = q.poll();
            for(int i=1; i<=N; i++){
                if(graph[current][i]&&visit[i]){
                    sb.append(i).append(" ");
                    visit[i] = false;
                    q.add(i);
                }
            }
            bfs();
        }
    }
    */
	public static void bfs(int start) {
		q.add(start);
		visit[start] = false;
		while(!q.isEmpty()) {
			start = q.poll();
			sb.append(start + " ");
			for(int i = 1 ; i <= N ; i++) {
				if(graph[start][i] && visit[i]) {
					q.add(i);
					visit[i] = false;
				}
			}
		}		
	}
}