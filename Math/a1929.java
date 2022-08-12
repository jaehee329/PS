import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class a1929 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken());
        for(int i=M; i<=N; i++){
            if(i==1) continue;
            int t = (int)Math.sqrt(i);
            boolean f = true;
            for(int j=t; j>=2; j--){
                if(i%j==0){
                    f = false;
                    break;
                }
            }
            if(f){
                sb.append(i).append("\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}