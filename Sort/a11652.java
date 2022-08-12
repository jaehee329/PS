import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class a11652 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] data = new long[N];

        for(int i=0; i<N; i++){
            data[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(data);

        int cnt = 1, max = 1, maxIdx = 0;
        for(int i = 1; i < N; i++) {
            if(data[i] == data[i-1]) cnt++;
            else cnt = 1;

            if(cnt > max) {
                max = cnt;
                maxIdx = i;
            }
        }
        System.out.println(data[maxIdx]);
   }
}