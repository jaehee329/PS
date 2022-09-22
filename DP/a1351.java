import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class a1351 {
    static HashMap<Long, Long> hashMap;
    static Long N;
    static Long P;
    static Long Q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        hashMap = new HashMap<>();
        hashMap.put(0L, 1L);
        Long A_n = dp(N);
        System.out.println(A_n);
    }
    private static Long dp(Long n){
        if(hashMap.containsKey(n)){
            return hashMap.get(n);
        } else {
            Long A_ip = dp((long)Math.floor(n/P));
            Long A_iq = dp((long)Math.floor(n/Q));
            hashMap.put(n, A_ip+A_iq);
            return A_ip+A_iq;
        }
    }
}
