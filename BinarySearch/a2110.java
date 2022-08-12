import java.util.*;
import java.io.*;

public class a2110 {
    static int[] map;
    static int N;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new int[N];
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        int max = map[N-1] - map[0] + 1; int min = 1;
        while(min<max){
            int mid = (max+min)/2;
            if(a(mid)) min = mid+1;
            else max = mid;
        }
        System.out.println(min-1);
    }
    static boolean a(int dist){
        int cnt = 1; int tag = map[0];
        for(int i=1; i<map.length; i++){
            if(map[i]>=dist+tag){
                tag = map[i]; cnt++;
            }
            if(cnt==C) return true;
        }
        return false;
    }
}