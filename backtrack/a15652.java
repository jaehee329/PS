import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a15652 {
    private static int N;
    private static int M;
    private static StringBuilder sb;
    private static boolean[] used;
    private static int[] seq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        seq = new int[N+1];
        
        backTrackFromGivenIdx(0, 1);

        System.out.println(sb);
    }
    private static void backTrackFromGivenIdx(int idx, int prev) {
        if(idx == M) {
            for(int i=0; i<M; i++) {
                sb.append(seq[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=prev; i<=N; i++) {
            if(i>=prev){
                seq[idx] = i;
                backTrackFromGivenIdx(idx+1, i);
            }
        }
    }
}
