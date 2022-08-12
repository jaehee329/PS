import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class a11721 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // 15 => 0~9, 10~14
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length()/10+1; i++){
            if(i==str.length()/10){
                sb.append(str.substring(10*i,str.length()));
            } else {
                sb.append(str.substring(10*i,10*(i+1))).append("\n");
            }
        }
        System.out.println(sb);
    }   
}
