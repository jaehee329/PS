// 이분탐색으로도 가능하나 구간합으로 풀었음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a3020 {
    private static int[] bottom;
    private static int[] top;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        bottom = new int[H+1];
        top = new int[H+1];
        for(int i=0; i<N/2; i++) {
            bottom[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }
        for(int i=H-1; i>0; i--) {
            bottom[i] += bottom[i+1];
            top[i] += top[i+1]; 
        }
        int min = N;
        int cnt = 0;
        for(int i=1; i<=H; i++) {
            int t = bottom[i]+top[H-i+1];
            if(min>t) {
                min = t;
                cnt = 1;
            } else if(min==t) {
                cnt++;
            }
        }
        System.out.println(min+ " " + cnt);
    }
}
