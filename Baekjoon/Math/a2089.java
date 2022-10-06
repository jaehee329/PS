import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class a2089 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> r = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        if(N == 0){
            System.out.println(0);
            return;
        }
        while(N!=0){
            r.push(Math.abs(N%-2));
            N = (N-Math.abs(N%-2))/-2;
        }
        while(!r.empty()){
            sb.append(r.pop());
        }
        System.out.println(sb);
    }
}