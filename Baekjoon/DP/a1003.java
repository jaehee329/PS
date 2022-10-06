import java.io.BufferedReader;
import java.io.InputStreamReader;

public class a1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tc = new int[N];
        int maxTc = 0;
        for(int i=0; i<N; i++) {
            int t = Integer.parseInt(br.readLine());
            maxTc = t>maxTc?t:maxTc;
            tc[i] = t;
        }
        int t = maxTc>1?maxTc:1;
        int[][] fibonacci = new int[t+1][2];
        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;
        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;
        for(int i=2; i<=maxTc; i++) {
            fibonacci[i][0] = fibonacci[i-2][0]+fibonacci[i-1][0];
            fibonacci[i][1] = fibonacci[i-2][1]+fibonacci[i-1][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int fib = tc[i];
            sb.append(fibonacci[fib][0] + " " +fibonacci[fib][1] + "\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
