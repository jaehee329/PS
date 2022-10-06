import java.util.*;
import java.io.*;

public class a2331 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken(); int P = Integer.parseInt(st.nextToken());
        int next = Integer.parseInt(A);
        TreeMap<Integer, Integer> D = new TreeMap<>();
        int count = 0;
        while(!D.containsValue(next)){
            D.put(count,next);
            int l = A.length();
            next = 0;
            for(int i=0; i<l; i++){
                next+=Math.pow(Integer.parseInt(A.substring(i, i+1)), P);
            }
            A = Integer.toString(next);
            count++;
        }
        count = 0;
        for(int key : D.keySet()){
            count++;
            int v = D.get(key);
            if(v == next) break;
        }
        System.out.println(count-1);
    }    
}
