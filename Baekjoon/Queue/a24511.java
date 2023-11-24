import java.io.*;
import java.util.*;

public class a24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSize = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] stack = new boolean[totalSize];
        for (int i = 0; i < totalSize; i++) {
            int isStack = Integer.parseInt(st.nextToken());
            stack[i] = isStack == 1 ? true : false;
        }

        List<String> elements = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalSize; i++) {
            String element = st.nextToken();
            if (!stack[i]) {
                elements.add(element);
            }
        }

        Queue<String> q = new LinkedList<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            q.add(elements.get(i));
        }

        int inputSize = Integer.parseInt(br.readLine());
        StringJoiner sj = new StringJoiner(" ");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < inputSize; i++) {
            q.add(st.nextToken());
            sj.add(q.poll());
        }

        System.out.println(sj.toString());
    }
}
