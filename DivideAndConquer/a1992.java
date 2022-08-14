import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a1992 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] screen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        screen = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                screen[i][j] = (int)(s.charAt(j)-'0');
            }
        }
        quadTree(N, 0, 0);
        System.out.println(sb);
    }

    private static void quadTree(int n, int row, int col){
        int init = screen[row][col];
        if(n==1){
            sb.append(init);
            return;
        }
        boolean flag = false;
        for(int i=row; i<row+n; i++){
            for(int j=col; j<col+n; j++){
                if(screen[i][j]!=init){
                    flag = true;
                    sb.append("(");
                    for(int k=0; k<2; k++){
                        for(int m=0; m<2; m++){
                            quadTree(n/2, row+k*n/2, col+m*n/2);
                        }
                    }
                    sb.append(")");
                    break;
                }
            }
            if(flag) break;
        }
        if(!flag) sb.append(init);
    }
}
