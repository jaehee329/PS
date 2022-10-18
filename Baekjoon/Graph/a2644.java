// dfs
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class a2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        int numOfEdges = Integer.parseInt(br.readLine());

        boolean[][] relation = new boolean[N+1][N+1];
        for(int i=0; i<numOfEdges; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            relation[v1][v2] = true;
            relation[v2][v1] = true;
        }

        boolean[] visit = new boolean[N+1];
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{src, 0});
        visit[src] = true;
        while(!stack.isEmpty()) {
            Integer[] t = stack.pop();
            int s = t[0];
            int depth = t[1];
            for(int i=1; i<=N; i++) {
                if(relation[s][i] && !visit[i]) {
                    if(i==dest) {
                        System.out.println(depth+1);
                        return;
                    }
                    stack.push(new Integer[]{i, depth+1});
                    visit[i] = true;
                }
            }
        }
        System.out.println(-1);
        return;
    }    
}
