import java.io.*;
import java.util.*;

public class a11723 {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       int n = Integer.parseInt(br.readLine());
       int bitset = 0;

       while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num;
            switch (op){
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (num - 1));
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << (num - 1));
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (num - 1));
                    break;
                case "all" :
                    bitset |= (~0);
                    break;
                case "empty" :
                    bitset &= 0;
                    break;
            }
        }
        if (sb.length() > 0)
            sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}