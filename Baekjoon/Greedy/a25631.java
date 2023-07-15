import java.io.*;
import java.util.*;

public class a25631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int matryoCount = Integer.parseInt(br.readLine());


        Map<Integer, Integer> matryo = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxDuplicate = 0;
        for (int i = 0; i < matryoCount; i++) {
            int size = Integer.parseInt(st.nextToken());
            int duplicate = 0;
            if (!matryo.containsKey(size)) {
                duplicate = 1;
                matryo.put(size, 1);
            } else {
                int previousCount = matryo.get(size);
                duplicate = previousCount + 1;
                matryo.put(size, duplicate);
            }
            maxDuplicate = Math.max(maxDuplicate, duplicate);
        }
        System.out.println(maxDuplicate);
    }
}
