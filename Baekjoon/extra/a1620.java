import java.io.*;
import java.util.*;
public class a1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pokes = Integer.parseInt(st.nextToken());
        int probs = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> strInt = new HashMap<>();
        String[] intStr = new String[pokes+1];
        for (int i = 1; i <= pokes; i++) {
            String s = br.readLine();
            intStr[i] = s;
            strInt.put(s, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= probs; i++) {
            String s = br.readLine();
            try {
                int q = Integer.parseInt(s);
                sb.append(intStr[q]+"\n");
            } catch (Exception e) {
                sb.append(strInt.get(s)+"\n");
            }
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
