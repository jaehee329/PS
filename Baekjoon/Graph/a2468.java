// 문제에서 명시되지 않았으나 최대 영역 수의 최솟값은 1임에 유의. 0으로 초기화하고 사용했더니 틀렸음
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a2468_2nd {
    private static int N;
    private static int[][] map;
    private static int maxAlt;
    private static final int NUMOFMOVES = 4;
    private static final int[] XMOVE = {0, 0, -1, 1};
    private static final int[] YMOVE = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        staticVarSetter();
        int waterLvl = 1;
        int maxRegions = 1;
        while(waterLvl<maxAlt){
            int regions = findNumOfRegions(waterLvl);
            maxRegions = regions>maxRegions?regions:maxRegions;
            waterLvl++;
        }
        System.out.println(maxRegions);
    }
    private static void staticVarSetter() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxAlt = 0;
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int alt = Integer.parseInt(st.nextToken());
                map[i][j] = alt;
                maxAlt = alt>maxAlt?alt:maxAlt;
            }
        }
    }
    private static int findNumOfRegions(int waterLvl) {
        int numOfRegions = 0;
        boolean[][] visit = new boolean[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visit[i][j] && map[i][j]>waterLvl) {
                    numOfRegions++;
                    visit[i][j] = true;
                    Integer[] startPos = {i, j};
                    bfs(visit, startPos, waterLvl);
                }
            }
        }
        return numOfRegions;
    }
    private static void bfs(boolean[][] visit, Integer[] startPos, int waterLvl) {
        Queue<Integer[]> q = new LinkedList<>();
        q.add(startPos);
        while (!q.isEmpty()) {
            Integer[] currentPos = q.poll();
            int y = currentPos[0];
            int x = currentPos[1];
            for (int i=0; i<NUMOFMOVES; i++) {
                int tarY = y + YMOVE[i];
                int tarX = x + XMOVE[i];
                if(tarY>=0 && tarY<N && tarX>=0 && tarX<N){
                    if (!visit[tarY][tarX] && map[tarY][tarX]>waterLvl) {
                        visit[tarY][tarX] = true;
                        q.add(new Integer[]{tarY, tarX});
                    }
                }
            }
        }
    }
}
