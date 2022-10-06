import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a1934 {
    private static ArrayList<Integer> ar;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            ar = new ArrayList<Integer>();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b=Integer.parseInt(st.nextToken());
            if(a==b){
                System.out.println(a);
            }else{
                ArrayList<Integer> pr = co(a,b);
                int ans = 1;
                for(int x :pr){ans*=x;}
                for(int x :ar){ans*=x;}
                System.out.println(ans);
            }
        }
    }
    private static ArrayList<Integer> co(int a, int b){
        int small = a<=b?a:b; int big = a>b?a:b; int i; boolean co=false;
        for(i=2; i<=small; i++){
            if(small%i==0 && big%i==0){
                ar.add(i);
                co=true;
                break;
            }
        }
        
        if(co){
            return co(a/i,b/i);
        } else {
            return new ArrayList<Integer>(Arrays.asList(a,b));
        }
    }
}