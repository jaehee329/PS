import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i=2; i<=N; i++) {
            arr[i] += arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 1;
        int cnt = 0;
        while(start<=N) {
            int partialSum = arr[end]-arr[start];
            if(partialSum == M){
                cnt++;
            }
            if(partialSum > M || end==N){
                start++;
            } else {
                end++;
            }
        }
        System.out.println(cnt);
    }
}
