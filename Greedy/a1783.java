import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int num = 1;
        if(V>=3 && H>=7){
            num = H-2;
        } else if(V>=3 && H<7){
            num = H;
            if(num>4){
                num=4;
            }
        } else if(V==2){
            num = (H-1)/2+1;
            if(num>3){
                num=3;
            }
        }
        System.out.println(num);
    }
}