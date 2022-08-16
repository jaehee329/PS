import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class a2448 {
    static int[][] N;
    static char[][] stars;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][2*N-1];
        for(int i=0; i<N; i++){
            Arrays.fill(stars[i], ' ');
        }
        star(N, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<2*N-1; j++){
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void star(int N, int topRow, int topCol){
        if(N == 3){
            int[] row = {0,1,1,2,2,2,2,2};
            int[] col = {0,-1,1,-2,-1,0,1,2};
            for(int i=0; i<8; i++){
                int r = row[i]; int c = col[i];
                stars[topRow+r][topCol+c] = '*';
            }
            return;
        }
        star(N/2, topRow, topCol);
        star(N/2, topRow+N/2, topCol-N/2);
        star(N/2, topRow+N/2, topCol+N/2);
    }
}
