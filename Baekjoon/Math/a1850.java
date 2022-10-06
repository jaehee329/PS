import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a1850 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());
        Long x = A; Long y = B;
        while(y!=0){
            Long r = x%y;
            x = y; y = r;
        }
        for(int i=0; i<x; i++){
            sb.append(1);
        }
        System.out.println(sb);
    }
}