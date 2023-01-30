import java.io.*;
import java.util.*;

public class a9466_wrong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());
        for(int t=1; t<=tc; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] data = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }
            boolean[] visit = new boolean[n+1];
            TreeMap<Integer,Integer> g = new TreeMap<>();
            int failed = 0; 
            for(int i=1; i<=n; i++){
                int idx = i;
                if(!visit[idx]){
                    visit[idx] = true;
                    if(data[idx]!=i&&visit[data[idx]]){
                        failed++;
                        continue;
                    }
                    int c = 1;
                    g.put(i,c);
                    boolean flag = true;
                    while(flag){
                        int target = data[idx];
                        visit[idx] = true;
                        if(g.containsKey(target)){
                            flag = false;
                            failed += g.get(target)-1;
                            g.clear();
                        }
                        else{
                            c++;
                            g.put(target,c);
                            idx = target;
                        }
                    }
                }
            }
            sb.append(failed+"\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
