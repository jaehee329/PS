import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s1206 {
    public static void main(String[] args) throws IOException {
        final int TC = 10;
        final int[] CHECK_IDX = {-2, -1, 1, 2};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i=0; i<TC; i++) {
            int cnt = 0;
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] heights = new int[N];
            for(int j=0; j<N; j++) {
                heights[j] = Integer.parseInt(st.nextToken());
            }
            for (int j=2; j<N-2; j++) {
                int height = heights[j];
                int nearMax = 0;
                for (int k : CHECK_IDX) {
                    int nearHeight = heights[j+k];
                    if(nearHeight>height) {
                        nearMax = height;
                        break;
                    }
                    nearMax = (nearHeight>nearMax) ? nearHeight : nearMax;
                }
                cnt += height - nearMax;
            }
            sout(i, cnt);
        }
        br.close();
    }
    private static void sout(int i, int cnt) {
        System.out.println("#" + (i+1) + " " +cnt);
    }
}
