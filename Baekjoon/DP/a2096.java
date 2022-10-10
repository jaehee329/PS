// 쉬운 DP 문제
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a2096 {
    private static int N;
    private static int[][] arr;
    private static int[][] minDp;
    private static int[][] maxDp;
    public static void main(String[] args) throws IOException {
        setStaticVar();
        setDp();

        int Max = Math.max(Math.max(maxDp[N][0], maxDp[N][1]), maxDp[N][2]);
        int min = Math.min(Math.min(minDp[N][0], minDp[N][1]), minDp[N][2]);
        System.out.println(Max + " " + min);
    }

    private static void setStaticVar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[N+1][3];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minDp = new int[N+1][3];
        maxDp = new int[N+1][3];
    }

    private static void setDp() {
        for(int i = 1; i <= N; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];
            maxDp[i][1] = Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + arr[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];
            
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];
            minDp[i][1] = Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + arr[i][1];
            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }
    }
}
