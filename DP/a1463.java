// bottom-up approach : timeout -> changed to top-down
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class a1463 {
    static Integer[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ans = new Integer[N+1]; ans[0]=0; ans[1]=0;
        System.out.println(func(N));
    }

    public static int func(int N){
        if(ans[N]==null){
            if(N%6==0){
                ans[N] = Math.min(Math.min(func(N/3), func(N/2)), func(N-1))+1;
            } else if(N%3==0){
                ans[N] = Math.min(func(N/3), func(N-1))+1;
            } else if(N%2==0){
                ans[N] = Math.min(func(N/2), func(N-1))+1;
            } else {
                ans[N] = func(N-1)+1;
            }
        }
        return ans[N];
    }
}
