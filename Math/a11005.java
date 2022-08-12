import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a11005 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while(N>0){
            int r = N%B; N = N/B;
            if(r<10){
                sb.insert(0,r);
            }else{ // 10~35
                sb.insert(0,(char)(r-10+'A'));
            }
        }
        System.out.println(sb);
    }
}