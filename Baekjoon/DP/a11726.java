import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a=1, b=1;
        if(N>1){
            for(int i=2;i<=N;i++){
                int c=b;
                b = (a+b)%10007; a=c;
            }
            System.out.println(b%10007);
        } else {
            System.out.println(1);
        }
    }
}