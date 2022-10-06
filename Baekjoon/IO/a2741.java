import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class a2741 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int str = Integer.parseInt(br.readLine()); // 15 => 0~9, 10~14
        for(int i=1; i<=str; i++){
            System.out.println(i);
        }
    }   
}
