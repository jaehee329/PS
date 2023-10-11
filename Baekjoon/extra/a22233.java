import java.io.*;
import java.util.*;

public class a22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int keywords = Integer.parseInt(st.nextToken());
        int articles = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>(keywords);
        for (int i = 0; i < keywords; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < articles; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                set.remove(st.nextToken());
            }
            bw.write(set.size() + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
