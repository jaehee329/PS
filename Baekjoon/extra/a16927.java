import java.util.*;
import java.io.*;

public class a16927 {
	private static int N, M, R;
	private static int rounds;
	private static int[][] map;
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
    	setStaticVar();
    	rotate();
        print();
    }

    private static void setStaticVar() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());

    	map = new int[N][M];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
        rounds = Math.min(N, M)/2;
    }
    
    private static void rotate() {
    	for(int t=0; t<rounds; t++) {
            int perimeter = getPerimeter(t);
            for(int i=0; i<R%perimeter; i++) {
                int x = t;
                int y = t;
                int temp = map[x][y];
            
                int idx = 0;
                while(idx < 4) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];
                    if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    } 
                    else {
                        idx++;
                    }
                }
                map[t+1][t] = temp;
            }
        }
    }

    private static int getPerimeter(int t) {
        return 2*(M-1-2*t) + 2*(N-1-2*t);
    }
    
    private static void print() {
        StringBuilder sb = new StringBuilder();
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
                sb.append(map[i][j] + " ");
    		}
    		sb.append("\n");
    	}
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
