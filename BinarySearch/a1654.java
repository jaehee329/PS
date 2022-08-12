import java.util.*;
import java.io.*;

public class a1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); int N = Integer.parseInt(st.nextToken());
        int[] lan = new int[K];
        long max = 0;
        for(int i=0; i<K; i++){
            lan[i] = Integer.parseInt(br.readLine());
            if(lan[i]>max) max = lan[i];
        }
        long min = 0; long mid = 0; max++;
        while(min<max){
            long cnt = 0; mid = (max+min)/2;
            for(int i=0; i<lan.length; i++) cnt+=lan[i]/mid;
            if(cnt<N) max = mid;
            else min = mid+1;
        }
        System.out.println(min-1);
    }        
}
