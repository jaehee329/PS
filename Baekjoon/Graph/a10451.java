import java.util.*;
import java.io.*;

public class a10451 {
    static boolean[] visit;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tc = Integer.parseInt(st.nextToken());
        for(int t=0; t<tc; t++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int[] a = new int[L+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=L; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            int cycle = 0;
            visit = new boolean[L+1];
            for(int i=1; i<=L; i++){
                if(!visit[i]){
                    cycle++;
                    int current = i; visit[i] = true;
                    while(a[current]!=i){
                        current = a[current];
                        visit[current] = true;
                    }
                }
            }
            System.out.println(cycle);
        }
    }
}
