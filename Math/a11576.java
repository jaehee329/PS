import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class a11576 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int num = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=N-1; i>=0; i--){
            num+=Math.pow(A, i) * Integer.parseInt(st.nextToken());
        }

        if(num==0){
            System.out.println(0);
            return;
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int l = 1;
        while(num!=0){
            int temp = num % (int)Math.pow(B, l);
            list.add(temp/(int)Math.pow(B, l-1));
            num-=temp;
            l++;
        }
        Collections.reverse(list);
        String str = list.toString().replaceAll("[^0-9 ]", "");
        System.out.println(str);
    }
}