import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class a1978 {
    public static void main(String[] args) throws IOException{
        int[] pr = new int[1001]; pr[1]=1;
        for(int i=2; i<=1000; i++){
            int t = (int)Math.sqrt(i);
            for(int j=t; j>=2; j--){
                if(i%j==0){
                    pr[i]=1;
                    break;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0;
        for(int i=0; i<N; i++){
            if(pr[Integer.parseInt(st.nextToken())]==0){
                a+=1;
            }
        }
        System.out.println(a);
    }
}