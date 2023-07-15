import java.io.*;
import java.util.*;

public class a26069 {

    private static final String CHONGCHONG = "ChongChong";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        Set<String> infected = new HashSet<>();
        infected.add(CHONGCHONG);

        StringTokenizer st;
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            String source = st.nextToken();
            String destination = st.nextToken();
            if (infected.contains(source)) {
                infected.add(destination);
            } else if (infected.contains(destination)) {
                infected.add(source);
            }
        }

        System.out.println(infected.size());
    }
}
