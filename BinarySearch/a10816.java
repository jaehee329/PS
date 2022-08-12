import java.util.*;
import java.io.*;

public class a10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> have = new HashMap<>(N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int key = Integer.parseInt(st.nextToken());
            have.put(key, have.getOrDefault(key, 0)+1);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(have.getOrDefault(key, 0)+" ");
        }
        System.out.println(sb);
    }
}
