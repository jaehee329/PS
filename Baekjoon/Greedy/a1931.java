import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class a1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }
        Comparator<int[]> com = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]){
                    return a[0]-b[0];
                }
                return a[1]-b[1];
            }
        };
        Arrays.sort(schedule, com);

        int cnt = 1;
        int prevEnd = schedule[0][1];
        for(int i=1; i<N; i++) {
            if(schedule[i][0] >= prevEnd){
                cnt++;
                prevEnd = schedule[i][1];
            }
        }
        System.out.println(cnt);
    }
}
