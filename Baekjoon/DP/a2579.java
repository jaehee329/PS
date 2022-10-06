import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class a2579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] dp1 = new int[N]; int[] dp2 = new int[N];
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        dp1[0]=dp2[0]=data[0];
        if(N>1){
            dp1[1]=data[1]; dp2[1]=dp1[0]+data[1];
        }
        for(int i=2; i<N; i++){
            dp1[i]=Math.max(dp1[i-2],dp2[i-2])+data[i];
            dp2[i]=dp1[i-1]+data[i];
        }
        System.out.println(Math.max(dp1[N-1],dp2[N-1]));
    }
}