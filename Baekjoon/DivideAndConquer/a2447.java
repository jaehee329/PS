import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a2447 {
    static int N;
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stars = new char[N][N];
        star(N,0,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
    private static void star(int N, int row, int col){
        if(N==3){
            for(int i=row; i<row+3; i++){
                for(int j=col; j<col+3; j++){
                    stars[i][j] = '*';
                }
            }
            stars[row+1][col+1] = ' ';
            return;
        }
        for(int i=row; i<row+N; i+=N/3){
            for(int j=col; j<col+N; j+=N/3){
                if(!(i==row+N/3 && j==col+N/3)){
                    star(N/3, i, j);
                } else {
                    indent(N/3, i, j);
                }
            }
        }
    }
    private static void indent(int N, int row, int col){
        for(int i=row; i<row+N; i++){
            for(int j=col; j<col+N; j++){
                stars[i][j] = ' ';
            }
        }
    }
}
