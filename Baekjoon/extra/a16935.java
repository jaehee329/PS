import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a16935 {
    private static BufferedReader br;
    private static int N, M, R;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        setStaticVar();
        run();
        printResult();
    }

    private static void setStaticVar() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void run() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int c = Integer.parseInt(st.nextToken());
            switch(c) {
                case 1:
                    upDownInverse();
                    break;
                case 2:
                    leftRightInverse();
                    break;
                case 3:
                    clockWiseRotate90();
                    break;
                case 4:
                    counterClockWiseRotate90();
                    break;
                case 5:
                    clockWiseMix90();
                    break;
                case 6:
                    counterClockWiseMix90();
                    break;
            }
        }
    }

    private static void printResult() {
        int height = arr.length;
        int width = arr[0].length;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void upDownInverse() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[height][width];

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                temp[i][j] = arr[N-1-i][j];
            }
        }
        arr = temp;
    }

    private static void leftRightInverse() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[height][width];

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                temp[i][j] = arr[i][M-1-j];
            }
        }
        arr = temp;
    }

    private static void clockWiseRotate90() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[width][height];

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                temp[i][j] = arr[height-1-j][i];
            }
        }
        arr = temp;
    }

    private static void counterClockWiseRotate90() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[width][height];

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                temp[i][j] = arr[j][width-1-i];
            }
        }
        arr = temp;
    }

    private static void clockWiseMix90() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[height][width];
        int[] X = {0, width/2, width/2, 0, 0};
        int[] Y = {0, 0, height/2, height/2, 0};

        for(int i=0; i<4; i++) {
            int fromY = Y[i];
            int fromX = X[i];
            int toY = Y[i+1];
            int toX = X[i+1];
            for(int j=0; j<height/2; j++) {
                for(int k=0; k<width/2; k++) {
                    temp[toY+j][toX+k] = arr[fromY+j][fromX+k];
                }
            }
        }
        arr = temp;

    }

    private static void counterClockWiseMix90() {
        int height = arr.length;
        int width = arr[0].length;
        int[][] temp = new int[height][width];
        int[] X = {0, 0, width/2, width/2, 0};
        int[] Y = {0, height/2, height/2, 0, 0};

        for(int i=0; i<4; i++) {
            int fromY = Y[i];
            int fromX = X[i];
            int toY = Y[i+1];
            int toX = X[i+1];
            for(int j=0; j<height/2; j++) {
                for(int k=0; k<width/2; k++) {
                    temp[toY+j][toX+k] = arr[fromY+j][fromX+k];
                }
            }
        }
        arr = temp;

    }
}
