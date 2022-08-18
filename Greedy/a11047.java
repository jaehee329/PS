import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        for(int i=N-1; i>=0; i--){
            coin[i] = Integer.parseInt(br.readLine());
        }
        int remain = K;
        int cnt = 0; 
        for(int i=0; i<N; i++){
            if(remain>=coin[i]){
                int num = remain/coin[i];
                remain = remain-num*coin[i];
                cnt += num;
                if(remain == 0){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
    
}
