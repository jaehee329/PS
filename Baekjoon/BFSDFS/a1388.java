import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class a1388 {

    private static int N;
    private static int M;
    private static char[][] floor;
    private static boolean[][] visit;
    private static final int NUMOFMOVES = 2;
    private static final int[] XMOVE = {-1, 1};
    private static final int[] YMOVE = {1, -1};

    public static void main(String[] args) throws Exception {
        staticVarSetter();
        int numOfTiles = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visit[i][j]) {
                    numOfTiles++;
                    visit[i][j] = true;
                    Integer[] startPos = {i, j};
                    dfs(startPos);
                }
            }
        }
        System.out.println(numOfTiles);
    }

    private static void staticVarSetter() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N][M];
        floor = new char[N][M];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<M; j++) {
                floor[i][j] = line.charAt(j);
            }
        }
    }

    private static void dfs(Integer[] startPos) {
        Stack<Integer[]> s  = new Stack<>();
        s.add(startPos);
        char shape = floor[startPos[0]][startPos[1]];
        while(!s.isEmpty()) {
            Integer[] targetPos = s.pop();
            int tarY = targetPos[0];
            int tarX = targetPos[1];
            for(int i=0; i<NUMOFMOVES; i++) {
                if(shape=='-'){
                    int checkX = tarX+XMOVE[i];
                    if(checkX>=0 && checkX<M) {
                        if(!visit[tarY][checkX] && floor[tarY][checkX]==shape) {
                            visit[tarY][checkX] = true;
                            s.add(new Integer[]{tarY, checkX});
                        }
                    }
                } else {
                    int checkY = tarY+YMOVE[i];
                    if(checkY>=0 && checkY<N) {
                        if(!visit[checkY][tarX] && floor[checkY][tarX]==shape) {
                            visit[checkY][tarX] = true;
                            s.add(new Integer[]{checkY, tarX});
                        }
                    }
                }
            }
        }
    }
}
