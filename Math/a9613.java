import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a9613 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[] c = new int[M]; long sum = 0;
            for(int j=0; j<M; j++){
                c[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<M-1; j++){
                for(int k=j+1; k<M; k++){
                    sum+=gcd(c[j],c[k]);
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb);
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b; b = r;
        }
        return a;
    }
}