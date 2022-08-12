import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a1212 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(s.charAt(0)-'0'));
        for(int i=1; i<s.length(); i++){
			String x = Integer.toBinaryString(s.charAt(i)-'0');
			if(x.length()==2){
                x="0"+x;
            }else if(x.length()==1){
                x="00"+x;
            }
			sb.append(x);
        }
        System.out.println(sb);
    }
}