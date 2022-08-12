import java.io.*;
import java.util.Arrays;

public class a2667_wrong {
    static int N;
    static int[] data;
    static boolean[] visit;
    static StringBuilder sb;
    static int dep;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int elem = N*N;
        data = new int[elem+1];
        for(int i=0; i<N; i++){ //1~N, N+1~2N
            String str = br.readLine();
            for(int j=1; j<=N; j++){
                data[i*N+j] = str.charAt(j-1)-'0';
            }
        }
        visit = new boolean[elem+1];
        dep = 0;
        int[] ans = new int[N*N];
        for(int i=1; i<elem; i++){
            if(!visit[i]&&data[i]==1){
                visit[i] = true;
                ans[dep]=dfs(i)+1;
                dep++;
            }
        }
        ans = Arrays.copyOfRange(ans, 0, dep);
        Arrays.sort(ans);
        System.out.println(dep);
        for(int i=0; i<dep; i++){
            System.out.println(ans[i]);
        }
    }
    static int dfs(int start){
        int c = 0;
        boolean t = false, b = false, l = false, r = false;
        if(start/N==0) t = true;
        else if (start/N==N-1) b = true;
        if(start%N==1) l = true;
        else if (start%N==0) r = true; 
        for(int i=0; i<4; i++){
            if(!t){
                if(data[start-N]==1&&!visit[start-N]){
                    c++;
                    visit[start-N] = true;
                    c+=dfs(start-N);
                }
            }
            if(!b){
                if(data[start+N]==1&&!visit[start+N]){
                    c++;
                    visit[start+N] = true;
                    c+=dfs(start+N);
                }
            }
            if(!l){
                if(data[start-1]==1&&!visit[start-1]){
                    c++;
                    visit[start-1] = true;
                    c+=dfs(start-1);
                }
            }
            if(!r){
                if(data[start+1]==1&&!visit[start+1]){
                    c++;
                    visit[start+1] = true;
                    c+=dfs(start+1);
                }
            }
        }
        return c;
    }
}
// 틀려서 그냥 https://n1tjrgns.tistory.com/245 이거 씀