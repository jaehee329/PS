import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class a6588 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[100_0001];
        Arrays.fill(prime, true);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=100_0000; i++){
            for(int j = i * 2; j <= 100_0000; j += i) {
                if(!prime[j]) continue;
                prime[j] = false;
            }
        }
        while(true){
            boolean r = false;
            int a = Integer.parseInt(br.readLine());
            if(a==0) break;
            int i=3;
            while(true){
                if(prime[i]&&prime[a-i]){
                    sb.append(a).append(" = ").append(i).append(" + ").append(a-i).append("\n");
                    r = true;
                    break;
                }
                i++;
            }
            if(!r){
                System.out.println("Goldbach's conjecture is wrong.");
                break;
            }
        }
		System.out.print(sb);
    }
}