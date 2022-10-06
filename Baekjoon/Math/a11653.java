import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a11653 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N==1) return;
        StringBuilder sb = new StringBuilder();
        while(true){
            boolean f = true;
            for(int i=2; i<=(int)Math.sqrt(N); i++){
                if(N%i==0){
                    N/=i;
                    sb.append(i).append("\n");
                    f = false;
                    break;
                }
            }
            if(f){
                sb.append(N);
                break;
            }  
        }
        System.out.println(sb);
    }
}