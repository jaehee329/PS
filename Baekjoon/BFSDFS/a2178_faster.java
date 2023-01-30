import java.util.*;
import java.io.*;

public class a2178_faster {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[][] maze = new int[M+1][N+1];
        for(int i=1; i<=N; i++){
            String row = br.readLine();
            for(int j=1; j<=M; j++){
                maze[j][i] = row.charAt(j-1)-'0';
            }
        }

        int[][] length = new int[M+1][N+1];
        for(int i=0; i<length.length; i++)  Arrays.fill(length[i], M*N);
        length[1][1] = 1;
        Queue<int[]> q = new LinkedList<>();
        int[] coord = new int[]{1,1};
        q.add(coord);
        while(!q.isEmpty()){
            coord = q.poll();
            int m = coord[0]; int n = coord[1];
            for(int i=-1; i<=1; i+=2){
                if(m+i>0 && m+i<=M){
                    if(maze[m+i][n]==1 && length[m+i][n]>length[m][n]+1){
                        length[m+i][n] = length[m][n]+1;
                        coord = new int[]{m+i,n};
                        q.add(coord);
                    }
                }
                if(n+i>0 && n+i<=N){
                    if(maze[m][n+i]==1 && length[m][n+i]>length[m][n]+1){
                        length[m][n+i] = length[m][n]+1;
                        coord = new int[]{m,n+i};
                        q.add(coord);
                    }
                }
            }
        }
        System.out.println(length[M][N]);
    }
}

// using Stack => dfs, slow for maze, Queue(bfs) was almost 8~10times faster
// also visit[][] had no change in time complexity.