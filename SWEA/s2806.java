// BOJ 9663 N-Queen과 동일 문제
import java.io.*;

public class s2806 {

    private static int[] position;
    private static int N;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            N = Integer.parseInt(br.readLine());
            cnt = 0;
            position = new int[N];
            nQueen(0);
            System.out.println("#" + i + " " + cnt);
        }
    }

    private static void nQueen(int col) {
        if (col == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (puttable(i, col)) {
                position[col] = i;
                nQueen(col + 1);
            }
        }
    }

    private static boolean puttable(int row, int col) {
        for (int c = 0; c < col; c++) {
            if (position[c] == row ) {
                return false;
            }
            if (Math.abs(col - c) == Math.abs(position[c] - row)) {
                return false;
            }
        }
        return true;
    }
}
