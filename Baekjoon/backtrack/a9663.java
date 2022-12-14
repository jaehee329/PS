// 배치 가능 여부 배열을 2차원이 아닌 1차원으로 한다.
// 인덱스+1는 열, 값+1은 행
// 4*4의 배치를 [2, 0, 3, 1]로 표현하면 1열 3행, 2열 1행, 3열 4행, 4열 2행을 의미
import java.io.*;

public class a9663 {

    private static int[] position;
    private static int N;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		position = new int[N];
		nQueen(0);
		System.out.println(cnt);
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
