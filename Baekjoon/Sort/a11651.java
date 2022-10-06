import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] data = new int[N][2];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data, (a, b) -> {
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            else {
                return a[1] - b[1];
            }
        });

        for(int i=0; i<N; i++){
            sb.append(data[i][0]+" "+data[i][1]+"\n");
        }
        System.out.println(sb);
   }
}
