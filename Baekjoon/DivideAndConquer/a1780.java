// 처음엔 queue를 기반으로 하여 작성했으나 메모리 초과로 재귀함수 사용
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1780 {
    static int[][] mat;
    static int nZero = 0;
    static int nMinus = 0;
    static int nPlus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        mat = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(N,0,0);
        System.out.println(nMinus);
        System.out.println(nZero);
        System.out.println(nPlus);
    }
    public static void cal(int matSize, int startRow, int startCol){
        int initialNum = mat[startRow][startCol];
        boolean t = false;
        for(int i=startRow; i<startRow+matSize; i++){
            for(int j=startCol; j<startCol+matSize; j++){
                int cur = mat[i][j];
                if(cur != initialNum){
                    t = true;
                    break;
                }
            }
            if(t) break;
        }
        if(t){
            for(int i=startRow; i<startRow+matSize; i+=matSize/3){
                for(int j=startCol; j<startCol+matSize; j+=matSize/3){
                    cal(matSize/3, i, j);
                }
            }
        } else {
            if(initialNum == 0) nZero++;
            else if(initialNum == -1) nMinus++;
            else nPlus++;
        }
    }
}
