import java.io.*;
import java.util.*;

public class a1068 {
    private static int N;
    private static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int init = -1;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (t == -1) {
                init = i;
            } else {
                tree.get(t).add(i);
            }
        }
        int deletion = Integer.parseInt(br.readLine());
        int leaf = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(init);
        while (!q.isEmpty()) {
            int parent = q.poll();
            if (parent == deletion) {
                continue;
            }
            List<Integer> childList = tree.get(parent);
            if (childList.size() == 0 || childList.get(0) == deletion) {
                leaf++;
                continue;
            }
            for (int i : childList) {
                if (i != deletion) {
                    q.add(i);
                }
            }
        }
        System.out.println(leaf);
    }
}