// recursive dfs
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class a1987 {
    private static final int MOVES = 4;
    private static final int[] YMOVE = {1, -1, 0, 0};
    private static final int[] XMOVE = {0, 0, -1, 1};
    private static int R;
    private static int C;
    private static char[][] board;
    private static boolean[] visit = new boolean[26];
    private static int maxDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setStaticVarFromBuffer(br);
        setMaxDepthFromCoord(new int[]{1, 1});
        System.out.println(maxDepth);
    }

    private static void setStaticVarFromBuffer(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R+1][C+1];
        for(int i=1; i<=R; i++) {
            String s = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j+1] = s.charAt(j);
            }
        }
    }

    private static void setMaxDepthFromCoord(int[] coord) {
        int startY = coord[0];
        int startX = coord[1];
        char visitChar = board[startY][startX];
        visit[visitChar-'A'] = true;

        int depth = 1;
        maxDepth = depth;
        Stack<int[]> stack = new Stack<>();
        stack.push(coord);
        dfs(stack, depth);
    }

    private static void dfs(Stack<int[]> stack, int depth) {
        maxDepth = (depth > maxDepth) ? depth : maxDepth;

        int[] src = stack.pop();
        int srcY = src[0];
        int srcX = src[1];
        for(int i=0; i<MOVES; i++) {
            int dstY = srcY + YMOVE[i];
            int dstX = srcX + XMOVE[i];
            int[] dstCoord = new int[]{dstY, dstX};
            if(isCoordValidAndNotVisited(dstCoord)) {
                stack.push(dstCoord);
                dfs(stack, depth+1);
                restoreVisitOnCoord(dstCoord);
            }
        }
    }

    private static boolean isCoordValidAndNotVisited(int[] coord) {
        int Y = coord[0];
        int X = coord[1];
        if(Y>=1 && Y<=R && X >=1 && X <=C) {
            char c = board[Y][X];
            if(!visit[c-'A']) {
                visit[c-'A'] = true;
                return true;
            }
        }
        return false;
    }

    private static void restoreVisitOnCoord(int[] coord) {
        int Y = coord[0];
        int X = coord[1];
        char c = board[Y][X];
        visit[c-'A'] = false;        
    }
}
