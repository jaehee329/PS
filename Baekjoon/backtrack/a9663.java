import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a9663 {
    private static int cnt;
    private static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(br.readLine());
        boolean[][] unsafe = new boolean[8][8];
        bruteForce(0, 0, 1, unsafe);
        System.out.println(cnt);
    }
    
    private static void bruteForce(int a, int b, int n, boolean[][] unsafe) {
        for (int i = a; i < 8; i++) {
            for (int j = b; j < 8; j++) {
                if (unsafe[i][j] == false) {
                    if (n == target) {
                        cnt++;
                        continue;
                    }
                    boolean[][] nextUnsafe = unsafeCheck(i, j, unsafe);
                    bruteForce(i+1, j+1, n+1, nextUnsafe);
                }
            }
        }
    }

    private static boolean[][] unsafeCheck(int i, int j, boolean[][] unsafe) {
        boolean[][] nextUnsafe = new boolean[8][8];
        for (int x = 0; x < 8; x++) {
            nextUnsafe[x] = unsafe[x].clone();
        }
        // horizontal & vertical
        for (int x = 0; x < 8; x++) {
            nextUnsafe[i][x] = true;
            nextUnsafe[x][j] = true;
        }
        // diagonal
        for (int x = -4; x < 4; x++) {
            if (i+x > 0 && i+x < 8 && j+x > 0 && j+x < 8) {
                nextUnsafe[i+x][j+x] = true;
            }
            if (i-x > 0 && i-x < 8 && j+x > 0 && j+x < 8) {
                nextUnsafe[i-x][j+x] = true;
            }
        }
        return nextUnsafe;
    }
}
