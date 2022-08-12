import java.util.*;
import java.io.*;

public class a2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        int highest = 0;
        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            highest = tree[i]>highest ? tree[i] : highest;
        }

        int lowest = 0;
        int target = 0;
        long sum = 0;
        while(lowest<highest){
            sum = 0;
            target = (lowest+highest)/2;
            for(int hight : tree){
                sum += hight>target ? hight-target : 0;
            }
            if(sum<M){
                highest = target;
            } else {
                lowest = target+1;
        }
        System.out.println(lowest-1);
    }
}
