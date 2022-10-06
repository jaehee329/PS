import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        for(int i=1; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());
            min = min>cur ? cur : min;
            max = max<cur ? cur : max;
        }
        System.out.println(min+" "+max);
    }
}
