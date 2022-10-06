import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class a11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N+1]; int[] use = new int[N+1]; int[] not = new int[N+1];
        data[0] = use[0] = not[0] = not[1] = 0; use[1]=1;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1; i<=N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++){
            int j=i-1;
            int max = 0;
            while(j>=0){
                if(data[j]<data[i] && max < use[j]){
                    max = use[j];
                }
                j--;
            }
            use[i] = max+1;
            not[i] = Math.max(use[i-1],not[i-1]);
        }
        System.out.println(Math.max(use[N],not[N]));
    }
}