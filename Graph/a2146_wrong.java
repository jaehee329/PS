import java.util.*;
import java.io.*;

public class a2146_wrong {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        int[] x = new int[]{-1, 0, 0, 1};
        int[] y = new int[]{0, 1, -1, 0};
        int length = 2*N;
        boolean[][] visit;
        Queue<int[]> edge1 = new LinkedList<>();
        Queue<int[]> edge2 = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[j][i] == 1){
                    map[j][i] = -1;
                    visit = new boolean[N][N];
                    int[] coord = new int[]{j,i};
                    edge1.add(coord);
                    while(!edge1.isEmpty()){
                        int[] cur = edge1.poll();
                        for(int k=0; k<4; k++){
                            int Xnext = cur[0]+x[k]; int Ynext = cur[1]+y[k];
                            if(Xnext>=0 && Xnext<N && Ynext>=0 && Ynext<N){
                                if(map[Xnext][Ynext]==1){
                                    map[Xnext][Ynext] = -1;
                                    int[] a = new int[]{Xnext, Ynext};
                                    edge1.add(a);
                                } else if(map[Xnext][Ynext]==0 && !visit[Xnext][Ynext]){
                                    visit[Xnext][Ynext] = true;
                                    int[] a = new int[]{Xnext, Ynext};
                                    edge2.add(a);
                                }
                            }
                        }
                    }
                    edge1 = new LinkedList<>(edge2);
                    edge2.clear();
                    boolean flag = false;
                    int loop = 0;
                    while(loop<length && !flag){
                        loop++;
                        while(!edge1.isEmpty()){
                            int[] cur = edge1.poll();
                            for(int k=0; k<4; k++){
                                int Xnext = cur[0]+x[k]; int Ynext = cur[1]+y[k];
                                if(Xnext>=0 && Xnext<N && Ynext>=0 && Ynext<N){
                                    if(map[Xnext][Ynext]==0 && !visit[Xnext][Ynext]){
                                        visit[Xnext][Ynext] = true;
                                        int[] a = new int[]{Xnext, Ynext};
                                        edge2.add(a);
                                    } else if(map[Xnext][Ynext]==1){
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                        }
                        edge1 = new LinkedList<>(edge2);
                        edge2.clear();
                    }
                    length = (loop<length)?loop:length;
                }
            }
        }
        System.out.println(length);
    }
}