import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for(int cse=0; cse<c; cse++){
            int N = Integer.parseInt(br.readLine());
            int[][] ab = new int[4][N];
            for(int k=0; k<2; k++){
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str," ");
                for(int j=0; j<N; j++){
                    ab[k][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j=0; j<N; j++){
                if(j>1){
                    ab[2][j] = Math.max(ab[3][j-1]+ab[0][j], Math.max(ab[2][j-2]+ab[0][j],ab[3][j-2]+ab[0][j]));
                    ab[3][j] = Math.max(ab[2][j-1]+ab[1][j], Math.max(ab[3][j-2]+ab[1][j],ab[2][j-2]+ab[1][j]));
                } else if(j==0) {
                    ab[2][0] = ab[0][0]; ab[3][0] = ab[1][0];
                } else {
                    ab[2][1] = ab[3][0]+ab[0][1];
                    ab[3][1] = ab[2][0]+ab[1][1];
                }
            }
            System.out.println(Math.max(ab[2][N-1],ab[3][N-1]));
        }
    }
}