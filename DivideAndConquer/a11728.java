import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a11728 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+M];
        int cnt = 0;
        for(int len : new int[] {N,M}){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len; i++){
                arr[cnt] = Integer.parseInt(st.nextToken());
                cnt++;
            }
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}
