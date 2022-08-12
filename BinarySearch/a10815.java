import java.util.*;
import java.io.*;

public class a10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] have = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            have[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(have);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int min; int max;
        for(int i=0; i<M; i++){
            min = 0; max = have.length-1; boolean flag = true;
            int target = Integer.parseInt(st.nextToken());
            while(min<=max){
                int mid = (min+max)/2;
                if(have[mid]>target) max = mid-1;
				else if(have[mid]<target) min = mid+1;
				else {
					sb.append("1 ");
					flag = false;
					break;
				}
            }
            if(flag) sb.append("0 ");
        }
        System.out.println(sb);
    }
}
