import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a1373 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine(); int l = s.length();
        if(l%3==1){
            sb.append(s.charAt(0));
        } else if (l%3==2){
            sb.append((s.charAt(0)-'0')*2+(s.charAt(1)-'0'));
        }
        for(int i=l%3; i<l; i+=3){
            sb.append((s.charAt(i)-'0')*4+(s.charAt(i+1)-'0')*2+(s.charAt(i+2)-'0'));
        }
        System.out.println(sb);
    }
}