import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class a2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> d = new ArrayList<Integer>();

        for(int i=0; i<N; i++){
            d.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(d);
        for(int val : d){
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}