import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a3003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int[] need = {1, 1, 2, 2, 2, 8};
        for(int i=0; i<6; i++) {
            System.out.print((need[i]-Integer.parseInt(st.nextToken()))+" ");
        }
    }
}
