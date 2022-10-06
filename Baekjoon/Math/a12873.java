import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class a12873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            arr.add(i);
        }
        int idx = 0;
        for (int i = 1; i < n; i++) {
            int tgt = (idx + pos(i, arr.size()) - 1) % arr.size();
            if (tgt < 0){
                tgt+=arr.size();
            }
            idx  = tgt;
            arr.remove(idx);
        }
        System.out.println(arr.get(0));
    }
    private static int pos(int i, int mod) {
        int ans = i;
        ans*=i;
        ans%=mod;
        ans*=i;
        return ans%mod;
    }
}