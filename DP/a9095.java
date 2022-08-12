import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a9095 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int j=0; j<N; j++){
            int target = Integer.parseInt(br.readLine());
            int a=1, b=2, c=4;
            if(target>3){
                for(int i=4; i<=target; i++){
                    int temp = c;
                    c = a+b+c;
                    a=b; b=temp;
                }
                System.out.println(c);
            } else {
                switch(target){
                    case 1: System.out.println(1); break;
                    case 2: System.out.println(2); break;
                    case 3: System.out.println(4); break;
                }
            }
        }
    }
}