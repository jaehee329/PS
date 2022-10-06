import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a11729 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = (int)Math.pow(2,N)-1;
        hanoi(N, 1, 3);
        sb.setLength(sb.length()-1);
        System.out.println(K+"\n"+sb);
    }
    private static void hanoi(int N, int cur, int dest){
        if(N==1){
            sb.append(cur+" "+dest+"\n");
            return;
        }
        int preDest = 6-cur-dest; 
        hanoi(N-1, cur, preDest);
        sb.append(cur+" "+dest+"\n");
        hanoi(N-1, preDest, dest);
    }
}
