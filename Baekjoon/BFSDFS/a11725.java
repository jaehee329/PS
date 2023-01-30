import java.util.*;
import java.io.*;

public class a11725 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<LinkedList<Integer>> tree = new ArrayList<>();
        for(int i=0; i<=N+1; i++){
            tree.add(new LinkedList<>());
        }
        StringTokenizer st;
        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        int[] ans = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        visit[1] = true; q.add(1);
        while(!q.isEmpty()){
            int tar = q.poll();
            while(!tree.get(tar).isEmpty()){
                int next = tree.get(tar).poll();
                if(!visit[next]){
                    visit[next] = true;
                    q.add(next);
                    ans[next] = tar;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(ans[i]+"\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
