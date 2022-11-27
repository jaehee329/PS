// Set
import java.io.*;
import java.util.*;

public class a1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> notHeard = new HashSet<>();
        List<String> notSeenNotHeard = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String target = br.readLine();
            if (notHeard.contains(target)) {
                notSeenNotHeard.add(target);
            }
        }
        Collections.sort(notSeenNotHeard);
        System.out.println(notSeenNotHeard.size());
        notSeenNotHeard.stream().forEach(System.out::println);
    }
}