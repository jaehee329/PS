// buffered reader endpoint : returning "null"
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a10952{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String str;
        while(true){
            str=br.readLine();
            st = new StringTokenizer(str," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if((a==0)&&(b==0)){
                break;
            } else{
                sb.append(a+b).append("\n");
            }
        }
        System.out.println(sb);
    }
}
