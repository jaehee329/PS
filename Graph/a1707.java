import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class a1707 {
    static int N;
    static boolean[] visit;
    static List<LinkedList<Integer>> graph;
    static boolean[] color;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int g = Integer.parseInt(st.nextToken());
        for(int k=1; k<=g; k++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList<LinkedList<Integer>>();
            for(int i=0; i<=N; i++){
                graph.add(new LinkedList<Integer>());
            }
            visit = new boolean[N+1];
            color = new boolean[N+1];
            Arrays.fill(visit, true);
            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end); graph.get(end).add(start);
            }
            flag = false;
            dfs(1, true);
            for(int i=1; i<=N; i++){
                if(visit[i]){
                    flag = true;
                    break;
                }
            }
            if(flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }
	public static void dfs(int start, boolean c) {
		visit[start] = false;
        color[start] = c;
        Iterator<Integer> iter = graph.get(start).iterator();
        while(iter.hasNext()){
            int target = iter.next();
            if(visit[target]){
                dfs(target, !c);
            } else if(color[target]==c){
                flag = true;
            }
        }
	}
}