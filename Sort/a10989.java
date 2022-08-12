// 단순 오름차순 정렬
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a10989 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] data = new int[N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        for(int i=0; i<N; i++){
            sb.append(data[i]+"\n");
        }
        System.out.println(sb);
   }
}