import java.util.*;
import java.io.*;

public class a4963 {
    static int w;
    static int h;
    static int[][] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w==0 && h==0) break;

            data = new int[w+1][h+1];
            for(int i=1; i<=h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=w; j++){
                    data[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            int num=0;
            boolean[][] visit = new boolean[w+1][h+1];
            for(int i=1; i<=h; i++){
                for(int j=1; j<=w; j++){
                    if(!visit[j][i]){
                        visit[j][i] = true;
                        if(data[j][i]==1){
                            num++;
                            Stack<Integer[]> s = new Stack<>();
                            Integer[] a = {j, i};
                            s.push(a);
                            while(!s.isEmpty()){
                                Integer[] current = s.pop();
                                int cw = current[0]; int ch = current[1];
                                for(int x =-1; x<=1; x++){
                                    for(int y=-1; y<=1; y++){
                                        if(cw+x>0 && cw+x<=w && ch+y>0 && ch+y<=h){
                                            if(!visit[cw+x][ch+y]){
                                                visit[cw+x][ch+y] = true;
                                                if(data[cw+x][ch+y]==1){
                                                    a = new Integer[]{cw+x, ch+y};
                                                    s.push(a);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sb.append(num+"\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
