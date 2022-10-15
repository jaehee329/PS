import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s5215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int i=1; i<=tc; i++) {
            addBestCombination(i, br, sb);
        }
        // sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void addBestCombination(int idx, BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxCal = Integer.parseInt(st.nextToken());
        int[][] scoreCal = new int[N][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            scoreCal[i][0] = Integer.parseInt(st.nextToken());
            scoreCal[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scoreCal, (a,b) -> 1000*b[1]/b[0] - 1000*a[1]/a[0]);
        
        int cal = 0;
        int score = 0;
        for(int i=0; i<N; i++) {
            if(cal <= maxCal-scoreCal[i][1]) {
                System.out.println("adding score = "+ scoreCal[i][0] + " cal = " + scoreCal[i][1]);
                score += scoreCal[i][0];
                cal += scoreCal[i][1];
            } else {
                break;
            }
        }
        
        sb.append("#" + idx + " " + score);
    }
}

// 1
// 5 1000
// 100 200
// 300 500
// 250 300
// 500 1000
// 400 400