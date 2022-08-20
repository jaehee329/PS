import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int tot = 0;
        int pre = 0;
        for(int i=0; i<N; i++){
            pre += p[i];
            tot += pre;
        }
        System.out.println(tot);
    }
}
