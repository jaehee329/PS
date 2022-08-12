import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a9251 {
    static Integer[][] c;
    static char[] x;
    static char[] y;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = br.readLine().toCharArray();
        y = br.readLine().toCharArray();
        c = new Integer[x.length][y.length];
        System.out.println(LCS(x.length-1, y.length-1));
    }

    static int LCS(int i, int j){
        if(i<0 || j<0){
            return 0;
        }
        if (c[i][j] == null){
            c[i][j] = 0;
            if (x[i] == y[j]){
                c[i][j] = LCS(i-1, j-1)+1;
            } else {
                c[i][j] = Math.max(LCS(i-1, j), LCS(i, j-1));
            }
        }
        return c[i][j];
    }
}