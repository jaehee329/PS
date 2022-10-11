import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a21200_wrong {
    private static int N;
    private static int[][] board;
    private static int MAX = Integer.MIN_VALUE;
    private static final int MOVE = 5;

    private static class data {
        public int max;
        public int[][] board = new int[N][N];
        public data (int max, int[][] board) {
            this.max = max;
            this.board = board;
        }
    }

    public static void main(String[] args) throws IOException {
        setStaticVar();

        data input = new data(MAX, board);
        int round = 1;
        backtrack(input, round);
        
        System.out.println(MAX);
    }

    private static void setStaticVar() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        board = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int t = Integer.parseInt(st.nextToken());
                board[i][j] = t;
                MAX = (MAX<t) ? t : MAX;
            }
        }
    }

    private static void backtrack(data input, int round) {
        if (round > MOVE) {
            MAX = (MAX<input.max) ? input.max : MAX;
            return;
        }

        if (input.max * Math.pow(2, MOVE+1-round) < MAX) {
            return;
        }

        for (int i=0; i<4; i++) {
            data output = moveMatcher(i, input);
            backtrack(output, ++round);
            round--;
        }
    }
    
    private static data moveMatcher(int x, data input) {
        data output;
        switch(x) {
            case 0:
                output = moveLeft(input);
                return output;
            case 1:
                output = moveRight(input);
                return output;
            case 2:
                output = moveUp(input);
                return output;
            default:
                output = moveDown(input);
                return output;
        }
    }

    private static void show(data output) {
        System.out.println("//SHOW BOARD//");
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                System.out.print(output.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Max = " + output.max);
    }

    private static data moveLeft(data input) {
        int[][] b = input.board;
        int[][] out = new int[N][N];
        boolean[][] merged = new boolean [N][N];
        int max = input.max;
        for (int i=0; i<N; i++) {
            int idx = 0;
            for (int j=0; j<N; j++) {
                int t = b[i][j];
                if (t!=0) {
                    if (idx>0 && out[i][idx-1]==t && !merged[i][idx-1]) {
                        merged[i][idx-1] = true;
                        out[i][idx-1] *= 2;
                        max = (out[i][idx-1]>input.max) ? out[i][idx-1] : input.max;
                    } else {
                        out[i][idx] = b[i][j];
                        idx++;
                    }
                }
            }
        }
        data output = new data(max, out);
        return output;
    }

    private static data moveRight(data input) {
        int[][] b = input.board;
        int[][] out = new int[N][N];
        boolean[][] merged = new boolean [N][N];
        int max = input.max;
        for (int i=0; i<N; i++) {
            int idx = N-1;
            for (int j=N-1; j>=0; j--) {
                int t = b[i][j];
                if (t!=0) {
                    if (idx<N-1 && out[i][idx+1]==t && !merged[i][idx+1]) {
                        merged[i][idx+1] = true;
                        out[i][idx+1] *= 2;
                        max = (out[i][idx+1]>input.max) ? out[i][idx+1] : input.max;
                    } else {
                        out[i][idx] = b[i][j];
                        idx--;
                    }
                }
            }
        }
        data output = new data(max, out);
        return output;
    }

    private static data moveUp(data input) {
        int[][] b = input.board;
        int[][] out = new int[N][N];
        boolean[][] merged = new boolean [N][N];
        int max = input.max;
        for (int j=0; j<N; j++) {
            int idx = 0;
            for (int i=0; i<N; i++) {
                int t = b[i][j];
                if (t!=0) {
                    if (idx>0 && out[idx-1][j]==t && !merged[idx-1][j]) {
                        merged[idx-1][j] = true;
                        out[idx-1][j] *= 2;
                        max = (out[idx-1][j]>input.max) ? out[idx-1][j] : input.max;
                    } else {
                        out[idx][j] = b[i][j];
                        idx++;
                    }
                }
            }
        }
        data output = new data(max, out);
        return output;
    }

    private static data moveDown(data input) {
        int[][] b = input.board;
        int[][] out = new int[N][N];
        boolean[][] merged = new boolean [N][N];
        int max = input.max;
        for (int j=0; j<N; j++) {
            int idx = N-1;
            for (int i=N-1; i>=0; i--) {
                int t = b[i][j];
                if (t!=0) {
                    if (idx<N-1 && out[idx+1][j]==t && !merged[idx+1][j]) {
                        merged[idx+1][j] = true;
                        out[idx+1][j] *= 2;
                        max = (out[idx+1][j]>input.max) ? out[idx+1][j] : input.max;
                    } else {
                        out[idx][j] = b[i][j];
                        idx--;
                    }
                }
            }
        }
        data output = new data(max, out);
        return output;
    }
}

// 3
// 2 2 2
// 4 4 4
// 8 8 8

// 4
// 2 2 2 16
// 4 0 2 4
// 2 0 0 4
// 2 2 0 8

// L
// 4 2 16 0
// 4 2 4 0
// 2 4 0 0
// 4 8 0 0

// U
// 8 4 16 0
// 2 4 4 0
// 4 8 0 0
// 0 0 0 0

// U
// 8 8 16 0
// 2 8 4 0
// 4 0 0 0
// 0 0 0 0

// L
// 16 16 0 0
// 2 8 4 0
// 4 0 0 0
// 0 0 0 0

// L
// 32 0 0 0
// 2 8 4 0
// 4 0 0 0
// 0 0 0 0

