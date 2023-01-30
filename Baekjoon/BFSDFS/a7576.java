import java.util.*;
import java.io.*;

public class a7576 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken());
        int[][] box = new int[M+1][N+1];
        int target = 0;
        int ones = 0;
        boolean[][] visit = new boolean[M+1][N+1];
        Stack<Integer[]> old = new Stack<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int num = Integer.parseInt(st.nextToken());
                box[j][i] = num;
                if(num==0) target++;
                else if(num==1){
                    target++; ones++;
                    Integer[] coord = new Integer[]{j,i};
                    old.push(coord);
                }
                else visit[j][i] = true;
            }
        }
        if(target==ones){
            System.out.println(0);
            return;
        }

        int count = 0;
        int T = ones;
        Stack<Integer[]> s = new Stack<>();
        while(true){
            s.clear();
            while(!old.isEmpty()){
                Integer[] cur = old.pop(); int m = cur[0]; int n = cur[1];
                for(int x=-1; x<=1; x+=2){
                    if(m+x>0 && m+x<=M){
                        if(!visit[m+x][n] && box[m+x][n]==0){
                            visit[m+x][n] = true;
                            T++;
                            Integer[] coord = new Integer[]{m+x,n};
                            s.push(coord);
                        }
                    }
                }
                for(int y=-1; y<=1; y+=2){
                    if(n+y>0 && n+y<=N){
                        if(!visit[m][n+y] && box[m][n+y]==0){
                            visit[m][n+y] = true;
                            T++;
                            Integer[] coord = new Integer[]{m,n+y};
                            s.push(coord);
                        }
                    }
                }
            }
            if(s.isEmpty()){
                if(T == target){
                    System.out.println(count);
                    break;
                }
                else{
                    System.out.println(-1);
                    break;
                }
            }
            old = (Stack<Integer[]>)s.clone();
            count++;
        }
    }
}
